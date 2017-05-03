<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<style>
.enabledClass {
	background-color: #F5F5F5;
}

.disabledClass {
	background-color: grey;
}
</style>
<f:view>
	<h:form>
		<div><h:selectManyCheckbox enabledClass="enabledClass"
			layout="pageDirection" disabledClass="disabledClass">
			<f:selectItems value="#{userForm.selectItems}" />
		</h:selectManyCheckbox></div>
		<div><h:selectManyCheckbox id="_333" enabledClass="enabledClass"
			layout="lineDirection" disabledClass="disabledClass">
			<f:selectItems value="#{userForm.selectItems}" />
		</h:selectManyCheckbox></div>

		<h:commandButton></h:commandButton>
	</h:form>
</f:view>