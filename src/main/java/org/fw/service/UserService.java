package org.fw.service;

import org.fw.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * File created by FrankWeapon on 9/8/16 for ssh.
 * Email: helldarkfire@gmail.com
 */

@Service
public class UserService {

    @Autowired
    UserDao userDao;
}
