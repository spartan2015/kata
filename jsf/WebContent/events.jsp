<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<f:view>

	<h:form>
	
		<h:outputLabel for="i1">
			<h:outputText value="ValueChangeEvent - processValueChangeEvent(ValueChangeEvent event)" ></h:outputText>
			<h:outputText value="#{myForm.change}" ></h:outputText>
		</h:outputLabel>
		<h:inputText id="i1" valueChangeListener="#{myForm.processValueChanged}"></h:inputText>
		
		<h:panelGrid binding="#{myForm.panelGrid}"></h:panelGrid>

		
		<div>
			Action event:
				<ol>
					<li>navigation events
						<h:commandButton type="submit" value="go to date" action="#{myForm.navigateDate}" />
						<h:commandLink  value="go to hello" action="#{myForm.navigateHello}"  />
						or static command button - action="naviationView"
						<h:commandButton value="Go Home" immediate="true" action="hello" />
					</li>
					<li>action events
						<h:commandButton type="submit"  value="Make Action Say Hello" actionListener="#{myForm.sayHello}" />
					</li>
				</ol>
		</div>
		
		<div>Data Model Events like DataModel.addDataModelListener(new DataModelListener(){})
		
		<div>
			<h:dataTable var="row" binding="#{myForm.dataTable}" value="#{myForm.dataModel}">
				<f:facet name="header">
					<h:outputText value="This is a table" />
				</f:facet>
				
				<h:column>
					<f:facet name="header">
						<h:outputText value="Column1 Header"/>
					</f:facet>
					<h:outputText  value="#{row}" />
				</h:column>
			</h:dataTable>
		</div>
		</div>
		
		<h:commandButton type="submit"></h:commandButton>
	</h:form>

</f:view>