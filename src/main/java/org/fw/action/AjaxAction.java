package org.fw.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * File created by FrankWeapon on 9/8/16 for ssh.
 * Email: helldarkfire@gmail.com
 */
@ParentPackage("json-default")
public class AjaxAction extends ActionSupport{
    private String firstName;
    private String lastName;
    private String location;
    private String jsonRequestdata;

    @Override
    @Action(value = "/jqueryAJAXAction",
            results = { @Result(name = "success", type = "json") })
    public String execute() throws Exception {

        //Pull request data
        JSONObject json = (JSONObject)new JSONParser()
                .parse(jsonRequestdata);
        System.out.println("First Name=" + json.get("firstName"));
        System.out.println("Last Name=" + json.get("lastName"));
        System.out.println("Location=" + json.get("location"));

        //Set data in response
        setFirstName("Java");
        setLastName("Honk");
        setLocation("NY");
        return SUCCESS;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getJsonRequestdata() {
        return jsonRequestdata;
    }

    public void setJsonRequestdata(String jsonRequestdata) {
        this.jsonRequestdata = jsonRequestdata;
    }
}
