package com.imooc.impl;

import com.imooc.IUserCredential;

public class UserCredentialImpl implements IUserCredential {

    @Override
    public String verifyUser(String userName) {
        if ("admin".equals(userName)) {
            return "系统管理员";
        } else if ("manager".equals(userName)) {
            return "用户管理员";
        }
        return "普通会员";
    }
}
