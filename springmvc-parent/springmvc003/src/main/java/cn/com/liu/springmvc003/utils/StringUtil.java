package cn.com.liu.springmvc003.utils;

import com.google.common.base.Strings;

/**
 * Created by liuzh on 2017/1/21.
 */
public class StringUtil {

    /**
     * 格式化姓名
     *
     * @param name
     * @return
     */
    public static String formatName(String name) {
        if (null != name && !"".equals(name)) {
            return name.substring(0, 1) + "**";
        } else {
            return "";
        }
    }

    /**
     * 格式化登录信息
     *
     * @param userLogin
     * @return
     */
    public static String formatUserLogin(String userLogin) {
        if (null != userLogin && !"".equals(userLogin)) {
            if (userLogin.length() > 3) {
                return userLogin.substring(0, 1) + "***" + userLogin.substring(userLogin.length() - 1, userLogin.length());
            } else {
                return Strings.padEnd(userLogin.substring(0, 1),3,'*');
            }
        } else {
            return "";
        }
    }

}
