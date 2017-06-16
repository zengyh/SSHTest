package edu.action.user;

import java.util.ArrayList;
import com.opensymphony.xwork2.ActionSupport;
import edu.po.Users;
import edu.service.UserService;
import edu.vo.UserVO;

public class SaveUserAction extends ActionSupport{

	private static final long serialVersionUID = -1651073557745396752L;
	
	private UserService  userservice;
    public UserVO uservo;
    public ArrayList<Users> userlist;

	public UserVO getUservo() {
		return uservo;
	}

	public void setUservo(UserVO uservo) {
		this.uservo = uservo;
	}

	public UserService getUserservice() {
		return userservice;
	}

	public void setUserservice(UserService userservice) {
		this.userservice = userservice;
	}
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		this.userservice.save(uservo);
		userlist = (ArrayList<Users>) this.userservice.findAll();
		return "success";
	}
}
