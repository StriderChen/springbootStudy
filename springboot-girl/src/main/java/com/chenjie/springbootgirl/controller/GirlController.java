package com.chenjie.springbootgirl.controller;

import com.chenjie.springbootgirl.service.GirlService;
import com.chenjie.springbootgirl.vo.Girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author chenjie
 * @Date 2018/6/1 23:13
 * @Description:
 */
@RestController
public class GirlController {

    @Autowired
    private GirlService girlService;


    /**查询所有女生*/
    @GetMapping(value = "/girls")
    public List<Girl> findAll(){
        return girlService.findAll();
    }

    /**
     * 添加一个女生
     * @param cupSize
     * @param age
     * @return
     */
    @PostMapping(value = "/girls")
    public Girl girlAdd(@RequestParam("cupSize") String cupSize,@RequestParam("age")Integer age){
        Girl girl = new Girl();
        girl.setAge(age);
        girl.setCupSize(cupSize);

        Girl savedGirl = girlService.girlAddOrUpdate(girl);
        return savedGirl;
    }

    /**
     * 查询一个女生
     * @param id
     * @return
     */
    @GetMapping(value = "/girls/{id}")
    public Girl findGirlById(@PathVariable("id") Integer id) {
        Girl girl = girlService.findGirlById(id);
        return girl;
    }

    /**
     * 更新一个女生,用put提交
     * @param id
     * @param cupSize
     * @param age
     * @return
     */
    @PutMapping(value = "/girls/{id}")
    public Girl updateAGril(@PathVariable("id")Integer id,
                              @RequestParam("cupSize")String cupSize,
                              @RequestParam("age")Integer age) {
        Girl girl = new Girl();
        girl.setCupSize(cupSize);
        girl.setAge(age);
        girl.setId(id);
        Girl updatedGirl = girlService.girlAddOrUpdate(girl);
        return updatedGirl;
    }

    /**
     * 删除一个女生
     * @param id
     */
    @DeleteMapping(value = "/girls/{id}")
    public void deleteAGirl(@PathVariable("id")Integer id) {
        girlService.deleteAGirlByID(id);
    }
}
