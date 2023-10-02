<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<jsp:include flush="true" page="aheader.jsp" />
<div class="card shadow" style="min-height: 88vh;">
	<div class="card-body">
		<h5 class="p-2" style="border-bottom: 2px solid green;">Assignments
			Available</h5>
		<div class="container-fluid">
			<table class="table table-bordered table-striped table-sm ">
				<thead class="table-dark">
					<tr>
						<th>Material ID</th>
						<th>Subject</th>
						<th>Lecturer</th>
						<th>Submission Date</th>
						<th>Marks</th>
						<th>Operation</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list }" var="m">
					<tr>
						<td>${m.id }</td>
						<td>${m.subject.name }</td>
						<td>${m.faculty.name }</td>
						<td>${m.submitdate }</td>
						<td>${m.marks }</td>
						<td>
						<a href="${m.filename }"
							target="blank" class="btn btn-success btn-sm">Download</a>
						
							</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>
<jsp:include flush="true" page="afooter.jsp" />

