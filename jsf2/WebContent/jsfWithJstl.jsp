<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<f:view>
	<h:form>
		<div>Yes you can use JSF with JSTL - but recommended way is to
		keep them separate - there might be nesting problems</div>
	
	
		<ol>
			<li>
			   You cannot use JSF component tags inside tags that iterate over their body, like
the JSTL c:forEach> tag. The recommended workaround is to use the HtmlData-
Table component or another component iterates over a data set or collection.
			
			</li>
			
			<li>
			     But what happens if a component is displayed once and then hidden by a
conditional tag like c:if> when the page is redisplayed? The first time the com-
ponent is displayed, it will be added to the view. The second time, if the c:if>
tag doesn’t display the component, JSF will delete it from the view. This means
that any input controls will lose their local values, and that you won’t be able to
reference these components (via client identifiers or in code). 
			
			</li>
			
			<li>
			  Use of fmt:parseDate> and fmt:parseNumber> is not recommended. You
  should use the HtmlInputText component (covered in chapter 5) with a
  DateTime or Number converter (both are covered in chapter 6).
			
			</li>
			
			<li>
			  The fmt:requestEncoding> tag, which is use to determine or specify the
  character encoding for the page, should not be used. Usually, JSF handles
  this automatically, and if you need to force a particular encoding, you
  should use the JSP page directive: %page contentType="[content-
  type];[charset]"%>.
			
			</li>
			
			<li>
			  The fmt:setLocale> tag shouldn’t be used either. Because it doesn’t know
  about JSF, it may cause your JSTL tags to use one locale and your JSF com-
  ponents may use another, which is a recipe for disaster. Instead, you should
  use JSF ’s internationalization features (covered in chapter 6). To control
  the locale for a particular page, use the locale property of the UIViewRoot
  component, which is covered in chapter 4. JSF ’s internationalization fea-
  tures work for both JSF and JSTL.
			
			</li>
		</ol>


		<blockquote>
		<f:verbatim>
			<c:import url="/WEB-INF/web.xml"></c:import>
		</f:verbatim></blockquote>

		<jsp:useBean id="beanId" class="org.mseco.learning.jsf.Bean" scope="session"></jsp:useBean>
		
		<div>
			<h:inputText value="#{sessionScope.beanId.name}" />
		</div>
		
		<div>
			c:out says: <c:out value="${sessionScope.beanId.name}" />
		</div>
		<h:commandButton></h:commandButton>
	</h:form>

</f:view>