package com.chenjie.springbootjdbc.service;

import com.chenjie.springbootjdbc.vo.Account;

import java.util.List;

/**
 * @author chenjie
 * @date 2018/5/19 22:08
 * @description:
 */
public interface IAccountService {

    int add(Account account);

    int update(Account account);

    int delete(int id);

    Account findAccountById(int id);

    List<Account> findAccountList();
}

