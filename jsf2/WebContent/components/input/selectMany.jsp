<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">    
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<f:view>
	<h:form>
		<h:selectManyCheckbox value="#{checkbox.selectedListOfSelectItem}">
			<f:selectItem itemLabel="neo" itemValue="neo"/>
			<f:selectItem value="#{checkbox.selectItem}" />
			<f:selectItems value="#{checkbox.selectItems}" />
		</h:selectManyCheckbox>
		
		<h:selectManyListbox  value="#{checkbox.selectedListOfSelectItem}">
			<f:selectItem itemLabel="neo" itemValue="neo"/>
			<f:selectItem value="#{checkbox.selectItem}" />
			<f:selectItems value="#{checkbox.selectItems}" />
		</h:selectManyListbox>
		
		<h:selectManyMenu  value="#{checkbox.selectedListOfSelectItem}">
			<f:selectItem itemLabel="neo" itemValue="neo"/>
			<f:selectItem value="#{checkbox.selectItem}" />
			<f:selectItems value="#{checkbox.selectItems}" />
		</h:selectManyMenu>
				
		<h:commandButton ></h:commandButton>
	</h:form>	

</f:view>