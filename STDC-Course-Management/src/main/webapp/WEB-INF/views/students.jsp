<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<jsp:include flush="true" page="aheader.jsp" />
<div class="card shadow" style="min-height: 88vh;">
	<div class="card-body">
		<button data-target="#ladd" data-toggle="modal"
			class="btn btn-primary btn-sm float-right">
			<i class="fa fa-plus"></i> Add Student
		</button>
		<h5 class="p-2" style="border-bottom: 2px solid green;">Students</h5>
		<div class="container-fluid">
		<jsp:include page="msg.jsp" />
			<table class="table table-bordered table-sm table-striped">
				<thead>
					<tr>
						<th style="width: 100px;">Roll no</th>
						<th style="width: 200px">Student Name</th>
						<th>City</th>
						<th>Gender</th>
						<th>Email</th>
						<th>Course</th>
						<th style="width: 200px">Action</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${list }" var="s">
					<tr>
						<td>${s.rollno }</td>
						<td>${s.name }</td>
						<td>${s.city }</td>
						<td>${s.gender }</td>
						<td>${s.email }</td>
						<td>${s.course.cname }</td>
						<td style="width: 150px">
							<a href="delstudent/${s.rollno }" onclick="return confirm('Are you sure to delete this student ?')" class="btn btn-danger btn-sm">
								<i class="fa fa-trash"></i> Delete
							</a>
							<button type="button"
								data-target="#medit${s.rollno }"
								data-toggle="modal" class="btn btn-primary btn-sm">
								<i class="fa fa-edit"></i> Edit
							</button>
						</td>
					</tr>
					
					<div class="modal" id="medit${s.rollno }">
						<div class="modal-dialog">
							<div class="modal-content">
								<form method="post">
									<div class="modal-header">
										<h5>Update Student Information</h5>
										<button type="button" class="close" data-dismiss="modal">&times;</button>
									</div>
									<div class="modal-body">
										<div class="form-group">
											<label>Roll no</label> <input type="text" 
												value="${s.rollno }" name="rollno"
												class="form-control form-control-sm">
										</div>
										<div class="form-group">
											<label>Student Name</label> <input type="text"
												value="${s.name }" name="name"
												class="form-control form-control-sm">
										</div>
										<div class="form-group">
											<label>City</label> <input type="text"
												value="${s.city }" name="city"
												class="form-control form-control-sm">
										</div>
										<div class="form-group">
											<label>Gender</label> <select name="gender"
												class="form-control form-control-sm">
												<option
													${s.gender eq 'Male' ? 'selected':'' }>Male</option>
												<option
													${s.gender eq 'Female' ? 'selected':'' }>Female</option>
											</select>
										</div>
										<div class="form-group">
											<label>Email ID</label> <input type="email"
												value="${s.email }" name="email"
												class="form-control form-control-sm">
										</div>
										<div class="form-group">
											<label>Class</label> 
											<select name="cid" class="form-control form-control-sm">                    
						                        <option value="">Select Course</option>
						                        <c:forEach items="${clist }" var="c">
						                        <option ${c.cid eq s.course.cid ? 'selected':'' } value="${c.cid }">${c.cname }</option> 
						                        </c:forEach>
						                    </select>
										</div>
									</div>
									<div class="modal-footer">
										<button class="btn btn-primary">Update Student</button>
									</div>
								</form>
							</div>
						</div>
					</div>
				</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>
<div class="modal" id="ladd">
	<div class="modal-dialog">
		<div class="modal-content">
			<form method="post">
				<div class="modal-header">
					<h5>Add New Student</h5>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<label>Student Name</label> <input type="text" required
							name="name" class="form-control form-control-sm">
					</div>
					<div class="form-group">
						<label>City</label> <input type="text" required name="city"
							class="form-control form-control-sm">
					</div>
					<div class="form-group">
						<label>Gender</label> <select name="gender" class="form-control form-control-sm">
							<option>Male</option>
							<option>Female</option>
						</select>
					</div>
					<div class="form-group">
						<label>Email ID</label> <input type="email" required name="email"
							class="form-control form-control-sm">
					</div>
					<div class="form-group">
						<label>Course</label>
                    <select name="cid" class="form-control form-control-sm">                    
                        <option value="">Select Course</option>
                        <c:forEach items="${clist }" var="c">
                        <option value="${c.cid }">${c.cname }</option> 
                        </c:forEach>
                    </select>
					</div>
				</div>
				<div class="modal-footer">
					<button class="btn btn-primary btn-sm">Add Student</button>
				</div>
			</form>
		</div>
	</div>
</div>
<jsp:include flush="true" page="afooter.jsp" />