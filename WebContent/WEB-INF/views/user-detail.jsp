<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
	<div class="row">
		<div class="col-xs-1">
			<h1>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${user.name}</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-xs-1"></div>
		<!-- Modal -->
		<div class="col-xs-2">

			<!-- Button trigger modal -->
			<button type="button" class="btn btn-primary btn-lg"
				data-toggle="modal" data-target="#myModal">New Blog</button>
			<div class="modal fade" id="myModal" tabindex="-5" role="dialog"
				aria-labelledby="myModalLabel">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<h4 class="modal-title" id="myModalLabel">Blog</h4>
						</div>
						<div class="modal-body">
							<form:form commandName="blog" cssClass="form-horizontal">
								<div style="" class="form-group">
									<label for="name" class="col-sm-5 control-label">Name</label>
									<div class="col-sm-3">
										<form:input path="name" cssClass="form-control"
											placeholder="Name of blog" aria-describedby="name" />
									</div>
								</div>
								<div class="form-group">
									<label for="email" class="col-sm-5 control-label">URL</label>
									<div class="col-sm-3">
										<form:input path="url" cssClass="form-control"
											placeholder="URL" />
									</div>
								</div>
								<div class="form-group">
									<label for="password" class="col-sm-5 control-label">Password</label>
									<div class="col-sm-3">
										<form:password path="password" cssClass="form-control"
											placeholder="Password" />
									</div>
								</div>
								<div class="form-group">
									<div class="modal-footer">
										<button type="button" class="btn btn-default"
											data-dismiss="modal">Close</button>
										<button type="button" class="btn btn-primary">Save changes</button>
									</div>

								</div>
							</form:form>
						</div>

					</div>
				</div>
			</div>
		</div>

	</div>



	<div class="row">
		<div class="col-xs-1"></div>
		<div class="col-xs-3">
			<c:forEach items="${user.blogs}" var="blog">
				<h1>${blog.name}</h1>
				<p>${blog.url}</p>
				<center>
					<table
						class="table table-bordered table-hover table-striped table-responsive">
						<thead>
							<tr>
								<th>Title</th>
								<th>Link</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${blog.items}" var="item">
								<tr>
									<td>${item.title}</td>
									<td>${item.link}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</center>
			</c:forEach>

		</div>
	</div>
</body>
</html>
