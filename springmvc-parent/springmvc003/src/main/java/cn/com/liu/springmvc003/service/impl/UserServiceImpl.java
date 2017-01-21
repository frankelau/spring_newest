package cn.com.liu.springmvc003.service.impl;

import cn.com.liu.springmvc003.controller.HelloWorld;
import cn.com.liu.springmvc003.entity.User;
import cn.com.liu.springmvc003.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by liuzh on 2017/1/21.
 */
@Service
public class UserServiceImpl implements UserService{
    @Override
    public User queryUserInfoById(String userId) {
        return null;
    }
}
