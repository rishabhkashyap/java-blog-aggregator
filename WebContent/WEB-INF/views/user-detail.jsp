<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
	<div class="row">
		<div class="col-xs-5">
		<div class="col-xs-4"></div>
			<h1>${user.name}</h1>
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
