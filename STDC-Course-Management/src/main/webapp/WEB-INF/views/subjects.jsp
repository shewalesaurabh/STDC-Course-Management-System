<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<jsp:include flush="true" page="aheader.jsp" />
<div class="card shadow" style="min-height: 88vh;">
	<div class="card-body">
		<h5 class="p-2" style="border-bottom: 3px solid green;">Subjects</h5>
		<div class="container-fluid">
    <div class="row">
        <div class="col-sm-8">
            <table class="table table-bordered table-sm table-striped">
                <thead class="table-dark">
                    <tr>
                        <th>Subject ID</th>
                        <th>Subject Name</th>
                        <th>Course</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${list }" var="s">
                    <tr>
                    	<td>${s.sid }</td>
                    	<td>${s.name }</td>
                    	<td>${s.course.cname }</td>
                    	<td><a href="delsubject/${s.sid}" onclick="return  confirm('Are you sure to delete this subject ?')" 
                             class="btn btn-danger btn-sm"><i class="fa fa-trash"></i> Delete</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="col-sm-4 p-0">
            <form method="post">                      
                <div class="form-group">
                    <label>Course</label>
                    <select name="cid" class="form-control">                    
                        <option value="">Select Course</option>
                        <c:forEach items="${clist }" var="c">
                        <option value="${c.cid }">${c.cname }</option> 
                        </c:forEach>
                    </select>
                </div>                
                <div class="form-group">
                    <label>Subject Name</label>
                    <input type="text" name="sname" class="form-control">
                </div>                                
                <button class="btn btn-primary float-right" name="add"><i class="fa fa-plus"></i> Save Subject</button>
            </form>
            <jsp:include page="msg.jsp" />
        </div>
    </div>
</div>
</div>
</div>

<jsp:include flush="true" page="afooter.jsp" />
