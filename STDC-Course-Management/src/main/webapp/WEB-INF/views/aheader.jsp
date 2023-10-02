<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>

<html lang="en">
    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <title>STDC Course Management</title>
        <link href="css/style.css" rel='stylesheet' type='text/css' media="all">
        <!-- Custom fonts for this template-->
        <link href="css/all.css" rel="stylesheet" type="text/css">

        <!-- Custom styles for this template-->
        <link href="css/sb-admin.css" rel="stylesheet">
        <script src="js/jquery-3.4.1.js" type="text/javascript"></script>
    </head>

    <body id="page-top">
        <nav class="navbar navbar-expand navbar-dark bg-dark static-top">     
            <a class="navbar-brand mr-1" href="/dashboard">Welcome ! ${sessionScope.uname }</a>

            <button class="btn btn-link btn-sm text-white order-1 order-sm-0" id="sidebarToggle" href="#">
                <i class="fas fa-bars"></i>
            </button>

        </nav>
        <div id="wrapper">

            <!-- Sidebar -->
            <ul class="sidebar navbar-nav" style="min-height:calc(100vh-46px);">
            <c:choose>
            <c:when test="${sessionScope.role eq 'Admin' }">
                <li class="nav-item active">
                    <a class="nav-link" href="dashboard">
                        <i class="fas fa-fw fa-tachometer-alt"></i>
                        <span>Admin Dashboard</span>
                    </a>
                </li> 
                <li class="nav-item">
                    <a class="nav-link" href="courses">
                        <i class="fas fa-fw fa-users"></i>
                        <span>Courses</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="subjects">
                        <i class="fas fa-fw fa-table"></i>
                        <span>Subjects</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="faculty">
                        <i class="fas fa-fw fa-user-cog"></i>
                        <span>Faculty</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="students">
                        <i class="fas fa-fw fa-user-graduate"></i>
                        <span>Students</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="notifications">
                        <i class="fas fa-fw fa-user-graduate"></i>
                        <span>Notifications</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="feedbacks">
                        <i class="fas fa-fw fa-user-graduate"></i>
                        <span>Feedbacks</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="users">
                        <i class="fas fa-fw fa-users"></i>
                        <span>Users</span></a>
                </li>
           </c:when>
           <c:when test="${sessionScope.role eq 'Faculty' }">
           		<li class="nav-item">
                    <a class="nav-link" href="idashboard">
                        <i class="fas fa-fw fa-users"></i>
                        <span>Dashboard</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="material">
                        <i class="fas fa-fw fa-users"></i>
                        <span>Material</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="assignments">
                        <i class="fas fa-fw fa-users"></i>
                        <span>Assignments</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="notifications">
                        <i class="fas fa-fw fa-user-graduate"></i>
                        <span>Notifications</span></a>
                </li>
           </c:when>
           <c:otherwise>
           		<li class="nav-item">
                    <a class="nav-link" href="sdashboard">
                        <i class="fas fa-fw fa-users"></i>
                        <span>Dashboard</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="smaterial">
                        <i class="fas fa-fw fa-users"></i>
                        <span>Material</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="sassignments">
                        <i class="fas fa-fw fa-users"></i>
                        <span>Assignments</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="feedback">
                        <i class="fas fa-fw fa-users"></i>
                        <span>Feedback</span></a>
                </li>
           </c:otherwise>
           </c:choose>
                <li class="nav-item">
                    <a class="nav-link" href="#content2">
                        <i class="fas fa-fw fa-key"></i>
                        <span>Change Password</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/logout">
                        <i class="fas fa-sign-out-alt"></i>
                        <span>Logout</span></a>
                </li>
            </ul>

            <div id="content-wrapper" style="background:linear-gradient( rgba(255, 255, 255, 0.7) 100%, rgba(255, 255, 255, 0.8)100%),url('images/aaa.PNG');width:100%;background-size: 100% 100%;">

                <div class="container-fluid" style="min-height:88vh;">
                    
