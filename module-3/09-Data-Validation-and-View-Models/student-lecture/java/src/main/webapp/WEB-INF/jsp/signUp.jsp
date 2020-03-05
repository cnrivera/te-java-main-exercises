<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
	<head>
		<title>Awesome Mailing List</title>
		<style>
			.error {
				color:red;
			}
		</style>
	</head>
	<body>	
		<c:url var="mailingListSubmitUrl" value="/signUp"/>
		<form id="signUp" action="/validation-lecture/signUp" method="POST">
			<div>
				<label for="name">Name</label>
				<input id="name" name="name" type="text" value=""/>				
			</div>
			<div>
				<label for="email">Email Address</label>
				<input id="email" name="email" type="text" value=""/>				
			</div>
			<div>
				<label for="phone">Phone Number (XXX)XXX-XXXX</label>
				<input id="phone" name="phone" type="text" value=""/>				
			</div>
			<div>
				<label for="age">Age</label>
				<input id="age" name="age" type="text" value=""/>				
			</div>
			<div>
				<input type="submit" value="Sign Me Up!"/>
			</div>
		</form>
	</body>
</html>