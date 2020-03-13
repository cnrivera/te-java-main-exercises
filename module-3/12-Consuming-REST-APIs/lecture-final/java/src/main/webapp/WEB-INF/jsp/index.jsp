<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="common/header.jsp">
	<c:param name="pageTitle">Home</c:param>
	<c:param name="activeNav" value="home"/>
</c:import>

<h1>Welcome to the site!</h1>

<c:forEach var="weather" items="${forecasts}">
<div>High: ${weather.highTemp}</div>
<div>Low: ${weather.lowTemp}</div>
</c:forEach>

<c:import url="common/footer.jsp"/>