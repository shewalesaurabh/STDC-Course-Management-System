<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<jsp:include flush="true" page="aheader.jsp" />
<div class="card shadow" style="min-height: 88vh;">
	<div class="card-body">
		<button data-target="#ladd" data-toggle="modal"
			class="btn btn-primary btn-sm float-right">
			<i class="fa fa-plus"></i> Add Faculty
		</button>
		<h5 class="p-2" style="border-bottom: 2px solid green;">Faculties</h5>
		<div class="container-fluid">
		<jsp:include page="msg.jsp" />
			<table class="table table-bordered table-sm table-striped">
				<thead>
					<tr>
						<th>Faculty ID</th>
						<th>Faculty Name</th>
						<th>City</th>
						<th>Gender</th>
						<th>Email</th>
						<th>Qualification</th>
						<th style="width: 200px;">Operation</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${list }" var="s">
					<tr>
						<td>${s.id }</td>
						<td>${s.name }</td>
						<td>${s.city }</td>
						<td>${s.gender }</td>
						<td>${s.email }</td>
						<td>${s.qual }</td>
						<td style="width: 150px"><button type="button"
								data-target="#mdel${s.id }"
								data-toggle="modal" class="btn btn-danger btn-sm">
								<i class="fa fa-trash"></i> Delete
							</button>
							<button type="button"
								data-target="#medit${s.id }"
								data-toggle="modal" class="btn btn-primary btn-sm">
								<i class="fa fa-edit"></i> Edit
							</button> <!-- edit dialog -->
							<div class="modal fade" id="medit${s.id }">
								<div class="modal-dialog">
									<div class="modal-content">
										<form method="post">
											<div class="modal-header">
												<h5>Edit Faculty Details</h5>
												<button class="close" data-dismiss="modal">&times;</button>
											</div>
											<div class="modal-body">
												<div class="form-group">
												<input type="hidden" name="id" value="${s.id }"/>
													<label>Faculty Name</label> <input type="text"
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
													<label>Qualification</label> <input type="text"
														value="${s.qual }" name="qual"
														class="form-control form-control-sm">
												</div>
											</div>
											<div class="modal-footer">
												<input type="hidden" name="lid"
													value="${s.id }">
												<button class="btn btn-danger">Save Details</button>
											</div>
										</form>
									</div>
								</div>
							</div> <!-- Delete dialog -->
							<div class="modal fade" id="mdel${s.id }">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											<h5>Delete Confirmation</h5>
											<button class="close" data-dismiss="modal">&times;</button>
										</div>
										<div class="modal-body">
											<h6>
												Are you sure to delete Faculty named ${s.name }<b></b>
												?
											</h6>
										</div>
										<div class="modal-footer">
											<a href="dellect/${s.id }" class="btn btn-danger btn-sm">Delete Faculty</a>
										</div>
									</div>
								</div>
							</div></td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="modal" id="ladd">
			<div class="modal-dialog">
				<div class="modal-content">
					<form method="post">
						<div class="modal-header">
							<h5>Add New Faculty</h5>
							<button type="button" class="close" data-dismiss="modal">&times;</button>
						</div>
						<div class="modal-body">
							<div class="form-group">
								<label>Faculty Name</label> <input type="text" required
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
								<label>Email ID</label> <input type="email" required
									name="email" class="form-control form-control-sm">
							</div>
							<div class="form-group">
								<label>Qualification</label> <input type="text" required
									name="qual" class="form-control form-control-sm">
							</div>
						</div>
						<div class="modal-footer">
							<button class="btn btn-primary btn-sm">Add Faculty</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
<jsp:include flush="true" page="afooter.jsp" />