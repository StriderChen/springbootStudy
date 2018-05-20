package com.chenjie.springbootjdbc.controller;

import com.chenjie.springbootjdbc.service.IAccountService;
import com.chenjie.springbootjdbc.vo.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author chenjie
 * @Date 2018/5/19 22:54
 * @Description:
 */
@RestController
@RequestMapping(value = "/account")
public class AccountConroller {

    @Autowired
    private IAccountService accountService;

    @GetMapping(value = "/list")
    public List<Account> getAccounts(){
        return accountService.findAccountList();
    }

    @GetMapping(value = "/{id}")
    public Account getAccountById(@PathVariable("id") int id){
        return accountService.findAccountById(id);
    }

    //TODO 前端用put提交,后台接收不到参数是什么鬼
    @PutMapping(value = "/{id}")
    public String updateAccount(@PathVariable("id")int id,@RequestParam(value ="name",required=false)String name,
                                @RequestParam(value="money",required=false)Double money){
        Account account=new Account();
        account.setMoney(money);
        account.setName(name);
        account.setId(id);
        int t=accountService.update(account);
        if(t==1){
            return account.toString();
        }else {
            return "update account fail";
        }
    }

    @PostMapping(value = "")
    public String addAccount(@RequestParam(value = "name")String name,
                             @RequestParam(value = "money" )Double money){
        Account account=new Account();
        account.setMoney(money);
        account.setName(name);
        int t= accountService.add(account);
        if(t==1){
            return account.toString();
        }else {
            return "add account fail";
        }
    }

}
