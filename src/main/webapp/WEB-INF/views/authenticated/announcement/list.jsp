<%@page language="java"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:list>
	<acme:list-column code="authenticated.announcement.list.label.moment" path="moment" width="20%"/> <!-- code se coge de los archivos i18n. path es el nombre del atributo del modelo. -->
	<acme:list-column code="authenticated.announcement.list.label.status" path="status" width="10%"/>
	<acme:list-column code="authenticated.announcement.list.label.title" path="title" width="70%"/>
</acme:list>
