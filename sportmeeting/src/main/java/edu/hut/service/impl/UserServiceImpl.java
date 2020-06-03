package edu.hut.service.impl;

import edu.hut.dao.UserDao;
import edu.hut.domain.User;
import edu.hut.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("UserService")
public class UserServiceImpl implements UserService {

    @Resource(name = "UserDao")
    private UserDao userDao;

    @Override
    public User findById(int id) {
        return userDao.findById(id);
    }

    @Override
    public User login(String username, String password) {
        return userDao.login(username,password);
    }
}
