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

	<h:messages globalOnly="true"  showDetail="true" showSummary="true" layout="list"
	infoClass="infoClass" infoStyle="" warnClass="warnClass" warnStyle="" errorClass="errorClass" errorStyle="" fatalClass="fatalClass" fatalStyle="" 
	/>

	<h:form>
	<h:message for="inputText" showDetail="true" showSummary="true"
	tooltip="true" 
	 infoClass="infoClass" infoStyle="" warnClass="warnClass" warnStyle="" errorClass="errorClass" errorStyle="" fatalClass="fatalClass" fatalStyle="" ></h:message>
	
	
		<h:inputText id="inputText">
			<f:validateLongRange minimum="1" maximum="10"/>
		</h:inputText>
	</h:form>
	
	
</f:view>