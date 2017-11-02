<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="row">
		<div class="col-xs-4"></div>
		<div class="col-xs-4">
			<table class="table table-bordered table-hover table-striped">
				<thead>
					<tr>
						<th>User name</th>
						<th>Remove User</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${users}" var="user">
						<tr>
							<td><a href="<spring:url value="/users/${user.id}"/>">
									${user.name} </a></td>
							<td><a href="<spring:url value="/user/remove/${user.id}"/>"
								class="btn btn-danger triggerRemoveModal"> Remove </a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

		</div>
	</div>
		
	<!-- Modal -->
<div class="modal fade" id="modalRemove" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Remove blog</h4>
      </div>
      <div class="modal-body">
        Are you sure you want to remove user?
      </div>
      <div class="modal-footer">
       <a href="" class="btn btn-danger removeBtn">Remove </a>
        <button type="button" class="btn btn-default" >Cancel</button>
       
      </div>
    </div>
  </div>
</div>
	<script type="text/javascript">
		$(document).ready(function(){
			//shows first tab			
			$('.triggerRemoveModal').click(function(e){
				e.preventDefault();
				$('#modalRemove .removeBtn').attr("href",$(this).attr("href"));
				$('#modalRemove').modal()
			});
		});
	</script>
</body>

