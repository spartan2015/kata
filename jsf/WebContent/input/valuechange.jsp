<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<style>
.infoClass{color:blue;}
.warnClass{color:orange;}
.errorClass{color:red;}
.fatalClass{color:violet}
</style>
<f:view>
	<h:messages globalOnly="false"  showDetail="true" showSummary="true" layout="list"
	infoClass="infoClass" infoStyle="" warnClass="warnClass" warnStyle="" errorClass="errorClass" errorStyle="" fatalClass="fatalClass" fatalStyle="" 
	/>
	
	<h:form>
		<h:inputText value="#{userForm.name}" valueChangeListener="#{userForm.nameChange}">
			<f:valueChangeListener type="org.mseco.learning.jsf.listeners.ValueChangeListenerImpl"/>
		</h:inputText>
	
		<h:commandButton value="Submit" action="retry" />
	</h:form>
	
</f:view>