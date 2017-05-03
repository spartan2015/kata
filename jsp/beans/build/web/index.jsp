<%@ page import="classes.*" %>



<jsp:useBean id="name" scope="page" class="classes.person"/>

<!-- 
http://localhost:8084/beans/?firstName=Poncu&lastName=Anca&sex=pussy
-->

<jsp:setProperty name="name" property="*"/>
<!-- echivaluntul pentru toate 3: -->

<jsp:setProperty name="name" property="firstName"/>
<jsp:setProperty name="name" property="lastName"/>
<jsp:setProperty name="name" property="sex"/>


FirstName <%=name.getFirstName()%><br>
LastName <%=name.getLastName()%><br>
Sex <%=name.getSex()%><br>

<hr>
<h1>SEX: <jsp:getProperty name="name" property="sex"/></h1>