<%@page contentType='text/html' pageEncoding='UTF-8'%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@page isELIgnored="false"%>
<!doctype html>
<html>
<head>
<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>
<title>Enquiry Page</title>
</head>
<body>
	<p>Welcome to Enquiry System
	<c:out value='${user.userName}' /></p>
	<br />
	
	<form action="createEnquiry" method="post">
		<label for="userId">User Id</label>
		<input type="text" name="userId" value = '${userId}'/><br>
		<label for="course">Course</label>
		<input type="text" name="course" /><br><br>
		
		<input type='submit' value='create enquiry' />
	</form>
	<br>
	<form action="editEnquiry" method="post">
		<label for="userId">User Id</label>
		<input type="text" name="userId" value = '${userId}'/><br>
		<label for="course">Course</label>
		<input type="text" name="course" /><br><br>
		
		<input type='submit' value='edit enquiry' />
	</form>
	<br>
	<form action="deleteEnquiry" method="post">
		<label for="enquiryId">Enquiry Id</label>
		<input type="text" name="enquiryId" value = '${enquiryId}'/><br><br>
		
		<input type='submit' value='delete enquiry' />
	</form>
	
	<p><a href='<c:url value='/'/>'>Go to Home..</a></p>
</body>
</html>