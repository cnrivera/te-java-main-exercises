<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="common/header.jsp">
	<c:param name="pageTitle">Details</c:param>
</c:import>

<div class="container">
	<h1>${amiibo.name}</h1>
	<img src="${amiibo.imagePath}"/>
	<table>
		<tr><td>Character</td><td>${amiibo.character}</td></tr>
		<tr><td>North America Release</td><td>${amiibo.release.na}</td></tr>
		<c:forEach items="${amiibo.otherInfo.keySet()}" var="key">
			<tr><td>${key}</td><td>${amiibo.otherInfo[key]}</td></tr>
		</c:forEach>
		
	</table>
	<c:url value="/add" var="formUrl"/>
	<form method="POST" action="${formUrl}">
		<input type="hidden" name="id" value="${amiibo.id}"/>
		<button type="submit">Add To My Collection</button>
	</form>
</div>
<c:import url="common/footer.jsp"/>