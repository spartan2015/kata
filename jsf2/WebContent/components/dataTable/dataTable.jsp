<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<f:view>
	<h:form>
		<div>DataTable options</div>
		<ul>
			<li>var - the variable that hold the current row</li>
			<li>first - the start point in the list of record</li>
			<li>rows - how many rows from the resultset to display</li>
			<li>value - the components value - a List, a JDBC ResultSet,
			JSTL Resultset, or any other object types. Other object types are
			represented as one row</li>
			<li>headerClass, footerClass, rowClasses, columnClasses</li>
		</ul>
		<div>Java only properties</div>
		<ul>
			<li>rowCount</li>
			<li>rowIndex - current selected row (with a commandLink you select the row)</li>
			<li>rowData - Returns the currently selected row. If available </li>
			<li>rowAvailable - boolean - true if there is a current row selected</li>			
		</ul>
		
		<h:messages />
		<h:dataTable var="row" value="#{managedBean.list}" first="0" rows="10" binding="#{events.dataTable}">
			<f:facet name="header">
				<f:verbatim>Table Header</f:verbatim>
			</f:facet>

			<h:column>
				<f:facet name="header">
					<f:verbatim>Column Header</f:verbatim>
				</f:facet>
				<h:inputText value="#{row}" />
			</h:column>

			<h:column>
				<f:facet name="header">
					<f:verbatim>Actions</f:verbatim>
				</f:facet>
				<h:commandLink actionListener="#{events.deleteRow}">
					<h:outputText value="Delete"></h:outputText>
				</h:commandLink>
			</h:column>
			
			<f:facet name="footer">
				<f:verbatim>Table Footer <h:commandButton value="Save"></h:commandButton></f:verbatim>
			</f:facet>
		</h:dataTable>

		<div>The real power of DataTable is in editing the values:</div>
		
		<h:dataTable var="user" value="#{dataTableBean.users}" first="0" rows="10" binding="#{dataTableBean.dataTable}">
			<f:facet name="header">
				<f:verbatim>Table Header</f:verbatim>
			</f:facet>

			<h:column>
				<f:facet name="header">
					<f:verbatim>Column Header</f:verbatim>
				</f:facet>
				<h:inputText value="#{user.name}" />
			</h:column>

			<h:column>
				<f:facet name="header">
					<f:verbatim>Column Header</f:verbatim>
				</f:facet>
				<h:inputText value="#{user.phone}" />
			</h:column>

			<h:column>
				<f:facet name="header">
					<f:verbatim>Actions</f:verbatim>
				</f:facet>
				<h:commandLink actionListener="#{events.deleteRow}">
					<h:outputText value="Delete"></h:outputText>
				</h:commandLink>
			</h:column>
			
			<f:facet name="footer">
				<f:verbatim>Table Footer <h:commandButton value="Save"></h:commandButton></f:verbatim>
			</f:facet>
		</h:dataTable>
		
		
	</h:form>

</f:view>