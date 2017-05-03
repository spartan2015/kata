<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<f:view>
	<h:form>
		<div>id</div>
		<div>value</div>
		<div>converter - either an id (faces-config id) or a value binding expression</div>
		<div>validator - a method binding expression that will validate</div>
		<div>immediate - in apply request paramters: (convert, validate ,apply ), after restoring the view</div>
		<div>rendered</div>
		<div>required</div>
		<div>styleClass</div>
		<div>valueChangeListener</div>
		<div>binding</div>
	</h:form>
	
</f:view>