package com.imooc.impl;

import com.imooc.IMessageFormat;

public class MessageFormatImpl implements IMessageFormat {
    @Override
    public String format(String message, String foramt) {
        System.out.println("消息转换");
        return message;
    }
}
