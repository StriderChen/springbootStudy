package com.chenjie.springbootjdbc.dao;

import com.chenjie.springbootjdbc.vo.Account;

import java.util.List;

/**
 * @author chenjie
 * @date 2018/5/19 0:21
 * @description:
 */
public interface IAccountDao {

    int add(Account account);

    int update(Account account);

    int delete(int id);

    Account findAccountById(int id);

    List<Account> findAccountList();
}
