<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.io.FileWriter" import="java.io.IOException" import="java.util.Date" import="java.text.SimpleDateFormat"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<body>
<%String adr =request.getRemoteAddr(); %>
<form action="login" method="post">
<br>User ID  :  <input type="text" name="userId" />
<br>Password : <input type="password" name="password" />
<br>Your ip address : <%=adr %>
<br><input type="submit" />
</form>

<%
//запись в лог

String date = new java.util.Date ().toString ();
try(FileWriter writer = new FileWriter("C:\\Log\\log.txt", true))
{
    // запись всей строки
     String tex = " Время входа : ";
     String text = adr;
     writer.write(text);
     writer.write(tex);
     writer.append(date);
     // запись по символам
      writer.append('\r');
     writer.append('\n');
    
      
     writer.flush();
 }
 catch(IOException ex){
      
     System.out.println(ex.getMessage());
 }  %>


</body>
</html>