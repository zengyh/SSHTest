package edu.action.user;

import java.io.InputStream;
import com.opensymphony.xwork2.ActionSupport;
import edu.service.UserService;

public class GenerateExcelAction extends ActionSupport{

	private static final long serialVersionUID = -3061171643125977707L;
	private UserService userservice;
	
	public UserService getUserservice() {
		return userservice;
	}


	public void setUserservice(UserService userservice) {
		this.userservice = userservice;
	}


	public InputStream getDownloadFile(){
		return this.userservice.getInputStream();
	}
	
	
	@Override
    public String execute() throws Exception {
    	// TODO Auto-generated method stub
    	return "success";
    }
}
