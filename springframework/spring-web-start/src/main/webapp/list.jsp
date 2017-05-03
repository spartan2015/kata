<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<table>
		<tr>
			<td>Id</td>
			<td>Title</td>
			<td>Actions</td>
		</tr>
		<c:forEach items="${list}" var="book">
			<tr>			
				<td><c:out value="${book.id}" /></td>
				<td><c:out value="${book.title}" /></td>
				<td><a href="/view/${book.id}">View</a></td>		
			</tr>
		</c:forEach>
	</table>

	<a href="/view/0" >New</a>

