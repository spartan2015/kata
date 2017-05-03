<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">    
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


			<h:outputText value="Name" />
			<h:outputText value="#{visit.currentProject.name}" />
			
			<h:outputText value="Type" />
			<h:outputText value="#{visit.currentProject.type}" />
			
			<h:outputText value="Initiated by" />
			<h:outputText value="#{visit.currentProject.initiatedBy}" />
			
			<h:outputText value="Requirements contact" />
			<h:outputText value="#{visit.currentProject.requirementsContact}" />
			
			<h:outputText value="Requirements email" />
			<h:outputText value="#{visit.currentProject.requirementsContactEmail}" />
			
			<h:outputText value="Initial comments" />
			<h:outputText value="#{visit.currentProject.initialComments}" />
