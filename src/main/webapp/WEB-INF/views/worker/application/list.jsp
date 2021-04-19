<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="/WEB-INF/tags"%>

<acme:list>
	<acme:list-column code="worker.application.list.label.reference" path="reference" width="10%"/>
	<acme:list-column code="worker.application.list.label.status" path="status" width="10%"/>
	<acme:list-column code="worker.application.list.label.title" path="title" width="80%"/>
</acme:list>