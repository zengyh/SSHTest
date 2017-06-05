package edu.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import edu.dao.UserDao;
import edu.po.User;
import edu.service.UserService;
import edu.vo.UserVO;

public class UserServiceImpl implements UserService {

	public UserDao userdao;

	public UserDao getUserdao() {
		return userdao;
	}

	public void setUserdao(UserDao userdao) {
		this.userdao = userdao;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userdao.findAll();
	}

	@Override
	public void save(UserVO uservo) {
		// TODO Auto-generated method stub
        User user = new User();
        user.setPassword(uservo.getPassword());
        user.setUsername(uservo.getUsername());
        userdao.save(user);
	}
	
	public InputStream getInputStream(){
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet =  wb.createSheet("sheet1");
		HSSFRow row = sheet.createRow(0);
		row.createCell(0).setCellValue("序号");
		row.createCell(1).setCellValue("用户名");
		row.createCell(2).setCellValue("密码");
		
		int index = 1;
		List<User> userlist = findAll();
		Iterator<User> iterator = userlist.iterator();
	    while(iterator.hasNext()){
	    	User user = iterator.next();
	    	row = sheet.createRow(index);
	    	row.createCell(0).setCellValue(user.getId());
			row.createCell(1).setCellValue(user.getUsername());
			row.createCell(2).setCellValue(user.getPassword());
	    	index++;
	    }

/* 方法一: */
/*	   ByteArrayOutputStream bos = new ByteArrayOutputStream();
	   try {
		   wb.write(bos);
	   } catch (IOException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
	   } 
	   byte content[] = bos.toByteArray();
	   
	   InputStream inputstream = new ByteArrayInputStream(content);
	   try {
		   bos.close();
	   } catch (IOException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
	   } */
	    
/* 方法二: */    
	    String filename = RandomStringUtils.randomAlphanumeric(10);
	    final File file = new File(filename+".xls");
	       
	    try {
			FileOutputStream fos = new FileOutputStream(file);
			wb.write(fos);
			fos.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		InputStream inputstream = null;
	    
		try {
			inputstream = new FileInputStream(file);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		new Thread(
		   new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					Thread.sleep(15000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				file.delete(); //删除临时文件
			}
			   
		   }
	    ).start();
		
		return inputstream;
	}

}
