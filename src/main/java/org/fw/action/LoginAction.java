package org.fw.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.fw.entity.User;
import org.fw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * File created by FrankWeapon on 9/8/16 for ssh.
 * Email: helldarkfire@gmail.com
 */
@Namespace("/User")
@ResultPath(value = "/")
@Controller
@Scope("prototype")
public class LoginAction extends ActionSupport{

    User user;

    @Autowired
    UserService userService;

    @Action(value = "welcome", results = {
            @Result(name = "success", location = "/welcome.jsp")
    })
    public String execute(){
        System.out.println(user);
        return SUCCESS;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
