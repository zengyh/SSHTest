package edu.service;

import java.io.InputStream;
import java.util.List;

import edu.po.Users;
import edu.vo.UserVO;

public interface UserService {
	
	   public List<Users>  findAll();
	     
	   public void save(UserVO uservo);
	   
	   public InputStream getInputStream();
}
