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
    <title>教务管理系统-教师端</title>
    <link rel="stylesheet" type="text/css" href="${path}assets/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${path}assets/css/bootstrap-table.min.css">
    <link rel="stylesheet" type="text/css" href="${path}assets/css/iconfont.css">
    <link rel="stylesheet" type="text/css" href="${path}assets/css/style.css">
</head>
<body>
<div class="skin-default" id="wrapper">
    <header class="navbar-header">
        <div class="brand">
            <a class="navbar-brand" href="#" title="AlphaAdmin">欢迎，${sessionScope.user.tName}</a>
        </div>
        <div class="navbar">
            <i class="sidebar-toggle iconfont icon-menu" data-toggle="push-menu" role="button">
            </i>
            <div class="navbar-menu pull-right">
                <ul class="nav navbar-nav">


                    <li class="dropdown user">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#"
                           title="用户">${sessionScope.user.tName}</a>
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
                <p class="title">${sessionScope.user.tName}</p>
                <strong>${sessionScope.identity}</strong>
            </div>
        </div>
        <section class="sidebar">
            <ul class="sidebar-menu" data-widget="tree">
                <%--主页--%>
                <li>
                    <a href="${path}pages/teacher/index.jsp" title="主页">
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
                            <a href="#" data-toggle="modal" data-target=".menu-studentScore">
                                <i class="iconfont icon-circle-hollow"></i>
                                <small>学生成绩查询</small>
                            </a>
                        </li>
                        <li>
                            <a data-toggle="modal" data-target=".menu-courseScore" href="#">
                                <i class="iconfont icon-circle-hollow"></i>
                                <small>课程成绩查询</small>
                            </a>
                        </li>
                    </ul>
                </li>
                <%--成绩录入--%>
                <li class="treeview">
                    <a href="#" title="成绩录入">
                        <i class="iconfont icon-pencil"></i>
                        <small>成绩录入</small>
                        <span class=" pull-right">
								<i class="iconfont icon-menu-left-small"></i>
							</span>
                    </a>
                    <ul class="treeview-menu">
                        <li>
                            <a href="#" data-toggle="modal" data-target=".menu-inputScoreBySno">
                                <i class="iconfont icon-circle-hollow"></i>
                                <small>按学生录入成绩</small>
                            </a>
                        </li>
                        <li>
                            <a data-toggle="modal" data-target=".menu-inputScoreByCno" href="#">
                                <i class="iconfont icon-circle-hollow"></i>
                                <small>按课程录入成绩</small>
                            </a>
                        </li>
                    </ul>
                </li>
                <%--学生成绩排名--%>
                <li class="active">
                    <a data-target=".menu-rank" data-toggle="modal" href="#" title="学生成绩排名">
                        <i class="iconfont icon-chart"></i>
                        <small>学生成绩排名</small>
                    </a>
                </li>
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
                <small>教师端</small>
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
                        学生成绩排名
                    </small>
                </li>
            </ol>
        </div>
        <div class="row widget">
            <section class="col-lg-12 widget-drag">
                <div class="box table">
                    <div class="box-header" data-trigger="drag">
                        <h3 class="box-title">
                            《${requestScope.scList[0].course.cName}》学生成绩排名
                        </h3>
                        <div class="box-tools pull-right">
                            <button class="" type="button" data-toggle="collapse">
                                <i class="iconfont icon-minus"></i>
                            </button>
                        </div>
                    </div>
                    <div class="box-body" id="table">
                        <div class="table-responsive" style="overflow: auto;height: 500px">
                            <table class="table table-striped table-bordered table-hover">
                                <thead>
                                <tr>
                                    <th>排名</th>
                                    <th>成绩</th>
                                    <th>学号</th>
                                    <th>姓名</th>
                                    <th>性别</th>
                                    <th>专业</th>
                                    <th>班级</th>
                                    <th>状态</th>
                                </tr>
                                </thead>
                                <tbody>
                                <%! int i = 1;%>
                                <c:forEach items="${requestScope.scList}" var="scList">
                                    <tr>
                                        <td class="text-primary"><%= i++%>
                                        </td>
                                        <td class="text-danger">${scList.score}</td>
                                        <td>${scList.student.sNo}</td>
                                        <td>${scList.student.sName}</td>
                                        <td>${scList.student.sSex}</td>
                                        <td>${scList.student.sDept}</td>
                                        <td>${scList.student.sClass}</td>
                                        <c:if test="${scList.score >= 60}">
                                            <td class="td-status">
                                                <span class="label label-success">及格</span>
                                            </td>
                                        </c:if>
                                        <c:if test="${scList.score < 60 && scList.score > -1}">
                                            <td class="td-status">
                                                <span class="label label-danger">不及格</span>
                                            </td>
                                        </c:if>
                                        <c:if test="${scList.score == -1}">
                                            <td class="td-status">
                                                <span class="label label-warning">未开始考试</span>
                                            </td>
                                        </c:if>
                                    </tr>
                                </c:forEach>
                                <% i = 1;%>
                                </tbody>
                            </table>
                            <p class="text">共${fn:length(requestScope.scList)}条记录</p>
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