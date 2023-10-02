<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<jsp:include flush="true" page="aheader.jsp" />
		<h5 class="p-2" style="border-bottom: 2px solid green;">Faculties Feedback
			</h5>
		<div class="container-fluid">
		<div class="row">
			<div class="col-sm-12">
			<table class="table table-bordered table-sm">
				<thead class="table-dark">
					<tr>
						<th>Roll no</th>
						<th>Student Name</th>
						<th>Faculty ID</th>
						<th>Faculty Name</th>
						<th>Feedback</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list }" var="f">
					<tr>
						<td>${f.student.rollno }</td>
						<td>${f.student.name }</td>
						<td>${f.faculty.id }</td>
						<td>${f.faculty.name }</td>
						<td>${f.msg }</td>
						<td><a href="delfeedback/${f.id }" class="btn btn-danger btn-sm">Delete</a></td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
			</div>
		</div>
			
		</div>
 <jsp:include flush="true" page="afooter.jsp" /> 