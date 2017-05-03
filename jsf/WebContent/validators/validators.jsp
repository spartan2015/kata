<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<f:view>
	<h:form>
		<h:messages globalOnly="false"></h:messages>
		
		<h:inputText id="id1" required="true">
			<f:validateLength minimum="2" maximum="2"/>
			<f:validateLongRange minimum="10" maximum="99"/>
			<f:validator validatorId="myValidator"/>
		</h:inputText>
			
		<h:commandButton ></h:commandButton>
	</h:form>	

</f:view>