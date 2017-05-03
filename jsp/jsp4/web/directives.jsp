<%@ page 
info="My first JSP Page" 
pageEncoding="UTF-8" 
import="java.io.*"
contentType="text/html:UTF-8"
language="java"
isELIgnored="false"
session="true"
buffer="16kb"
autoFlush="true"
errorPage="handleError.jsp"
isErrorPage="false"
isThreadSafe="true"
%>


<%@ include file="UploadForm.jsp"  %>

<%--
<%@ taglib  %>
--%>


<%

application.getNamedDispatcher("").include(request,response);

//pageContext.include();
//pageContext.forward();
application.log("");
this.log("");

this.getServletInfo();

%>