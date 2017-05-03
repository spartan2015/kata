<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">    
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<f:view>
	<h:form>
				
		<h:commandButton action="#{applicationUsage.getBundle}" value="Ia o resursa din bundle"></h:commandButton>
		
		<h:commandButton action="#{applicationUsage.valueAndMethodBindingExpression}" value="Foloseste in cod ValueBinding si MethodBinding JSF EL Expression"></h:commandButton>
		
		<h:commandButton action="#{applicationUsage.createComponent}" />
	</h:form>	

</f:view>