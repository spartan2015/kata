<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<style>
.aclass{
background-color:black;
}
</style>    

<f:view>

	<h:outputText id="someId" value="Some text" rendered="true" escape="true" style="color:red" styleClass="aclass"/>
	<h:outputText value="#{myBean.number}" />
	
</f:view>