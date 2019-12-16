package com.imooc;

/**
 * 用户身份认证标记接口
 */
@FunctionalInterface
public interface IUserCredential {
    /**
     * 通过用户账号，验证用户身份信息的接口
     * @param userName 要验证的用户账号
     * @return 返回身份信息[系统管理员、用户管理员、普通管理员]
     */
    String verifyUser(String userName);

    default String getCredential(String userName) {
        // 模拟方法
        if ("admin".equals(userName)) {
            return "admin"+"系统管理员用户";
        } else if ("manager".equals(userName)) {
            return "manager" + "用户管理元用户";
        } else {
            return "commons" +"普通会员用户";
        }

    }

}
