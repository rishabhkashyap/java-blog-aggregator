<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras"
	prefix="tilesx"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js">
</script>

<link href="navbar.css" rel="stylesheet">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">




<title><tiles:getAsString name="title"></tiles:getAsString></title>
</head>
<body>
	<tilesx:useAttribute name="current" />
	<div class="container">
		<br /> <br />
		<!-- Static navbar -->
		<nav class="navbar navbar-default">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#navbar" aria-expanded="false"
						aria-controls="navbar">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href='<spring:url value="/" />'>JBA</a>
				</div>

				<ul class="nav navbar-nav">
					<li class="${current== 'index' ? 'active' : '' }"><a
						href='<spring:url value="/" />'>Home</a></li>
					<security:authorize access="hasRole('ROLE_ADMIN')">
						<li class="${current== 'users'? 'active ': '' }"><a
							href='<spring:url value="/users" />'>Users</a></li>
					</security:authorize>
					<security:authorize access="!isAuthenticated()">
						<li class="${current== 'login'? 'active ': '' }"><a
							href='<spring:url value="/login"/>'>Login</a></li>
						<li class="${current== 'register'? 'active ': '' }"><a
							href='<spring:url value="/register"/>'>Register</a></li>
					</security:authorize>
					<security:authorize access="isAuthenticated()">
						<li class="${current== 'logout'? 'active': '' }"><a
							href='<spring:url value="/logout"/>'>Logout</a></li>
						<li class="${current== 'account'? 'active': '' }"><a
							href='<spring:url value="/account"/>'>Account</a></li>	
					</security:authorize>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Dropdown <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="#">Action</a></li>
							<li><a href="#">Another action</a></li>
							<li><a href="#">Something else here</a></li>
							<li role="separator" class="divider"></li>
							<li class="dropdown-header">Nav header</li>
							<li><a href="#">Separated link</a></li>
							<li><a href="#">One more separated link</a></li>
						</ul></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
	</div>
	<!--/.container-fluid -->
	</nav>
	<tiles:insertAttribute name="body"></tiles:insertAttribute>



	<br />
	<br />
	<br />
	<br />
	<center>
		<tiles:insertAttribute name="footer"></tiles:insertAttribute>
	</center>

	</div>

</body>
</html>