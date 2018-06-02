package com.chenjie.springbootgirl.service.impl;

import com.chenjie.springbootgirl.repository.GirlRepository;
import com.chenjie.springbootgirl.service.GirlService;
import com.chenjie.springbootgirl.vo.Girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author chenjie
 * @Date 2018/6/1 23:45
 * @Description:
 */
@Service
public class GirlServiceImpl implements GirlService {

    @Autowired
    private GirlRepository girlRepository;
    @Override
    public List<Girl> findAll() {
        return girlRepository.findAll();
    }

    @Override
    public Girl findGirlById(Integer id) {
        Girl girl = girlRepository.findById(id).orElse(null);
        return girl;
    }

    @Override
    public Girl girlAddOrUpdate(Girl girl) {
        Girl savedOrUpdatedGirl = girlRepository.save(girl);
        return savedOrUpdatedGirl;
    }

    @Override
    public void deleteAGirlByID(Integer id) {
        Girl girl = new Girl();
        girl.setId(id);
        girlRepository.delete(girl);
    }
}
