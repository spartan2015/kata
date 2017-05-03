<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<style>
.aclass {
	color: red;
	background-color: black;
}
</style>
<f:view>

	<h:form>
		<h:inputText id="id" value="#{1}" rendered="true"
			convertor="dateConverter" styleClass="aclass"
			binding="#{commonComponentProperties.inputText}" />
	</h:form>

</f:view>
