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
		<form:form id="signUp" action="${mailingListSubmitUrl}" method="POST" modelAttribute="signUpData">
			<div>
				<label for="name">Name</label>
				<form:input id="name" name="name" type="text" path="name" required="required"/>	
				<form:errors path="name" class="error"/>			
			</div>
			<div>
				<label for="email">Email Address</label>
				<form:input id="email" name="email" type="text" path="email"/>	
				<form:errors path="email" class="error"/>				
			</div>
			<div>
				<label for="emailVerify">Re-enter Email Address</label>
				<form:input id="emailVerify" name="emailVerification" type="text" path="emailVerification"/>	
				<form:errors path="emailMatching" class="error"/>				
			</div>
			<div>
				<label for="phone">Phone Number (XXX)XXX-XXXX</label>
				<form:input id="phone" name="phone" type="text" path="phone" />		
				<form:errors path="phone" class="error"/>			
			</div>
			<div>
				<label for="age">Age</label>
				<form:input id="age" name="age" type="text" path="age"/>		
				<form:errors path="age" class="error"/>			
			</div>
			<div>
				<label for="startDate">Start Subscription</label>
				<form:input id="startDate" name="subscriptionStartDate" path="subscriptionStartDate" type="date"/>
				<form:errors path="subscriptionStartDate" class="error"/>
			</div>
			<div>
				<label for="callTime">When to Call and Confirm?</label>
				<form:input id="callTime" name="confirmationCallTime" path="confirmationCallTime" type="datetime-local"/>
				<form:errors path="confirmationCallTime" class="error"/>
			</div>
			<div>
				<input type="submit" value="Sign Me Up!"/>
			</div>
		</form:form>
	</body>
</html>