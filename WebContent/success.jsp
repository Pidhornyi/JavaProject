<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="org.artem.javaproject.dto.User" import="org.artem.javaproject.dto.View" import="org.artem.javaproject.service.LoginService " %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Global change!!!</title>
<style type="text/css">
   body * { outline: 0; padding: 0; margin: 0; } 
   #sidebar, #content { position: absolute; } 
   #sidebar, #content { overflow: auto; padding: 10px; }
   #header {
    height: 80px; /* Высота слоя */
    background: #FEDFC0; border-bottom: 2px solid #7B5427;
   }
   #header h1 { padding: 20px; margin: 0; }
   #sidebar { 
    width: 150px; background: #ECF5E4; border-right: 1px solid #231F20;
    top: 82px; /* Расстояние от верхнего края */ 
    bottom: 0; /* Расстояние снизу  */
   }
   #content {
    top: 92px; /* Расстояние от верхнего края */
    left: 270px; /* Расстояние от левого края */ 
    bottom: 0; right: 0;
   }
  </style>
</head>
<body>
<%String ID =(String) session.getAttribute("savedUserName");
if(ID==null)ID="1";

boolean ts =ID.equals("q");
boolean ts1 =ID.equals("admin");
if(ts || ts1){
}
else response.sendRedirect("login.jsp");
 %>

<h3>Global change</h3>

<%
//User user =(User) request.getAttribute("user");
//%>

<jsp:useBean id="user" class="org.artem.javaproject.dto.User" scope="request">
<jsp:setProperty property="userName" name="user" value="NewUser"/>
</jsp:useBean>






<br> <br>Добавить Работника  
<form action="AddServlet" method="post">
<br>Name  :  <input type="text" name="name" />
<br>BR    :  <input type="text" name="br" />
<br><input type="submit" value="add" />
</form>

<br>Удалить Работника
<form action="DeleteServlet" method="post">
<br>Name  :  <input type="text" name="name" />
<br><input type="submit" value="delete" />
</form>

<%
LoginService loginService = new LoginService();
View view= new View();
view = loginService.getNamefromDB();

%>


<div id="content">
<table border="1">
   <caption>Работники</caption>
   <tr>
    <th>Name</th>
    <th>Br</th>
   </tr>
   <% 
   for(int i=0;i<view.size();i++){ %>
  
   <tr><td><%=view.getName(i) %></td><td><%=view.getBr(i) %></td></tr>
  
  <% }%>
  
   </table>
</div>
<form action="LoadingServlet" method="post">
<br><input type="submit" value="Global change" />
</form>

<form method="post" action="CalendarServlet">
   <input type="submit" value=" График"/>
   </form>

</body>
</html>