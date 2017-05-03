<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<f:view>
	<h:form>

		<div>It can also sup- port child UIParameter components, which
		gives you the opportunity to send parameters to the associated action
		method or action listener.</div>
		<div>In the next view, UI components can . access these
		parameters using the param implicit variable</div>

		<h:messages />

		=<h:outputText value="#{param['neo']}"></h:outputText>=

		<h:commandLink>
			<h:outputText value="Next page >>"></h:outputText>
			<f:actionListener type="org.mseco.learning.jsf.ActionEventImpl" />
			<f:param name="neo" value="neo" />
		</h:commandLink>

		<h:commandButton></h:commandButton>
	</h:form>

</f:view>