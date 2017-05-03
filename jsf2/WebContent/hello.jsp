<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">    
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<f:view>
	<h:form>
	<h:outputText value="Hello JSF" style="font-size:36px; color: green"></h:outputText>
		<h:messages></h:messages>
		<h:outputLabel for="textId">
			<h:outputText value="Textbox"></h:outputText>
		</h:outputLabel>
		<h:inputText id="textId" value="#{hello.num}" required="true">
			<f:validateLongRange minimum="1" maximum="100"/>
		</h:inputText>
		
		<h:panelGrid binding="#{hello.panelGrid}" columns="30">
		</h:panelGrid>
		
		<h:commandButton value="Redisplay" actionListener="#{hello.redisplay}"></h:commandButton>
		<h:commandButton value="Goodbye" action="#{hello.goodbye}" immediate="true"></h:commandButton>
	</h:form>	

</f:view>