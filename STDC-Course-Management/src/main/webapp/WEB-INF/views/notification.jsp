<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<jsp:include flush="true" page="aheader.jsp" />
<div class="card shadow" style="min-height: 88vh;">
	<div class="card-body">
		<h5 class="p-2" style="border-bottom: 2px solid green;">
			Notifications</h5>
		<div class="container-fluid">
			<div class="row">
				<div class="col-sm-8">
					<table class="table table-bordered table-striped table-sm">
						<thead>
							<tr>
								<th>Message</th>
								<th>Message Date</th>
								<th>Action</th>
							</tr>
						</thead>
						<tbody>
						<c:forEach items="${list }" var="m">
							<tr>
							<td>${m.message }</td>
							<td>${m.createdon }</td>
								<td><a onclick="return confirm('Are you sure to delete this message ?')" href="/delnot/${m.id }"
									class="btn btn-danger btn-sm">Delete</a></td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<div class="col-sm-4">
					<form method="post">
					<c:if test="${sessionScope.role eq 'Faculty' }">
						<input type='hidden' name='faculty' value="${sessionScope.id }" />
					</c:if>
						<div class="form-group">
							<label>Message</label>
							<textarea name="message" class="form-control" rows="4"></textarea>
						</div>
						<button class="btn btn-danger">Submit</button>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
<jsp:include flush="true" page="footer.jsp" />