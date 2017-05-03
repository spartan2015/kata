<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
    <%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
    
<f:view>
	<h:form id="goodbyeForm">
		<h:outputText id="welcomOutpu" value="Good Bye !" style="font-family: Arial, sans-serif; font-size:24; fond-style:bold; color:green"></h:outputText>
		
		<h:outputText id="helloBeanOutputLabel" value="Num of controls displayed: " />
		<h:outputText id="helloBeanOutput" value="#{helloBean.numControls}" />
	</h:form>
</f:view>     