<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<jsp:include flush="true" page="aheader.jsp" />
<div class="card shadow" style="min-height: 88vh;">
	<div class="card-body">
		<h5 class="p-2" style="border-bottom: 2px solid green;">Material
			Management</h5>
		<div class="container-fluid">
			<div class="row">
				<div class="col-sm-8">
					<table class="table table-bordered table-sm">
						<thead>
							<tr>
								<th>Material ID</th>
								<th>Subject</th>
								<th>File Name</th>
								<th>Operation</th>
							</tr>
						</thead>
						<tbody>
						<c:forEach items="${list }" var="m">
							<tr>
								<td>${m.id }</td>
								<td>${m.subject.name }</td>
								<td>${m.filename }</td>
								<td><a href="${m.filename }"
									target="blank" class="btn btn-success btn-sm">Download</a> <a
									onclick="return confirm('Are you sure to delete this material ?')"
									href="delmat/${m.id }"
									class="btn btn-danger btn-sm">Delete</a></td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<div class="col-sm-4">
					<h5 class="text-dark">Upload New Material</h5>
					<div class="form-group">
					<form name="f1">
						<label>Select Course</label> <select name="cid"
							class="form-control form-control-sm" onchange="f1.submit()">
							<option><-- Select Course --></option>
							<c:forEach items="${clist }" var="c">
							<option ${c.cid eq param.cid ? 'selected':'' } value="${c.cid }">${c.cname }</option>
							</c:forEach>
						</select>
					</form>
					</div>
					<form method="post"
				enctype="multipart/form-data">
				<input type="hidden" name="cid" value="${param.cid }">
					<div class="form-group">
						<label>Select Subject</label> <select name="sid"
							class="form-control form-control-sm">
							<option><-- Select Subject --></option>
							<c:forEach items="${subs }" var="s">
							<option value="${s.sid }">${s.name }</option>
							</c:forEach>
						</select>
					</div>
					<div class="form-group">
						<label>Select Material</label> <input type="file" name="material"
							class="form-control-file" accept=".jpg,.pdf,.doc,.docx,.mp4">
					</div>
					<button class="btn btn-primary float-right btn-sm">Upload Material</button>
					</form>
				</div>
			</div>

		</div>
	</div>
</div>
<jsp:include flush="true" page="afooter.jsp" />