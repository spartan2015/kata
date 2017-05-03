<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<f:view>
	<h:form>

		<h:message for="textId" showDetail="true" showSummary="true"
			errorClass="" errorStyle=""
			fatalClass="" fatalStyle=""
			warnClass="" warnStyle=""
			infoClass="" infoStyle=""
			tooltip="false" 
			 />
		<div>Tootip (span title="text as tooltip"), default false, indicates whether or not the message should be displayed as a tooltip  - only valid if showDetails is true</div>
	
		<h:inputText id="textId">
			<f:validateLength minimum="1" maximum="1" />
			<f:validateLongRange minimum="1" maximum="3" />
		</h:inputText>

		<h:commandButton></h:commandButton>
	</h:form>

</f:view>