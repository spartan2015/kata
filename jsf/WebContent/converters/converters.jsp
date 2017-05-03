<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<f:view>
	<h:form>
		
		<h:inputText value="#{userForm.date}" converter="dateConverter">
			<f:converter converterId="dateConverter"/>
		</h:inputText>	
		
		
		<div>dateTime jsf converter: f:convertDateTime
			<div>Properties</div>
			<ul>
				<li>type</li>
				<li>dateStyle: short medium long full</li>
				<li>locale</li>
				<li>timeStyle</li>
				<li>timeZone</li>
				<li>pattern</li>
			</ul>			
		</div>
		
		<div>No converter
			<h:inputText id="qx" value="#{userForm.date}">				
			</h:inputText>
		</div>
		
		<div>short
			<h:inputText id="q" value="#{userForm.date}">
				<f:convertDateTime dateStyle="short"/>
			</h:inputText>
		</div>
		<div>medium
			<h:inputText id="q2" value="#{userForm.date}">
				<f:convertDateTime dateStyle="medium"/>
			</h:inputText>
		</div>
		<div>long
			<h:inputText id="q3" value="#{userForm.date}">
				<f:convertDateTime dateStyle="long"/>
			</h:inputText>
		</div>
		<div>full
			<h:inputText id="q4" value="#{userForm.date}">
				<f:convertDateTime dateStyle="full"/>
			</h:inputText>
		</div>
		<div>type: both an d full
			<h:inputText id="q5" value="#{userForm.date}">
				<f:convertDateTime type="both" dateStyle="full" timeStyle="full"/>
			</h:inputText>
		</div>
		<div>type: date
			<h:inputText id="q6" value="#{userForm.date}">
				<f:convertDateTime type="date"/>
			</h:inputText>
		</div>
		<div>type: time
			<h:inputText id="q7" value="#{userForm.date}">
				<f:convertDateTime type="time"/>
			</h:inputText>
		</div>
		<div>pattern: dd/MM/yy
			<h:inputText id="q8" value="#{userForm.date}">
				<f:convertDateTime pattern="dd/MM/yy"/>
			</h:inputText>
		</div>
	
	
	
		<div>
			Convert numbers f:convertNumber
			<div>Properties</div>
			<ul>
				<li>type</li>
				<li>currencyCode</li>
				<li>currencySymbol</li>
				<li>groupingUsed</li>
				<li>locale</li>
				<li>minFractionDigits</li>
				<li>maxFractionDigits</li>
				<li>minIntegerDigits</li>
				<li>maxIntegerDigits</li>
				<li>pattern</li>
			</ul>
		</div>
		
		
		<div> No converter
			<h:inputText id="nn" value="#{userForm.doubleNumber}">
			
			</h:inputText>
		</div>
		
		<div> Simple
			<h:inputText id="n1" value="#{userForm.doubleNumber}">
				<f:convertNumber/>
			</h:inputText>
		</div>
				
		<div>locale: ro_RO
			<h:inputText id="n2"  value="#{userForm.doubleNumber}">
				<f:convertNumber locale="ro_RO"/>
			</h:inputText>
		</div>
		
		<div>locale: en_US
			<h:inputText id="n3"  value="#{userForm.doubleNumber}">
				<f:convertNumber locale="en_US"/>
			</h:inputText>
		</div>
		
		
		<div>currencyCode=ROL
			<h:inputText id="n4"  value="#{userForm.doubleNumber}">
				<f:convertNumber currencyCode="ROL"/>
			</h:inputText>
		</div>
		
		<div>groupingUsed=false
			<h:inputText id="n5"  value="#{userForm.doubleNumber}">
				<f:convertNumber currencyCode="ROL" groupingUsed="false"/>
			</h:inputText>
		</div>		
				
		<h:commandButton ></h:commandButton>
	</h:form>	

</f:view>