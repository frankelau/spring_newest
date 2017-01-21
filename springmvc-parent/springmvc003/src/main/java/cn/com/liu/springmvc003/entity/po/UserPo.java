package cn.com.liu.springmvc003.entity.po;

import cn.com.liu.springmvc003.entity.User;
import cn.com.liu.springmvc003.utils.StringUtil;

/**
 * Created by liuzh on 2017/1/21.
 */
public class UserPo {
    /*用户ID*/
    private String userId;
    /*登录名*/
    private String userLogin;
    /*用户名*/
    private String userName;
    /*用户ID*/
    private String userId_coloumn;
    /*登录名*/
    private String userLogin_coloumn;
    /*用户名*/
    private String userName_coloumn;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId_coloumn() {
        return userId;
    }


    public String getUserLogin_coloumn() {
        return StringUtil.formatUserLogin(userLogin);
    }


    public String getUserName_coloumn() {
        return StringUtil.formatUserLogin(userName);
    }

    @Override
    public String toString() {
        return "UserPo{" +
                "userId='" + userId + '\'' +
                ", userLogin='" + userLogin + '\'' +
                ", userName='" + userName + '\'' +
                ", userId_coloumn='" + userId_coloumn + '\'' +
                ", userLogin_coloumn='" + userLogin_coloumn + '\'' +
                ", userName_coloumn='" + userName_coloumn + '\'' +
                '}';
    }
}
