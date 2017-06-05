package edu.service;

import java.io.InputStream;
import java.util.List;

import edu.po.User;
import edu.vo.UserVO;

public interface UserService {
	
	   public List<User>  findAll();
	     
	   public void save(UserVO uservo);
	   
	   public InputStream getInputStream();
}
