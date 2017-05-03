<h:form>
   <h2>Register Motorist</h2>
   <h:panelGrid columns="2">
     <f:verbatim><b>E-mail:</b></f:verbatim>
     <h:inputText value="#{motorist.email}" required="true"/>
     <f:verbatim><b>Password:</b></f:verbatim>
     <h:inputText value="#{motorist.password}" required="true"/>
     <f:verbatim><b>First Name:</b></f:verbatim>
     <h:inputText value="#{motorist.firstName}" required="true"/>
     <f:verbatim><b>Last Name:</b></f:verbatim>
     <h:inputText value="#{motorist.lastName}" required="true"/>
   </h:panelGrid>
   <h:commandButton id="submit" action="#{motorist.register}"
       value="Register Motorist"/>
</h:form>
