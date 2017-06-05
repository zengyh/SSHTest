<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  
  <body>
    <s:form action="saveUser"  method="post" >
      <s:textfield name="uservo.username"  value="%{uservo.username}" label="%{getText('username')}"></s:textfield>
      <s:password name="uservo.password"  value="%{uservo.username}" label="%{getText('password')}"></s:password>
      <s:submit value="保存"></s:submit>
    </s:form>
    <s:a href="listUser.action">查看所有用户</s:a>
  </body>
</html>
