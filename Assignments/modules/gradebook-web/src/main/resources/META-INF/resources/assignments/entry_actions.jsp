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

<%@ include file="../init.jsp"%>


<c:set var="assignment" value="${SEARCH_CONTAINER_RESULT_ROW.object}" />
<liferay-ui:icon-menu markupView="lexicon">

 <%-- View action.--%> 
 <portlet:renderURL var="viewAssignmentURL">
 <portlet:param name="mvcRenderCommandName" value="<%=MVCCommandNames.VIEW_ASSIGNMENT %>" />
 <portlet:param name="redirect" value="${currentURL}" />
 <portlet:param name="assignmentId" value="${assignment.assignmentId}" />
 </portlet:renderURL>

 
 <liferay-ui:icon message="view" url="${viewAssignmentURL}" />
  
 <%-- Edit action.--%>
 
 <portlet:renderURL var="editAssignmentURL">
 <portlet:param name="mvcRenderCommandName" value="<%=MVCCommandNames.EDIT_ASSIGNMENT %>" />
 <portlet:param name="redirect" value="${currentURL}" />
 <portlet:param name="assignmentId" value="${assignment.assignmentId}" />
 </portlet:renderURL>
 
 <liferay-ui:icon message="edit" url="${editAssignmentURL}" />

 
 <%-- Delete action.--%> 
 
 <portlet:actionURL name="<%=MVCCommandNames.DELETE_ASSIGNMENT %>" var="deleteAssignment" >
 <portlet:param name="redirect" value="${currentURL}" />
 <portlet:param name="assignmentId" value="${assignment.assignmentId}" />
 </portlet:actionURL>
 
 <liferay-ui:icon-delete url="${deleteAssignmentURL}" />
</liferay-ui:icon-menu>
