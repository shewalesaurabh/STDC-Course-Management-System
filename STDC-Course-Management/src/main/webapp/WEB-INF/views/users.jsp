<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<jsp:include flush="true" page="aheader.jsp" />
<div class="card shadow" style="min-height: 88vh;">
	<div class="card-body">
		<h5 class="p-2" style="border-bottom: 2px solid green;">All Users</h5>
		<div class="container-fluid">
<table class="table table-bordered table-sm table-striped">
    <thead class="table-dark">
        <tr>
            <th>User ID</th>
            <th>User Name</th>
            <th>Role</th>
            <th>Password</th>
            <th>ID</th>
            <th>Status</th>
        </tr>
    </thead>
    <tbody>
    <c:forEach items="${list }" var="u">
        <tr>
        <td>${u.userid }</td>
        <td>${u.uname }</td>
        <td>${u.role }</td>
        <td>${u.pwd }</td>
        <td>${u.id }</td>
        <td>${u.active ? 'Active' : 'Inactive' }</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</div>
</div>
</div>
<jsp:include flush="true" page="afooter.jsp" />



