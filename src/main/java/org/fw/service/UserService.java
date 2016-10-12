package org.fw.service;

import org.fw.dao.UserDao;
import org.fw.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * File created by FrankWeapon on 9/8/16 for ssh.
 * Email: helldarkfire@gmail.com
 */

@Transactional
@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public User login(User user){
        return userDao.login(user.getUsername(),user.getPassword());
    }
}
