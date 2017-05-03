<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<f:view>
	<h:outputFormat value="My name is {0} and I was born on {1, date, MM.dd.yy},{1, date, medium}  in the city of {2}">
		<f:param value="neo"/>
		<f:param value="#{helloBean.date}"/>
		<f:param value="Iasi" />
		<f:param value="#{helloBean.date}"/>
		<f:param value="#{helloBean.date}"/>		
	</h:outputFormat>

	
	<h:outputFormat value="Hello {0}, you have visited us {1} {1,choice, 0#times|1#time|2#times}">
		<f:param value="MsEco" />
		<f:param value="1" />
	</h:outputFormat>
	
</f:view>