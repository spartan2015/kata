<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Order Details</title>
</head>
<body>

${order.customer.phoneNumber}<br/>
${order.customer.state}<br/>
${order.customer.city}<br/>
${order.customer.zipCode}<br/>
${order.customer.streetAddress}<br/>
${order.customer.phoneNumber}
<a href="?_flowExecutionKey=${flowExecutionKey}&_eventId=continue">Continue</a>
<a href="?_flowExecutionKey=${flowExecutionKey}&_eventId=addPizza">AddPizza</a>
<a href="?_flowExecutionKey=${flowExecutionKey}&_eventId=cancel">Cancel</a>

<ul>
<c:forEach items="${order.pizzas}" var="pizza">
	<li>Pizza name: ${pizza.name}</li>
</c:forEach>
</ul>

</body>
</html>