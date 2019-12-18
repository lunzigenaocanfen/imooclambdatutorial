package com.imooc.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Copyright (C), 2018-2019, copyright info. DAMU., Ltd.
 * FileName: com.test Test2
 * <p>Stream概述</p>
 *
 * @author <a href="http://blog.csdn.net/muwenbin_flex">大牧莫邪</a>
 * @version 1.00
 */
public class Test2 {
    public static void main(String[] args) {
        // 1. 添加测试数据：存储多个账号的列表
        List<String> accounts = new ArrayList<String>();
        accounts.add("tom");
        accounts.add("jerry");
        accounts.add("beita");
        accounts.add("shuke");
        accounts.add("damu");

        // 1.1. 业务要求：长度大于等于5的有效账号
        for (String account : accounts) {
            if (account.length() >= 5) {
                System.out.println("有效账号："  + account);
            }
        }

        // 1.2. 迭代方式进行操作
        Iterator<String> it = accounts.iterator();
        while(it.hasNext()) {
            String account = it.next();
            if (account.length() >= 5) {
                System.out.println("it有效账号：" + account);
            }
        }

        // 1.3. Stream结合lambda表达式，完成业务处理
        List validAccounts = accounts.stream().filter(s->s.length()>=5).collect(Collectors.toList());
        System.out.println(validAccounts);

    }
}
