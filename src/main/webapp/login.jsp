<%@page contentType='text/html' pageEncoding='UTF-8'%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page isELIgnored="false" %>
<!doctype html>
<html>
<head>
  <meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>
  <title>Enquiry Manager Login</title>
</head>

<p >Enquiry Manager Login</p>

<body>
<div> ${errroMessage}</div>
  <form:form method='post' action='login' modelAttribute='user'>
    <table>
      <tr>
        <td>Username: <font color='red'><form:errors path='userName' /></font></td>
      </tr>
      <tr>
        <td><form:input path='userName' /></td>
      </tr>
      <tr>
        <td>Password: <font color='red'><form:errors path='password' /></font></td>
      </tr>
      <tr>
        <td><form:password path='password' /></td>
      </tr>
      <tr>
        <td><input type='submit' value='Login' /></td>
      </tr>
      
    </table>
  </form:form>
  
 <form action="register" method="get">
 
 <input type='submit' value='Register' />
 
 </form>
</body>
</html>