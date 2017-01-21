package cn.com.liu.springmvc003.entity;

/**
 * 用户信息
 * Created by liuzh on 2017/1/21.
 */
public class User {
    /*用户ID*/
    private String userId;
    /*登录名*/
    private String userLogin;
    /*用户名*/
    private String userName;

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

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userLogin='" + userLogin + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
