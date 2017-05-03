<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Phone Number Form</title>
</head>
<body>

<form method="POST">
	Give me your phone number
	<input type="text" name="number" />
	
	<input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}"/>
	<input type="submit" name="_eventId_submit" value="Submit" />
</form>

</body>
</html>