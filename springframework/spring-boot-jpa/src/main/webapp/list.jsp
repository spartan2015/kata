<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<table>
		<tr>
			<td>Name</td>
			<td>DateOfBirth</td>
			<td>Height</td>
			<td>Weight</td>
			<td>Actions</td>
		</tr>
		<c:forEach items="${customers}" var="customer">
			<tr>			
				<td><c:out value="${customer.firstName}" /></td>
				<td><c:out value="${customer.lastName}" /></td>							
			</tr>
		</c:forEach>
	</table>

	<a href="view/0">New</a>
