<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<f:view>

<h:outputText value="h:outputText component" />

<c:out value="c:out component" />

<blockquote>
	<f:verbatim>
		<c:import url="WEB-INF/web.xml"></c:import>
	</f:verbatim>
</blockquote>

<jsp:useBean id="exampleBean" class="org.mseco.learning.jsf.MyBean" scope="session"></jsp:useBean>

<h:form>
	<h:inputText value="#{sessionScope.exampleBean.number}"></h:inputText>	
	<h:commandButton value="Go "/>
</h:form>

<c:if test="${sessionScope.exampleBean.number > 0}">
	<c:forEach begin="0" end="${sessionScope.exampleBean.number - 1}" var="count">
		<div>Element</div>
	</c:forEach>
</c:if>

<div>Never nest any jsf in a c:forEach</div>
<div>if you hide a jsf component with c:if then the sever side component will vanish as well - be carefull !!!</div>
<div>instead of hidding with c:if consider using a panelGroup</div>

<h:panelGroup rendered="#{sessionScope.exampleBean.number > 10}">
<f:verbatim>
	<div>Number is greater than 10</div>
</f:verbatim>
</h:panelGroup>


<h:panelGroup rendered="#{sessionScope.exampleBean.number < 10}">
<f:verbatim>
	<div>Number less than 10</div>
</f:verbatim>
</h:panelGroup> 


<div>
  Use of fmt:parseDate> and fmt:parseNumber> is not recommended. You
■
  should use the HtmlInputText component (covered in chapter 5) with a
  DateTime or Number converter (both are covered in chapter 6).

</div>


<div>

  The fmt:requestEncoding> tag, which is use to determine or specify the
■
  character encoding for the page, should not be used. Usually, JSF handles
  this automatically, and if you need to force a particular encoding, you
  should use the JSP page directive: %page contentType="[content-
  type];[charset]"%>.

</div>


<div>

  The fmt:setLocale> tag shouldn’t be used either. Because it doesn’t know
■
  about JSF, it may cause your JSTL tags to use one locale and your JSF com-
  ponents may use another, which is a recipe for disaster. Instead, you should
  use JSF ’s internationalization features (covered in chapter 6). To control
  the locale for a particular page, use the locale property of the UIViewRoot
  component, which is covered in chapter 4. JSF ’s internationalization fea-
  tures work for both JSF and JSTL.


</div>
</f:view>    