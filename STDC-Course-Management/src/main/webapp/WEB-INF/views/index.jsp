<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<jsp:include flush="true" page="header.jsp" />
<script>
    $(function(){
        $("#role").change(function(){
            if(this.value==="Student"){
               $("#id").attr({"placeholder":"Enter roll no"}); 
            }else if(this.value==="Faculty"){
               $("#id").attr({"placeholder":"Enter Faculty id"});  
            }else{
               $("#id").attr({"placeholder":"First Select role"});  
            }
        });
        $("#cpwd").blur(function(){
           if(this.value !== $("#pwd").val()){
               $("#error2").html("Password not match");
               $("#error2").removeClass("d-none");
           }else{
               $("#error2").addClass("d-none");
           } 
        });
        $("#id").blur(function(){
           $.ajax({
               url:'verify',
               data:{'role':$("#role").val(),'id':this.value},
               method:'get',
               success:function(output){
                   if(output==="Invalid"){
                       $("#error").html("Invalid ID given");
                       $("#error").removeClass("d-none");
                   }else{
                        $("#uname").val(output);
                        $("#error").addClass("d-none");
                    }
               }
           }); 
        });
    });
</script>
<div class="container">

	<div class="row mt-5">
		<div class="col-sm-6">
		<div class="mt-5 rounded" style="min-height: 400px; background-image:url('images/bg-2.jpg'); position: relative;">
			<div class="text-center" style="position:absolute;width:100%; top: 50%; left:50%; transform:translate(-50%,-50%)">
			<img src="images/logo.png" style="width:250px;height:150px;" />
			<h4 class = "text-white" >STDC Course Management</h3>
			<h4 class = "text-white">Login Page</h4>
			</div>
		</div>
		</div>
		<div class="col-sm-5 offset-1 mt-5 card p-4 shadow"
			style="background-color: #7fc6ec5c;">
			
			<form method="post">
				<div class="form-group">
					<label>User ID</label> <input type="text" required name="userid"
						class="form-control form-control-sm">
				</div>
				<div class="form-group">
					<label>Password</label> <input type="password" required name="pwd"
						class="form-control form-control-sm">
				</div>
				<div class="form-group">
					<label>Select Role</label> <select name="role" required
						class="form-control form-control-sm">
						<option value=""><-- Select Role --></option>
						<option>Admin</option>
						<option>Faculty</option>
						<option>Student</option>
					</select>
				</div>
				<button class="btn btn-primary float-left">Login</button>
				<div class="float-right text-light">
				Not Registered?
				<button type="button" data-target="#reg" data-toggle="modal"
					class="btn btn-warning">Click here to register</button>
				</div>
				
			</form>
			<jsp:include page="msg.jsp"></jsp:include>
		</div>
		<div class="modal" id="reg">
			<div class="modal-dialog">
				<div class="modal-content">
					<form action="register" method="post">
						<div class="modal-header">
							<h5>Register Now</h5>
							<button class="close" data-dismiss="modal" type="button">&times;</button>
						</div>
						<div class="modal-body">
							<div class="form-group">
								<select id="role" name="role" required
									class="form-control form-control-sm">
									<option value=""><-- Select Role --></option>
									<option>Faculty</option>
									<option>Student</option>
								</select>
							</div>
							<div class="form-group">
								<input type="text" id="id" placeholder="First Select role"
									name="id" required class="form-control form-control-sm">
							</div>
							<div id="error"
								class="text-danger font-weight-bold text-center d-none"></div>
							<div class="form-group">
								<input type="text" placeholder="User Name" readonly id="uname"
									name="uname" class="form-control form-control-sm">
							</div>
							<div class="form-group">
								<input type="text" required placeholder="User ID" name="userid"
									class="form-control form-control-sm">
							</div>

							<div class="form-group">
								<input id="pwd" required type="password" placeholder="Password"
									name="pwd" class="form-control form-control-sm">
							</div>
							<div class="form-group">
								<input id="cpwd" required type="password" placeholder="Repeat Password"
									name="cpwd" class="form-control form-control-sm">
							</div>
							<div id="error2"
								class="text-danger font-weight-bold text-center d-none"></div>
						</div>
						<div class="modal-footer">
							<button class="btn btn-success float-right">Register</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
<jsp:include flush="true" page="footer.jsp" />