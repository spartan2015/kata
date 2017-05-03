<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">    
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


				<h:outputText value="Name:" ></h:outputText>
				<h:outputText value="#{visitBean.currentProject.name}" />
				
				<h:outputText value="Type" />
				<h:outputText value="#{visitBean.currentProject.type}" />
				
				<h:outputText value="Initiated by" />
				<h:outputText value="#{visitBean.currentProject.initiatedBy}" />
				
				<h:outputText value="Requirement contact" />
				<h:outputText value="#{visitBean.currentProject.requirementsContact}" />
				
				<h:outputText value="Requirement email" />
				<h:outputText value="#{visitBean.currentProject.requirementsContactEmail}" />
