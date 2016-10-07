<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="org.artem.javaproject.service.CalendarService" import="org.artem.javaproject.dto.Calendar"
    import="java.util.Date" import="java.io.FileWriter" import="java.io.IOException" import="java.text.SimpleDateFormat"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
body * { outline: 0; padding: 0; margin: 0; } 
   #sidebar, #content, #content1, #content2, #content3, #content4, #content5, #content6, #content7 { position: absolute; } 
   #sidebar, #content, #content1, #content2, #content3, #content4, #content5, #content6, #content7 { overflow: auto; padding: 10px; }
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
    top: 240px; /* Расстояние от верхнего края */
    left: 50px; /* Расстояние от левого края */ 
    bottom: 0; right: 0;
   }
   #content1 {
    top: 240px; /* Расстояние от верхнего края */
    left: 180px; /* Расстояние от левого края */ 
    bottom: 0; right: 0;
   }
   #content2 {
    top: 240px; /* Расстояние от верхнего края */
    left: 320px; /* Расстояние от левого края */ 
    bottom: 0; right: 0;
   }
   #content3 {
    top: 240px; /* Расстояние от верхнего края */
    left: 460px; /* Расстояние от левого края */ 
    bottom: 0; right: 0;
   }
   #content4 {
    top: 240px; /* Расстояние от верхнего края */
    left: 590px; /* Расстояние от левого края */ 
    bottom: 0; right: 0;
   }
   #content5 {
    top: 240px; /* Расстояние от верхнего края */
    left: 730px; /* Расстояние от левого края */ 
    bottom: 0; right: 0;
   }
   #content6 {
    top: 240px; /* Расстояние от верхнего края */
    left: 870px; /* Расстояние от левого края */ 
    bottom: 0; right: 0;
   }
   #content7 {
    top: 260px; /* Расстояние от верхнего края */
    left: 10px; /* Расстояние от левого края */ 
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
 <%
//запись в лог
String adr =request.getRemoteAddr(); 
String date = new java.util.Date ().toString ();
try(FileWriter writer = new FileWriter("C:\\Log\\LogCalendar.txt", true))
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
<%
CalendarService calendarService = new CalendarService();
Calendar calendar= new Calendar();

int j =calendar.carrentDate();
calendar = calendarService.getFromDB(j);

%>


<table border="1">
   <caption>Рабочие недели The time is:<%=new Date() %></caption>
   <tr>
    <th>Week № :<%=(j)%></th>
    <th>Week № :<%=(1+j)%></th>
    <th>Week № :<%=(j+2)%></th>
    <th>Week № :<%=(j+3)%></th>
    <th>Week № :<%=(j+4)%></th>
    <th>Week № :<%=(j+5)%></th>
    <th>Week № :<%=(j+6)%></th>
   </tr>
   
  
  <tr> <%for(int k=0;k<7;k++){ %>
  <td><%for(int i=0; i<6;i++){%>Name :<%=calendar.getName(i)%><br> <%} %>
  <br>BR :<%=calendar.getBr(0)%> BR :<%=calendar.getBr(3)%><br> Date :<%=calendar.getDate(0)%><br> Week № :<%=calendar.getWeekofyear(1)%> </td>
  <%
  j++;
  calendar = calendarService.getFromDB(j); %>
  
  <%} %>
  </tr>
   </table>
   
   <%CalendarService calendarService2 = new CalendarService();
   Calendar calendar2= new Calendar(); 
   int j2 =calendar2.carrentDate();
   
   %>
   
   <form method="post" action="CalendarServlet">
  <div id="content"> <input type="radio" name="prof" value="<%=j2 %>" checked><%=j2 %></input></div>
   <div id="content1"><input type="radio" name="prof" value="<%=(1+j2) %>"><%=(1+j2) %></input></div>
   <div id="content2"><input type="radio" name="prof" value="<%=(2+j2) %>"><%=(2+j2) %></input></div>
  <div id="content3"> <input type="radio" name="prof" value="<%=(3+j2) %>"><%=(3+j2) %></input></div>
   <div id="content4"><input type="radio" name="prof" value="<%=(4+j2) %>"><%=(4+j2) %></input></div>
  <div id="content5"> <input type="radio" name="prof" value="<%=(5+j2) %>"><%=(5+j2) %></input></div>
   <div id="content6"><input type="radio" name="prof" value="<%=(6+j2) %>"><%=(6+j2) %></input></div>
   <div id="content7"><input type="submit" value="Вывести неделю"/></div>
   </form>
   
   <%calendar2 = calendarService2.getFromDB2(j2); %>
   <br><br><table border="2">
   <caption><%=j2 %> Неделя</caption>
   <tr>
    <th>Понедельник</th>
    <th>Вторник</th>
    <th>Среда</th>
    <th>Четверг</th>
    <th>Пятница</th>
    <th>Суббота</th>
    <th>Воскресенье</th>
   </tr>
   <tr>
   <% int i;
   for( i =0;i<=6;i++){%>
   <td><%for(int jj=i;jj<42;){ %>Name :<%=calendar2.getName(jj)%>  <%jj=jj+7; %><br>     <%}%><br> Date :<%=calendar2.getDate(i)%></td>
   <%} %>
   </tr>
   
   </table>
   
 
   
   
</body>
</html>

