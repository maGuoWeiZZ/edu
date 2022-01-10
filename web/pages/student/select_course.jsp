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
    <title>选课</title>
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
                                    登出
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
                <li>
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
                        <li class="active">
                            <a data-toggle="modal" data-target=".menu-select" href="#">
                                <i class="iconfont icon-circle-hollow"></i>
                                <small>精确成绩查询</small>
                            </a>
                        </li>
                    </ul>
                </li>
                <%--选课管理--%>
                <li class="treeview active">
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
                        <li class="active">
                            <a href="#">
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
    <%--内容导航层级--%>
    <div class="page-wrapper">
        <div class="page-header">
            <h1 class="title">
                教务管理系统
                <small>学生端</small>
            </h1>
            <ol class="breadcrumb">
                <li>
                    <a href="#" title="主页">
                        <i class="iconfont icon-home"></i>
                        <small>主页</small>
                    </a>
                </li>
                <li>
                    <small>
                        选课管理
                    </small>
                </li>
                <li class="active">
                    <small>
                        选课
                    </small>
                </li>
            </ol>
        </div>
        <%--主体--%>
        <div class="row widget">
            <section class="col-lg-12 widget-drag">
                <div class="box table">
                    <div class="box-header" data-trigger="drag">
                        <h3 class="box-title">
                            选课列表
                        </h3>
                        <label class="label label-success">${requestScope.selectCourseMsg}</label>
                        <div class="box-tools pull-right">
                            <button class="" type="button" data-toggle="collapse">
                                <i class="iconfont icon-minus"></i>
                            </button>
                        </div>
                    </div>
                    <div class="box-body" id="table">
                        <div class="table-responsive">
                            <table class="table table-striped table-bordered table-hover">
                                <thead>
                                <tr>
                                    <th>课程号</th>
                                    <th>课程名</th>
                                    <th>学分</th>
                                    <th>类型</th>
                                    <th>状态</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <%--未选课程--%>
                                <c:forEach items="${requestScope.notSelected}" var="course">
                                    <tr>
                                        <td>${course.cNo}</td>
                                        <td>${course.cName}</td>
                                        <td>${course.credit}</td>
                                        <td>${course.remarks}</td>

                                        <td class="td-status">
                                            <span class="label label-warning">未选</span>
                                        </td>
                                        <td class="td-status">
                                            <form onsubmit="return confirm('是否选课《${course.cName}》？')"
                                                  action="${path}student/selectCourse?sNo=${sessionScope.user.sNo}&cNo=${course.cNo}"
                                                  method="post">
                                                <button type="submit" class="label label-primary">选课</button>
                                            </form>
                                        </td>
                                    </tr>
                                </c:forEach>
                                <%--已选课程--%>
                                <c:forEach items="${requestScope.selected}" var="course">
                                    <tr>
                                        <td>${course.cNo}</td>
                                        <td>${course.cName}</td>
                                        <td>${course.credit}</td>
                                        <td>${course.remarks}</td>

                                        <td class="td-status">
                                            <span class="label label-success">已选</span>
                                        </td>
                                        <td class="td-status">
                                            <form onsubmit="return confirm('确认退课《${course.cName}》？退课后该门课成绩也会失效！！！')"
                                                  action="${path}student/deleteSelectCourse?sNo=${sessionScope.user.sNo}&cNo=${course.cNo}"
                                                  method="post">
                                                <button type="submit" class="label label-danger">退课</button>
                                            </form>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </section>
        </div>
        <%@include file="common.jsp"%>
        </section>
    </div>
</div>
</body>
</html>