<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<jsp:include flush="true" page="aheader.jsp" />
<div class="card shadow" style="min-height:88vh;">
	<div class="card-body">
<div class="container-fluid">
    <div class="row">
        <div class="col-sm-6">
            <h5 class="p-2" style="border-bottom:2px solid green;">Student Profile</h5>
            <table class="table table-bordered">
                <tr>
                    <th>Roll no</th>
                    <th>${std.rollno }</th>
                </tr>
                <tr>
                    <th>Student Name</th>
                    <th>${std.name }</th>
                </tr>
                <tr>
                    <th>Gender</th>
                    <th>${std.gender }</th>
                </tr>
                <tr>
                    <th>City</th>
                    <th>${std.city }</th>
                </tr>
                <tr>
                    <th>Email ID</th>
                    <th>${std.email }</th>
                </tr>
            </table>
            <jsp:include page="msg.jsp" />
        </div>
        <div class="col-sm-6 card" style="height:400px;">
            <h5 class="p-2" style="border-bottom:2px solid green;">Last 10 Notifications</h5>
            <marquee onmouseover="stop()" onmouseout="start()" direction="up" style="height:100%">
                <ol>
                    <c:forEach items="${list }" var="m"> 
                    <div class="card shadow m-2"> 
                    <div class="card-body">                                              
                    <li>Message from <b>${m.fromAdmin ? 'Admin' : m.faculty.name }</b> Dated : <b>${m.createdon }</b>
                    <br> <b class="text-success">${m.message }</b></li>
                    </div>
                    </div>
                    </c:forEach>
                </ol>
            </marquee>
        </div>
    </div>
</div>
</div>
</div>
<jsp:include flush="true" page="afooter.jsp" />