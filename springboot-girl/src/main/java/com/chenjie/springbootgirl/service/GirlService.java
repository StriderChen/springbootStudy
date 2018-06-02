package com.chenjie.springbootgirl.service;

import com.chenjie.springbootgirl.vo.Girl;

import java.util.List;

/**
 * @Author chenjie
 * @Date 2018/6/1 23:44
 * @Description:
 */
public interface GirlService {

    /**
     * 查询所有女生
     * @return
     */
    List<Girl> findAll();

    /**
     * 根据id来查询女生
     * @param id
     * @return
     */
    Girl findGirlById(Integer id);

    /**
     * 增加/更新 一个女生
     * @param girl
     * @return
     */
    Girl girlAddOrUpdate(Girl girl);


    /**
     * 删除一个女生
     * @param id
     */
    void deleteAGirlByID(Integer id);
}
