<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<jsp:include flush="true" page="aheader.jsp" />
<div class="card shadow" style="min-height: 88vh;">
	<div class="card-body">
		<h5 class="p-2" style="border-bottom: 2px solid green;">Faculty Feedback</h5>
		<div class="container-fluid">
    <div class="row">
        <div class="col-sm-8">
            <table  class="table table-bordered table-striped ">
                <thead>
                    <tr>
                        <th>Faculty ID</th>
                        <th>Faculty Name</th>
                        <th>Feedback</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${list }" var="f">
                    <tr>
                        <td>${f.faculty.id }</td>
                        <td>${f.faculty.name }
                        </td>
                        <td>${f.msg }
                        </td>
                    </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="col-sm-4">
            <form method="post">
            <input type="hidden" name="student" value="${sessionScope.id }" />
            <div class="form-group">
                <label>Select Lecturer</label>
                <select name="faculty" class="form-control">
                    <option><-- Select Lecturer --></option>
                    <c:forEach items="${ faculties}" var="f">
                    <option value="${f.id }">${f.name }</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label>Feedback</label>
                <textarea rows="4" name="msg" class="form-control"></textarea>
            </div>
                <button class="btn btn-danger">Submit Feedback</button>
            </form>
        </div>
    </div>
</div>
</div>
</div>
<jsp:include flush="true" page="afooter.jsp" />