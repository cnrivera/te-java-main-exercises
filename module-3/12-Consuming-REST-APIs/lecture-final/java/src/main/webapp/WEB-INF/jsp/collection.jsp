<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="common/header.jsp">
	<c:param name="pageTitle">Collection</c:param>
	<c:param name="activeNav" value="collection"/>
</c:import>
<h1>My Collection</h1>
<c:forEach items="${collection}" var="amiibo">
	<c:url value="/details" var="detailsUrl">
		<c:param name="id" value="${amiibo.id}"/>
	</c:url>
	<a href="${detailsUrl}"><img src="${amiibo.imagePath}"/></a>
</c:forEach>

<c:import url="common/footer.jsp"/>