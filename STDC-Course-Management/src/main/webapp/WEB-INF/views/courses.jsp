<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<jsp:include page="aheader.jsp"/>
<div class='clearfix'></div>
<div class="container-fluid">
    <jsp:include page="msg"/>   
    <div class="row">
        <div class="col-sm-8">
            <h3 class="p-2">Courses</h3>
            <table class="table table-bordered table-sm table-striped">
                <thead class='table-danger'>
                    <tr>
                        <th>ID</th>
                        <th>Course Name</th>
                        <th>Action</th>                      
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${list }" var="c"> 
                     <tr>
                         <td>${c.cid}</td>
                         <td>${c.cname}</td>
                         <td>
                             <a href="delcourse/${c.cid}" onclick="return  confirm('Are you sure to delete this course ?')" 
                             class="btn btn-danger btn-sm"><i class="fa fa-trash"></i>Delete</a>
                         </td>
                     </tr>
                 </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="col-sm-4">
        <h4 class="p-2">Add New Course</h4>
            <form method="post">
                <div class="form-group">
                    <label>Course Name</label>
                    <input type="text" name="cname" class="form-control">
                </div>                
                <button class="btn btn-primary float-right" name="add"><i class="fa fa-plus"></i> Add Course</button>
            </form>
            <jsp:include page="msg.jsp" />            
        </div>
    </div>
</div>
<jsp:include page="afooter.jsp"/>