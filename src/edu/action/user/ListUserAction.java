package edu.action.user;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

import edu.po.User;
import edu.service.UserService;

public class ListUserAction extends ActionSupport {

	private static final long serialVersionUID = -5919063614671472698L;

    public ArrayList<User> userlist;
    public UserService userservice;

	public UserService getUserservice() {
		return userservice;
	}

	public void setUserservice(UserService userservice) {
		this.userservice = userservice;
	}

	public ArrayList<User> getUserlist() {
		return userlist;
	}

	public void setUserlist(ArrayList<User> userlist) {
		this.userlist = userlist;
	}
    
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		userlist = (ArrayList<User>) this.userservice.findAll();
		return "success";
	}
	
}
