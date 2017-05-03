<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">    
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


	
<h:outputLabel for="select">
				<h:outputText value="Competed artifacts" />
			</h:outputLabel>			
			<h:selectManyCheckbox id="select" layout="pageDirection" value="#{visit.currentProject.artifacts}"
				converter="ArtifactType">
				<f:selectItems value="#{selectItems.artifacts}"/>				
			</h:selectManyCheckbox>

