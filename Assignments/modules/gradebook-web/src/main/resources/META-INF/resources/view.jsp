<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib prefix="aui" uri="http://liferay.com/tld/aui" %>
<%@ taglib prefix="clay" uri="http://liferay.com/tld/clay" %>
<%@ taglib prefix="liferay-item-selector" uri="http://liferay.com/tld/item-selector" %>
<%@ taglib prefix="liferay-frontend" uri="http://liferay.com/tld/frontend" %>
<%@ taglib prefix="liferay-portlet" uri="http://liferay.com/tld/portlet" %>
<%@ taglib prefix="liferay-theme" uri="http://liferay.com/tld/theme" %>
<%@ taglib prefix="liferay-ui" uri="http://liferay.com/tld/ui" %>

<%@ page import="java.util.Date"%>
<%@ page import="javax.portlet.WindowState"%>
<%@ page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@ page import="com.liferay.portal.kernel.util.HtmlUtil"%>


<%@ page import="com.liferay.training.gradebook.model.Assignment"%>
<%@ page import="com.liferay.training.gradebook.web.constants.MVCCommandNames"%>

<liferay-frontend:defineObjects />

<liferay-theme:defineObjects />

<portlet:defineObjects />

<%@ include file="init.jsp"%>

<p>Anaaaaa</p>


<div class="container-fluid-1280">
	<h1>
		<liferay-ui:message key="Assignments" />
	</h1>
	

	
	<%-- Clay management toolbar.--%>
	<clay:management-toolbar disabled="${assignmentCount eq 0}"
		displayContext="${assignmentsManagementToolbarDisplayContext}"
		itemsTotal="${assignmentCount}" 
		searchContainerId="assignmentEntries"
		selectable="false" 
	/>

		
	<%-- Search container.--%>
	<liferay-ui:search-container 
	    emptyResultsMessage="no-assignments"
		id="assignmentEntries" 
		iteratorURL="${portletURL}"
		total="${assignmentCount}">
		
		<liferay-ui:search-container-results results="${assignments}" />
		<liferay-ui:search-container-row
			className="com.liferay.training.gradebook.model.Assignment"
			modelVar="entry">
			<%@ include file="/assignment/entry_search_columns.jspf"%>
			
		</liferay-ui:search-container-row>
	

 <%-- Iterator / Paging --%>
		<liferay-ui:search-iterator
			displayStyle="${assignmentsManagementToolbarDisplayContext.getDisplayStyle()}"
			markupView="lexicon"
        />
	</liferay-ui:search-container>
</div>

