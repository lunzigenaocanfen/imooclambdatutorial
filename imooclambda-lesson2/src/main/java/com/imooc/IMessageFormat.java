package com.imooc;

/**
 * 消息传输格式化转换接口
 */
@FunctionalInterface
public interface IMessageFormat {
    /**
     * 消息转换方法
     * @param message 要转换的消息
     * @param foramt 转化的格式
     * @return 返回转换后的数据
     */
    String format(String message,String foramt);

    /**
     * 消息合法性验证方法
     * @param msg 要验证的消息
     * @return 返回验证结果
     */
    static boolean verifyMessage(String msg){
        if (msg != null) {
            return true;
        }
        return false;
    }

}
