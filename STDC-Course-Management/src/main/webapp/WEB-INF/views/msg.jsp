<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<c:if test="${msg ne null }">	
	<div class="alert text-success mt-2 text-center font-weight-bold">
		${msg }
	</div>
</c:if>
<c:if test="${error ne null }">	
	<div class="alert text-danger mt-2 text-center font-weight-bold">
		${error }
	</div>
</c:if>