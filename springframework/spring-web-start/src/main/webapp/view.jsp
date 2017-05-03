<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form action="/save" >
	Id: <input type="text" name="id" value="${book.id}"/>
	Title: <input type="text" name="title" value="${book.title}"/>
	
	<input type="submit" /> 	
</form>


