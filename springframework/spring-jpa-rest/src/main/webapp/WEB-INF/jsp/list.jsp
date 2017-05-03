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
		<c:forEach items="${persons}" var="person">
			<tr>			
				<td><c:out value="${person.name}" /></td>
				<td><c:out value="${person.birthDate}" /></td>
				<td><c:out value="${person.height}" /></td>
				<td><c:out value="${person.weight}" /></td>	
				<td><a href="view/${person.id}">View</a></td>			
			</tr>
		</c:forEach>
	</table>

	<a href="view/0">New</a>
