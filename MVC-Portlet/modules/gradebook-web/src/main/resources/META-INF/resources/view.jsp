<%@ include file="/init.jsp" %>

<p>
	<b><liferay-ui:message key="gradebook.caption"/></b>
</p>

<liferay-portlet:actionURL name="registrar" var="registrarURL">
</liferay-portlet:actionURL>

<aui:form action="<%= registrarURL %>">
	<aui:input name="nombre" label="form.name.label" />
	<aui:input name="email" label="form.email.label" />
	<aui:button type="submit" value="form.submit" />
</aui:form>
