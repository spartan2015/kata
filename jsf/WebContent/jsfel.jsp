<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>

<f:view>
<h:form>
<div>	
	Access a bean property, a map value: {jsfel.value} or {jsfel['value']}
	<h:outputText value="#{jsfel.value}" />
	<h:outputText value="#{jsfel.map.value}" />
</div>

<div>
accesing an arraylist element {jsfel.list[5]}
	<h:outputText value="#{jsfel.list[5]}" />
</div>

<div>
	Return the value of a map by evaluating an expression to get the actual key {jsfel.map[jsfel.value]}
	<h:outputText value="#{jsfel.map[jsfel.value]}" />

</div>

<div>
	Return the property of an object retrieved from a map {jsfel[jsfel.value].bytes} (it;s the String bytes in our case)
	<h:outputText value="#{jsfel[jsfel.value].bytes}" />
</div>

<div>
	Evaluate boolean expression {jsfel.value == 'neo'}
	<h:outputText value="#{jsfel.value == 'neo'}" />
</div>

<div>
	Perform simple arithmetic {100-200}
	<h:outputText value="#{100-200}" />
</div>

<div>
	Perform ternary if {jsfel.value == 'neo' ? 'iaca neo' : 'nu e neo'}
	<h:outputText value="#{jsfel.value == 'neo' ? 'iaca neo' : 'nu e neo'}" />
</div>

<div>
	Execute a method
	<h:outputText value="#{jsdel.methodExecution}" />
</div>
<div>
	Bind a component to a backing bean value={jsfel.inpuText}
	<h:inputText binding="#{jsfel.inputText}"/>
</div>
<div>
	Bind to a listener: valueChangeListener={jsfel.processValueChange} wich is a method like: public void processValueChange(ValueChangeEvent event){}
	<h:inputText valueChangeListener="#{jsfel.processValueChange}" />
	
</div>


<div>
	Associates a validator with a component: - has a special signature
	<h:inputText validator="#{jsfel.validateMe}" />
</div>

</h:form>
</f:view>