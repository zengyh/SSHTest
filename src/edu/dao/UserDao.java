package edu.dao;

import java.util.List;
import edu.po.User;

public interface UserDao {
	
   public List<User>  findAll();
  
   public User findById(Integer id);
   
   public void save(User user);
   
   public void update(User user);
   
   public void delete(User user);
   
}
