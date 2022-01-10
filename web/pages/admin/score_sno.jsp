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
    <title>教务管理系统-管理员端</title>
    <link rel="stylesheet" type="text/css" href="${path}assets/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${path}assets/css/bootstrap-table.min.css">
    <link rel="stylesheet" type="text/css" href="${path}assets/css/iconfont.css">
    <link rel="stylesheet" type="text/css" href="${path}assets/css/style.css">
</head>
<body>
<div class="skin-default" id="wrapper">
    <header class="navbar-header">
        <div class="brand">
            <a class="navbar-brand" href="#" title="AlphaAdmin">欢迎，${sessionScope.user.username}</a>
        </div>
        <div class="navbar">
            <i class="sidebar-toggle iconfont icon-menu" data-toggle="push-menu" role="button">
            </i>
            <div class="navbar-menu pull-right">
                <ul class="nav navbar-nav">
                    <li class="dropdown user">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#"
                           title="用户">${sessionScope.user.username}</a>
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
                <p class="title">${sessionScope.user.username}</p>
                <strong>${sessionScope.identity}</strong>
            </div>
        </div>
        <section class="sidebar">
            <ul class="sidebar-menu" data-widget="tree">
                <%--主页--%>
                <li>
                    <a href="${path}pages/admin/index.jsp" title="主页">
                        <i class="iconfont icon-home"></i>
                        <small>主页</small>
                    </a>
                </li>
                <%--学生管理--%>
                <li class="treeview">
                    <a href="#" title="学生管理">
                        <i class="iconfont icon-login-user"></i>
                        <small>学生管理</small>
                        <span class=" pull-right">
								<i class="iconfont icon-menu-left-small"></i>
							</span>
                    </a>
                    <ul class="treeview-menu">
                        <li>
                            <a href="${path}admin/selectAllStu">
                                <i class="iconfont icon-circle-hollow"></i>
                                <small>查询所有学生信息</small>
                            </a>
                        </li>
                        <li>
                            <a href="#" data-target=".menu-selectStuById" data-toggle="modal">
                                <i class="iconfont icon-circle-hollow"></i>
                                <small>按学号查询学生信息</small>
                            </a>
                        </li>
                        <li>
                            <a href="${path}pages/admin/add_student.jsp">
                                <i class="iconfont icon-circle-hollow"></i>
                                <small>添加学生信息</small>
                            </a>
                        </li>
                        <li>
                            <a href="#" data-target=".menu-updateStuById" data-toggle="modal">
                                <i class="iconfont icon-circle-hollow"></i>
                                <small>修改学生信息</small>
                            </a>
                        </li>
                        <li>
                            <a href="#" data-target=".menu-deleteStuById" data-toggle="modal">
                                <i class="iconfont icon-circle-hollow"></i>
                                <small>删除学生信息</small>
                            </a>
                        </li>
                    </ul>
                </li>
                <%--成绩管理--%>
                <li class="treeview active">
                    <a href="#" title="成绩管理">
                        <i class="iconfont icon-form"></i>
                        <small>成绩管理</small>
                        <span class=" pull-right">
								<i class="iconfont icon-menu-left-small"></i>
							</span>
                    </a>
                    <ul class="treeview-menu">
                        <li class="active">
                            <a href="#" data-target=".menu-scoreById" data-toggle="modal">
                                <i class="iconfont icon-circle-hollow"></i>
                                <small>按学号管理成绩</small>
                            </a>
                        </li>
                        <li>
                            <a href="#" data-target=".menu-scoreByCno" data-toggle="modal">
                                <i class="iconfont icon-circle-hollow"></i>
                                <small>按课程号管理成绩</small>
                            </a>
                        </li>
                    </ul>
                </li>
                <%--教师管理--%>
                <li class="treeview">
                    <a href="#" title="教师管理">
                        <i class="iconfont icon-list"></i>
                        <small>教师管理</small>
                        <span class=" pull-right">
								<i class="iconfont icon-menu-left-small"></i>
							</span>
                    </a>
                    <ul class="treeview-menu">
                        <li>
                            <a href="${path}admin/selectAllTeachers">
                                <i class="iconfont icon-circle-hollow"></i>
                                <small>查询所有教师信息</small>
                            </a>
                        </li>
                        <li>
                            <a href="#" data-target=".menu-selectTeacherById" data-toggle="modal">
                                <i class="iconfont icon-circle-hollow"></i>
                                <small>按教师号查询教师信息</small>
                            </a>
                        </li>
                        <li>
                            <a href="${path}pages/admin/add_teacher.jsp">
                                <i class="iconfont icon-circle-hollow"></i>
                                <small>添加教师信息</small>
                            </a>
                        </li>
                        <li>
                            <a href="#" data-target=".menu-updateTeacherById" data-toggle="modal">
                                <i class="iconfont icon-circle-hollow"></i>
                                <small>修改教师信息</small>
                            </a>
                        </li>
                        <li>
                            <a href="#" data-target=".menu-deleteTeacherById" data-toggle="modal">
                                <i class="iconfont icon-circle-hollow"></i>
                                <small>删除教师信息</small>
                            </a>
                        </li>
                    </ul>
                </li>
                <c:if test="${sessionScope.user.uid == 1}">
                    <%--管理员管理--%>
                    <li class="treeview">
                        <a href="#" title="管理员管理">
                            <i class="iconfont icon-manager"></i>
                            <small>管理员管理</small>
                            <span class=" pull-right">
								<i class="iconfont icon-menu-left-small"></i>
							</span>
                        </a>
                        <ul class="treeview-menu">
                            <li>
                                <a href="${path}admin/selectAllUsers">
                                    <i class="iconfont icon-circle-hollow"></i>
                                    <small>查询所有管理员信息</small>
                                </a>
                            </li>
                            <li>
                                <a  href="#" data-target=".menu-selectUserById" data-toggle="modal">
                                    <i class="iconfont icon-circle-hollow"></i>
                                    <small>按编号查询管理员信息</small>
                                </a>
                            </li>
                            <li>
                                <a href="${path}pages/admin/add_user.jsp">
                                    <i class="iconfont icon-circle-hollow"></i>
                                    <small>添加管理员信息</small>
                                </a>
                            </li>
                            <li>
                                <a href="#" data-target=".menu-updateUserById" data-toggle="modal">
                                    <i class="iconfont icon-circle-hollow"></i>
                                    <small>修改管理员信息</small>
                                </a>
                            </li>
                            <li>
                                <a href="#" data-target=".menu-deleteUserById" data-toggle="modal">
                                    <i class="iconfont icon-circle-hollow"></i>
                                    <small>删除管理员信息</small>
                                </a>
                            </li>
                        </ul>
                    </li>
                </c:if>
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
                <small>管理员端</small>
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
        <div class="row widget">
            <section class="col-lg-12 widget-drag">
                <div class="box table">
                    <div class="box-header" data-trigger="drag">
                        <h3 class="box-title">
                            学生成绩信息
                        </h3>
                        <label class="label label-success">${requestScope.scoreMsg}</label>
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
                                    <th>学号</th>
                                    <th>姓名</th>
                                    <th>性别</th>
                                    <th>专业</th>
                                    <th>班级</th>
                                    <th>课程号</th>
                                    <th>课程名</th>
                                    <th>学分</th>
                                    <th>课程类别</th>
                                    <th>成绩</th>
                                    <th>状态</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${requestScope.scList}" var="scList">
                                    <form action="${path}admin/updateScore" method="post"
                                          onsubmit="return checkScore1()" name="form1">
                                        <tr>
                                            <td>${scList.student.sNo}</td>
                                            <td>${scList.student.sName}</td>
                                            <td>${scList.student.sSex}</td>
                                            <td>${scList.student.sDept}</td>
                                            <td>${scList.student.sClass}</td>
                                            <td>${scList.course.cNo}</td>
                                            <td>${scList.course.cName}</td>
                                            <td>${scList.course.credit}</td>
                                            <td>${scList.course.remarks}</td>
                                            <td>${scList.score}</td>
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
                                            <input type="hidden" name="sNo" value="${scList.student.sNo}">
                                            <input type="hidden" name="cNo" value="${scList.course.cNo}">
                                            <input type="hidden" name="source" value="sNo">
                                            <td><input type="number" name="newScore" value="${scList.score}">
                                                <button class="button btn-primary" type="submit">修改成绩</button>
                                            </td>
                                        </tr>
                                    </form>
                                </c:forEach>
                                <script type="text/javascript">
                                    function checkScore1() {
                                        var name = document.getElementsByName("newScore");
                                        for(var i=0;i<name.length;i++){
                                            if (name[i].value>100||name[i].value<0) {
                                                alert('成绩范围有误！（0-100）');
                                                return false;
                                            }
                                        }
                                        return true;
                                    }
                                </script>
                                </tbody>
                            </table>
                            <p class="text">共${fn:length(requestScope.scList)}条记录</p>
                        </div>
                    </div>
                </div>
            </section>
        </div>
        <%@include file="common.jsp" %>
        </section>
    </div>
</div>
</body>
</html>