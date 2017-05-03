<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form action="../save" method="post">
	<input type="hidden" name="id" value="${person.id}" />

	<table>
		<tr>
			<td>Name</td>
			<td><input type="text" name="name" value="${person.name}" /></td>
		</tr>
		<td>BirthDate</td>
		<td><input type="text" name="birthDate"
			value="<fmt:formatDate value="${person.birthDate}" pattern="dd/MM/yyyy" />" /></td>
		</tr>
		<td>Height</td>
		<td><input type="text" name="height" value="${person.height}" /></td>
		</tr>
		<td>Weight</td>
		<td><input type="text" name="weight" value="${person.weight}" /></td>

	</table>

	<input type="submit" value="Save" />

</form>