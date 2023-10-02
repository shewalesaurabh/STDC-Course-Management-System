<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<jsp:include flush="true" page="aheader.jsp" />
<h3>Admin Dashboard</h3>
<div class="container-fluid">
<jsp:include page="msg.jsp" />
<div class="row">
<div class="col-sm-6">
    <div class="row">
        <div class="col-sm-6">
	        <div class="card shadow mb-2">
	        	<div class="card-body bg-primary p-4 text-white text-right">
		            <h5>Uploaded Materials</h5>
		            <h6>${materials }</h6>        	
	        	</div>
	        </div>
        </div>
        <div class="col-sm-6">
	        <div class="card shadow mb-2">
	        	<div class="card-body bg-danger p-4 text-white text-right">
		            <h5>Lecturers</h5>
		            <h6>${lecturers }</h6>        	
	        	</div>
	        </div>
        </div>
        <div class="col-sm-6">
	        <div class="card shadow mb-2">
	        	<div class="card-body bg-dark p-4 text-white text-right">
		            <h5>Students</h5>
		            <h6>${students }</h6>        	
	        	</div>
	        </div>
        </div>
        <div class="col-sm-6">
	        <div class="card shadow mb-2">
	        	<div class="card-body bg-info p-4 text-white text-right">
		            <h5>Registered Users</h5>
		            <h6>${users }</h6>        	
	        	</div>
	        </div>
        </div>
        
    </div>
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
<jsp:include flush="true" page="afooter.jsp" />
