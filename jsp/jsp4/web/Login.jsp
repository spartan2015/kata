<%@ page import="java.util.*, java.io.*" pageEncoding="UTF-8" errorPage="error.jsp" isErrorPage="false" %>

<%
String user = request.getParameter("username");
String pass = request.getParameter("password");

String color = request.getParameter("color");
if (color != null) out.println("<p>You chosed this color: " + color + "</p>");

out.println("<p>Hello: " + user + "/" + pass + "</p>");

request.setAttribute("user",user);
request.setAttribute("pass",pass);
%>

<p>\${user}/\${pass} | ${user}/${pass}</p>
<p>=%user%/%=pass% | <%=user%>/<%=pass%></p>

<%

try{
throw new Throwable("Eroare lansata.");
} catch(Throwable t){}
finally{

    out.println("<p>Finally</p>");
}

%>

<form action="ColorChoose" method="post" name="f">
    
    <select name="color" multiple onclick="javascript: t();">
        <option value="Red">Red</option>
        <option value="Blue">Blue</option>
        <option value="Green">Green</option>        
    </select>
    
    <input type="hidden" name="username" value="<%=user%>">
    <input type="hidden" name="password" value="${pass}">
    <input type="submit" name="choose_color" value="Choose">
</form>

<script language="javascript">
var objects = new Array();

function t(){
    if (objects['diver'] == null)
        objects['diver'] = document.getElementById("diver");
        
    objects['diver'].innerHTML = f.color.value + "/" + f.color.selectedIndex + "/" + f.color[f.color.selectedIndex].value;
}
</script>
<div id="diver"></div>