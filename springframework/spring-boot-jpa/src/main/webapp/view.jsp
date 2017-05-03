<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form action="../save" method="post">
	<input type="hidden" name="id" value="${customer.id}" />

	<table>
		<tr>
			<td>First Name</td>
			<td><input type="text" name="name" value="${customer.firstName}" /></td>
		</tr>
		<tr>
			<td>Last Name</td>
			<td><input type="text" name="name" value="${customer.lastName}" /></td>
		</tr>
	</table>

	<input type="submit" value="Save" />

</form>