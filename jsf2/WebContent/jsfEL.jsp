<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">    
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<f:view>
	<h:form>
		
		<div>
			{jsfEL.value}: 
			<h:outputText value="#{jsfEL.value}" />
		</div>
		
		<div>
			{jsfEL['value']}: 
			<h:outputText value="#{jsfEL['value']}" />
		</div>
		
		<div>
			{jsfEL.array[0]}: 
			<h:outputText value="#{jsfEL.array[0]}" />
		</div>
		
		<div>
			{jsfEL.list[0]}: 
			<h:outputText value="#{jsfEL.list[0]}" />
		</div>
		
		<div>
			{jsfEL.map['stringKey']}: 
			<h:outputText value="#{jsfEL.map['stringKey']}" />
		</div>
		
		<div>
			{jsfEL.map[jsfEL.value]}: 
			<h:outputText value="#{jsfEL.map[jsfEL.value]}" />
		</div>				
		
		
		<div>
			{jsfEL.map[jsfEL.value].bytes}: 
			<h:outputText value="#{jsfEL.map[jsfEL.value].bytes}" />
		</div>
		
		<div>
			{"a" == "a"}: 
			<h:outputText value="#{'a' == 'a'}" />
		</div>
		
		
		<div>
			{ 1 + 1 }: 
			<h:outputText value="#{ 1 + 1}" />
		</div>
		
		<div>
			Hello {jsfEl.value}: 
			<h:outputText value="Hello #{jsfEL.value} !" />
		</div>
		
		<div>
			{jsfEL.getString}: 
			<h:outputText value="#{jsfEL.getString}" />
		</div>
		<h:commandButton ></h:commandButton>
	</h:form>	

</f:view>