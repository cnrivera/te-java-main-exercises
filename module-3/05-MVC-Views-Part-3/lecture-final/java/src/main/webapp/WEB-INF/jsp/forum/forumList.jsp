<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/header.jsp">
	<c:param name="pageTitle">The Solar System Geek Forum</c:param>
</c:import>

<ul>
	<c:forEach var="topic" items="${topicList}">
		<c:url var="forumPostHref" value="/forum/forumDetail">
			<c:param name="forumId">${topic.id}</c:param>
			<c:param name="example" value="mac&cheese"/>
		</c:url>
		<li><a href="${forumPostHref}"><c:out value="${topic.title}"/></a></li>
	</c:forEach>
</ul>

<c:import url="/WEB-INF/jsp/footer.jsp"/>
