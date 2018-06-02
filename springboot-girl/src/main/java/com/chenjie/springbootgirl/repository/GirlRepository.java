package com.chenjie.springbootgirl.repository;

import com.chenjie.springbootgirl.vo.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author chenjie
 * @Date 2018/6/1 23:14
 * @Description:
 */
public interface GirlRepository extends JpaRepository<Girl,Integer> {
}
