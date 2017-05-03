<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">    
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<f:view>
	<h:form>
		
		<h:inputText value="#{bean.date}" >
			<f:convertDateTime type="date"/>
		</h:inputText>
		<br/>
		<div>NoConverter inside inputText - it just displayes the date</div>
		<h:inputText id="x" value="#{bean.date}" />
		<div>default timeZone for converter is GMT</div>
		<h:inputText value="#{bean.date}" >
			<f:convertDateTime type="time"/>
		</h:inputText>
		<br/>
		<br/>
		<h:inputText value="#{bean.date}" >
			<f:convertDateTime type="both"/>
		</h:inputText>
		<br/>
		<br/>
		dateStyle="short"
		<h:inputText value="#{bean.date}" >
			<f:convertDateTime type="date" dateStyle="short"/>
		</h:inputText>
		<br/>
		<br/>
		timeStyle="short"
		<h:inputText value="#{bean.date}" >
			<f:convertDateTime type="time" timeStyle="short"/>			
		</h:inputText>
		<br/>
		<br/>
		timeZone="GMT"
		<h:inputText value="#{bean.date}" >
			<f:convertDateTime type="time" timeZone="GMT"/>
		</h:inputText>
		<br/>
		<br/>
		locale="ro"
		<h:inputText value="#{bean.date}" >
			<f:convertDateTime type="time" locale="ro_RO"/>
		</h:inputText>
		<br/>
		<br/>
		pattern="dd/MM/yyyy hh:mm"
		<h:inputText value="#{bean.date}" >
			<f:convertDateTime pattern="dd/MM/yyyy hh:mm"/>
		</h:inputText>
		<br/>
				
		<h:commandButton ></h:commandButton>
	</h:form>	

</f:view>