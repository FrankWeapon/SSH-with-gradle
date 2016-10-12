package org.fw.dao;

import org.fw.entity.User;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 * File created by FrankWeapon on 9/8/16 for ssh.
 * Email: helldarkfire@gmail.com
 */

@Repository
public class UserDao extends BaseDao<User,Integer>{

    public User login(String username, String password){
        Query query = getSession().createQuery("from User where username=? and password=?");
        query.setParameter(0,username);
        query.setParameter(1,password);
        return (User)query.uniqueResult();
    }
}
