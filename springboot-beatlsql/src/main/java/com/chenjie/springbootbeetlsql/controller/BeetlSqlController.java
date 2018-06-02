package com.chenjie.springbootbeetlsql.controller;

import com.chenjie.springbootbeetlsql.dao.AccountDao;
import com.chenjie.springbootbeetlsql.vo.Account;
import org.beetl.sql.core.db.KeyHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author chenjie
 * @Date 2018/5/27 16:41
 * @Description:
 */
@RestController
@RequestMapping("account")
public class BeetlSqlController {

    @Autowired
    private AccountDao accountDao;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<Account> getAccounts(){
        return accountDao.all();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public  Account getAccountById(@PathVariable("id") int id){
        return accountDao.unique(id);
    }

    @RequestMapping(value = "",method = RequestMethod.GET)
    public  Account getAccountById(@RequestParam("name") String name){
        return accountDao.selectAccountByName(name);
    }

    /**
     *
     * put方式提交,后台依然拿不到参数,什么鬼
     * 查了资料,发现写法没有问题,使用put提交的时候,不能使用form-data,
     * 要使用x-www-form-urlencoded
     *
     * */
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public  String updateAccount(@PathVariable("id")int id , @RequestParam(value = "name",required = true)String name,
                                 @RequestParam(value = "money" ,required = true)double money){
        Account account=new Account();
        account.setMoney(money);
        account.setName(name);
        account.setId(id);
        int t=accountDao.updateById(account);
        if(t==1){
            return account.toString();
        }else {
            return "fail";
        }
    }

    @RequestMapping(value = "",method = RequestMethod.POST)
    public  String postAccount( @RequestParam(value = "name")String name,
                                @RequestParam(value = "money" )double money) {
        Account account = new Account();
        account.setMoney(money);
        account.setName(name);
        KeyHolder t = accountDao.insertReturnKey(account);
        if (t.getInt() > 0) {
            return account.toString();
        } else {
            return "fail";
        }
    }

}
