<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:url var="loginUrl" value="/mylogin" />  
	<form action="${loginUrl}" method="post">
		LoginName:<input type="text" name="ssoId"/><br/>
		Password:<input type="text" name="password"/><br/>
		<input type="hidden" name="${_csrf.parameterName}"   value="${_csrf.token}" /> 
		<input type="submit" value="login"/> 
	</form>
</body>
</html>