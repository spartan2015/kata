<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<f:view>
	<h:form>
		
		<div>used to display dinamic data source: List, ResultSet, Array, etc</div>
		<div>Properties:
			<ul>
				<li>first - set the start element </li>
				<li>rows - number of rows to display at a time</li>
				<li>value - the source: array, list, resultSet</li>
				<li>var - name of the requestScope variable under wich a row will be stored</li>
				<li>headerClass</li>
				<li>footerClass</li>
				<li>rowClasses</li>
				<li>columnClasses</li>
			</ul>
			
			<din>Java Only properties</din>
			<ul>
				<li>rowCount</li>
				<li>rowIndex - current selected index</li>
				<li>rowAvailable - if the current row is avaiable</li>
				<li>rowData - currently selected row - as Object</li>
				
			</ul>
		</div>
		
		
		<h:dataTable value="#{userForm.simpleList}" var="row" >
			<f:facet name="header">
				<f:verbatim>Table header</f:verbatim>
			</f:facet>
			
			<h:column>
				<f:facet name="header">Column 1</f:facet>
				<h:outputText value="1 #{row}"></h:outputText>
			</h:column>
			
			
			<h:column>
				<f:facet name="header">Column 2</f:facet>
				<h:outputText value="1 #{row}"></h:outputText>
			</h:column>
			
			<f:facet name="footer">
				<f:verbatim>Table footer</f:verbatim>
			</f:facet>
		</h:dataTable>
		
		
		
		<h:dataTable id="id2" value="#{userForm.simpleList}" var="row" >			
			<f:facet name="header">
				<f:verbatim>From a ListDataModel</f:verbatim>
			</f:facet>
			
			<h:column>
				<f:facet name="header">Column 1</f:facet>
				<h:outputText value="1 #{row}"></h:outputText>
			</h:column>
			
			
			<h:column>
				<f:facet name="header">Column 2</f:facet>
				<h:outputText value="1 #{row}"></h:outputText>
			</h:column>
			
			<f:facet name="footer">
				<f:verbatim>Table footer</f:verbatim>
			</f:facet>
		</h:dataTable>
		
		
		<h:dataTable id="id3" value="#{userForm.stringList}" var="row" >			
			<f:facet name="header">
				<f:verbatim>From a List&lt;String&gt; </f:verbatim>
			</f:facet>
			
			<h:column>
				<f:facet name="header">Column 1</f:facet>
				<h:outputText value="1 #{row}"></h:outputText>
			</h:column>
			
			
			<h:column>
				<f:facet name="header">Column 2</f:facet>
				<h:outputText value="1 #{row}"></h:outputText>
			</h:column>
			
			<f:facet name="footer">
				<f:verbatim>Table footer</f:verbatim>
			</f:facet>
		</h:dataTable>
		
		
		<h:dataTable id="id4" value="#{userForm.strings}" var="row" >			
			<f:facet name="header">
				<f:verbatim>From a String[] </f:verbatim>
			</f:facet>
			
			<h:column>
				<f:facet name="header">Column 1</f:facet>
				<h:outputText value="1 #{row}"></h:outputText>
			</h:column>
			
			
			<h:column>
				<f:facet name="header">Column 2</f:facet>
				<h:outputText value="1 #{row}"></h:outputText>
			</h:column>
			
			<f:facet name="footer">
				<f:verbatim>Table footer</f:verbatim>
			</f:facet>
		</h:dataTable>
		
		
		<h:dataTable id="id4" value="#{userForm.strings}" var="row" >			
			<f:facet name="header">
				<f:verbatim>editable String[] - throws error </f:verbatim>
			</f:facet>
			
			<h:column>
				<f:facet name="header">Column 1</f:facet>
				<h:inputText value="#{row}"/>
			</h:column>
			
			
			<f:facet name="footer">				
				<h:panelGroup>
					<f:verbatim>Table End</f:verbatim>
					<h:commandButton value="Save" />
				</h:panelGroup>
			</f:facet>
		</h:dataTable>
		
		
		
		
		<h:dataTable id="id5" value="#{userForm.simpleList}" var="row" >			
			<f:facet name="header">
				<f:verbatim>editable ListDataModel</f:verbatim>
			</f:facet>
			
			<h:column>
				<f:facet name="header">Column 1</f:facet>
				<h:inputText value="#{row}" />
			</h:column>
				
			<f:facet name="footer">				
				<h:panelGroup>
					<f:verbatim>Table End</f:verbatim>
					<h:commandButton value="Save" />
				</h:panelGroup>
			</f:facet>
		</h:dataTable>
		
		
		<h:dataTable id="id6" value="#{userForm.simpleList}" var="row" binding="#{userForm.dataTable}">			
			<f:facet name="header">
				<f:verbatim>editable ListDataModel</f:verbatim>
			</f:facet>
			
			<h:column>
				<f:facet name="header">Column 1</f:facet>
				<h:inputText value="#{row}" />
			</h:column>
			
			<h:column>
				<f:facet name="header">Delete</f:facet>
				<h:commandLink actionListener="#{userForm.deleteFromSimpleListActionListener}">Delete</h:commandLink>
			</h:column> 
				
			<f:facet name="footer">				
				<h:panelGroup>
					<f:verbatim>Table End</f:verbatim>
					<h:commandButton value="Save" />
				</h:panelGroup>
			</f:facet>
		</h:dataTable>
		
		<h:commandButton ></h:commandButton>
	</h:form>	

</f:view>