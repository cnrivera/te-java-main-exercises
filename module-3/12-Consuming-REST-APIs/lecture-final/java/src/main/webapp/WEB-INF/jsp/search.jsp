<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="common/header.jsp">
	<c:param name="pageTitle">About</c:param>
	<c:param name="activeNav" value="about"/>
</c:import>
<h1>Search</h1>

<form>
<input type="text" placeholder="Character Name" name="character"/>
</form>

<div class="container">
<c:forEach items="${amiibos}" var="amiibo">
	<c:url value="/details" var="detailsUrl">
		<c:param name="id" value="${amiibo.id}"/>
	</c:url>
	<a href="${detailsUrl}"><img src="${amiibo.imagePath}"/></a>
</c:forEach>
<c:if test="${amiibos != null && empty amiibos}">
	No Amiibos found!
</c:if>
</div>
<c:import url="common/footer.jsp"/>