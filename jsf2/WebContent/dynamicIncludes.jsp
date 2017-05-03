<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<f:view>
	<h:form>
		<div>With jsp:include you can dynamic include content from
		subpages into this pages in certain conditions:
		<ol>
			<li>The content of the subpage or the jsp:include statement must
			be enclosed in f:subview JSF tag</li>
			<li>all the content of the subpage that is not a JSF tag MUST BE
			ENCLOSED IN F:VERBATIM - only jsf tags can be in a dynamic include</li>
		</ol>
		</div>
		
		<f:subview id="subpageId">
			<jsp:include page="/subpageExample.jsp" />
		</f:subview>
		
		<h:commandButton></h:commandButton>
	</h:form>

</f:view>