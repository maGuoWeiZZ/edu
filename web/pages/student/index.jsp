<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    request.setAttribute("path", basePath);
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>教务管理系统-学生端</title>
    <link rel="stylesheet" type="text/css" href="${path}assets/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${path}assets/css/bootstrap-table.min.css">
    <link rel="stylesheet" type="text/css" href="${path}assets/css/iconfont.css">
    <link rel="stylesheet" type="text/css" href="${path}assets/css/style.css">
</head>
<body>
<div class="skin-default" id="wrapper">
    <header class="navbar-header">
        <div class="brand">
            <a class="navbar-brand" href="#" title="AlphaAdmin">欢迎，${sessionScope.user.sName}</a>
        </div>
        <div class="navbar">
            <i class="sidebar-toggle iconfont icon-menu" data-toggle="push-menu" role="button">
            </i>
            <div class="navbar-menu pull-right">
                <ul class="nav navbar-nav">


                    <li class="dropdown user">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#"
                           title="用户">${sessionScope.user.sName}</a>
                        <ul class="dropdown-menu">
                            <li>
                                <a data-toggle="modal" data-target=".menu-setpassword" href="#" title="修改密码">
                                    <i class="iconfont icon-menu-user"></i>
                                    修改密码
                                </a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <a data-toggle="modal" data-target=".menu-logout" href="#" title="登出">
                                    <i class="iconfont icon-power"></i>
                                    退出登录
                                </a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </header>
    <!-- 左侧导航 -->
    <aside class="main-sidebar">
        <div class="user-panel">
            <div class="image pull-left">
                <img src="${path}assets/avatars/avatars.png" alt="">
            </div>
            <div class="info pull-right">
                <p class="title">${sessionScope.user.sName}</p>
                <strong>${sessionScope.identity}</strong>
            </div>
        </div>
        <section class="sidebar">
            <ul class="sidebar-menu" data-widget="tree">
                <%--主页--%>
                <li class="active">
                    <a href="${path}pages/student/index.jsp" title="主页">
                        <i class="iconfont icon-home"></i>
                        <small>主页</small>
                    </a>
                </li>
                <%--成绩查询--%>
                <li class="treeview">
                    <a href="#" title="成绩查询">
                        <i class="iconfont icon-form"></i>
                        <small>成绩查询</small>
                        <span class=" pull-right">
								<i class="iconfont icon-menu-left-small"></i>
							</span>
                    </a>
                    <ul class="treeview-menu">
                        <li>
                            <a href="${path}student/selectSCBySno?sNo=${sessionScope.user.sNo}">
                                <i class="iconfont icon-circle-hollow"></i>
                                <small>个人成绩查询</small>
                            </a>
                        </li>
                        <li>
                            <a data-toggle="modal" data-target=".menu-select" href="#">
                                <i class="iconfont icon-circle-hollow"></i>
                                <small>精确成绩查询</small>
                            </a>
                        </li>
                    </ul>
                </li>
                <%--选课管理--%>
                <li class="treeview">
                    <a href="#" title="选课管理">
                        <i class="iconfont icon-list-th"></i>
                        <small>选课管理</small>
                        <span class=" pull-right">
								<i class="iconfont icon-menu-left-small"></i>
							</span>
                    </a>
                    <ul class="treeview-menu">
                        <li>
                            <a href="${path}student/selectCourseList?sNo=${sessionScope.user.sNo}">
                                <i class="iconfont icon-circle-hollow"></i>
                                <small>查询已选课程</small>
                            </a>
                        </li>
                        <li>
                            <a href="${path}student/getSelectedAndNotSelectedCourse?sNo=${sessionScope.user.sNo}">
                                <i class="iconfont icon-circle-hollow"></i>
                                <small>选课</small>
                            </a>
                        </li>
                    </ul>
                </li
                <%--修改密码--%>
                <li>
                    <a data-target=".menu-setpassword" data-toggle="modal" href="#" title="修改密码">
                        <i class="iconfont icon-lock"></i>
                        <small>修改密码</small>
                    </a>
                </li>
                <%--退出登录--%>
                <li>
                    <a data-target=".menu-logout" data-toggle="modal" href="#" title="退出登录">
                        <i class="iconfont icon-power"></i>
                        <small>退出登录</small>
                    </a>
                </li>
            </ul>
        </section>
    </aside>
    <div class="page-wrapper">
        <div class="page-header">
            <h1 class="title">
                教务管理系统
                <small>学生端</small>
            </h1>
            <ol class="breadcrumb">
                <li class="active">
                    <a href="#" title="主页">
                        <i class="iconfont icon-home"></i>
                        <small>主页</small>
                    </a>
                </li>
            </ol>
        </div>
        <section class="page-body">
            <div class="row">
                <div class="fettle login">
                    <h1 class="title">
                        登录信息
                    </h1>
                    <div class="table-responsive">
                        <table class="table table-striped">
                            <tbody>
                            <tr>
                                <td>
                                    登录时间：<span>${sessionScope.loginTime}</span>
                                </td>
                                <td>
                                    登录IP：<span>${sessionScope.ip}</span>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="fettle system">
                    <h1>学生信息</h1>
                    <div class="table-responsive">
                        <table class="table table-striped table-hover">
                            <tbody>
                            <tr>
                                <td>学号：</td>
                                <td>${sessionScope.user.sNo}</td>
                                <td>姓名：</td>
                                <td>${sessionScope.user.sName}</td>
                            </tr>
                            <tr>
                                <td>性别：</td>
                                <td>${sessionScope.user.sSex}</td>
                                <td>年龄：</td>
                                <td>${sessionScope.user.sAge}</td>
                            </tr>
                            <tr>
                                <td>专业：</td>
                                <td>${sessionScope.user.sDept}</td>
                                <td>班级：</td>
                                <td>${sessionScope.user.sClass}</td>
                            </tr>
                            <tr>
                                <td>当前操作者:</td>
                                <td>${sessionScope.user.sName}</td>
                                <td>当前IP:</td>
                                <td>${sessionScope.ip}</td>
                            </tr>
                            <tr>
                                <td>当前版本:</td>
                                <td>教务管理系统 v1.0(20211114)</td>
                                <td>当前时间:</td>
                                <td>${sessionScope.loginTime}</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <div class="fettle row widget">
                <h1 class="title">功能模块</h1>
                <div class="col-md-3 col-xs-12 col-sm-6">
                    <div class="small-box">
                        <div class="small-box-icon bg-lightskyblue">
                            <i class="iconfont icon-list"></i>
                        </div>
                        <div class="small-box-inner">
                            <p></p>
                            <h1 class="data fg-lightskyblue">已选课程</h1>
                            <a class="more"
                               href="${path}student/selectCourseList?sNo=${sessionScope.user.sNo}"
                               title="查看已选课程">查看已选课程</a>
                        </div>
                    </div>
                </div>
                <div class="col-md-3 col-xs-12 col-sm-6">
                    <div class="small-box">
                        <div class="small-box-icon bg-green">
                            <i class="iconfont icon-search"></i>
                        </div>
                        <div class="small-box-inner">
                            <p></p>
                            <h1 class="data fg-green">成绩查询</h1>
                            <a class="more"
                               href="${path}student/selectSCBySno?sNo=${sessionScope.user.sNo}"
                               title="查看成绩">成绩查询</a>
                        </div>
                    </div>
                </div>
                <div class="col-md-3 col-xs-12 col-sm-6">
                    <div class="small-box">
                        <div class="small-box-icon bg-yellow">
                            <i class="iconfont icon-star"></i>
                        </div>
                        <div class="small-box-inner">
                            <p></p>
                            <h1 class="data fg-yellow">选课</h1>
                            <a class="more"
                               href="${path}student/getSelectedAndNotSelectedCourse?sNo=${sessionScope.user.sNo}"
                               title="去选课">
                                去选课
                            </a>
                        </div>
                    </div>
                </div>
                <div class="col-md-3 col-xs-12 col-sm-6">
                    <div class="small-box">
                        <div class="small-box-icon bg-green">
                            <i class="iconfont icon-lock"></i>
                        </div>
                        <div class="small-box-inner">
                            <p></p>
                            <h1 class="data fg-green">修改密码</h1>
                            <a class="more" data-toggle="modal" data-target=".menu-setpassword" href="#" title="修改密码">修改密码</a>
                        </div>
                    </div>
                </div>
            </div>
            <%@include file="common.jsp"%>
        </section>
    </div>
</div>
</body>
</html>