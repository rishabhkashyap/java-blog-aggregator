<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<center>
<br /><br /><br /><br />

	<form:form commandName="user" cssClass="form-horizontal">
		<div class="form-group">
			<label for="name" class="col-sm-4 control-label">Name</label>
			<div class="col-sm-3">
				<form:input path="name" cssClass="form-control"
					placeholder="User name" aria-describedby="name" />
			</div>
			
		</div>		

		<div class="form-group">
			<label for="email" class="col-sm-4 control-label">Email</label>
			<div class="col-sm-3">
				<form:input path="email" cssClass="form-control" placeholder="Email" />
			</div>
		</div>
		<div class="form-group">
			<label for="password" class="col-sm-4 control-label">Password</label>
			<div class="col-sm-3">
				<form:password path="password" cssClass="form-control"
					placeholder="Password" />
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-11">
			<br /><br />
				<button type="submit" class="btn btn-primary">Submit</button>
			</div>
		</div>		
	</form:form>
</center>