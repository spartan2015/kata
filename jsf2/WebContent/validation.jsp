<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">    
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<f:view>
	<h:form>
		<h:messages/>
		
		<h:inputText validator="#{validator.validateValue}" required="true" >
			<f:validateLength min="1" maximum="1"/>
			<f:validateLongRange minimum="1" maximum="1" />
		</h:inputText>
						
		<h:commandButton ></h:commandButton>
	</h:form>	

</f:view>