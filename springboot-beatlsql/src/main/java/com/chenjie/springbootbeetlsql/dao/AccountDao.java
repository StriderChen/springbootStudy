package com.chenjie.springbootbeetlsql.dao;

import com.chenjie.springbootbeetlsql.vo.Account;
import org.beetl.sql.core.annotatoin.SqlStatement;
import org.beetl.sql.core.mapper.BaseMapper;

/**
 * @Author chenjie
 * @Date 2018/5/27 16:36
 * @Description:
 */
public interface AccountDao extends BaseMapper<Account> {

    @SqlStatement(params = "name")
    Account selectAccountByName(String name);
}
