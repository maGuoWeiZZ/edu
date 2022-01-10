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
                <li class="treeview">
                    <a href="#" title="成绩管理">
                        <i class="iconfont icon-form"></i>
                        <small>成绩管理</small>
                        <span class=" pull-right">
								<i class="iconfont icon-menu-left-small"></i>
							</span>
                    </a>
                    <ul class="treeview-menu">
                        <li>
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
                    <li class="treeview active">
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
                                <a href="#" data-target=".menu-selectUserById" data-toggle="modal">
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
                            <li class="active">
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
        <section class="page-body">
            <div class="row widget">
                <section class="col-md-12 col-sm-12 col-xs-12">
                    <div class="box form">
                        <div class="box-header">
                            <h3 class="box-title">修改管理员信息</h3>
                        </div>
                        <div class="box-body">
                            <c:if test="${not empty requestScope.user}">
                                <form name="form1" action="${path}admin/updateUser"
                                      onsubmit="return checkUser()" method="post">
                                    <div class="form-group">
                                        <label id="msg" class="label label-danger"></label>
                                    </div>
                                    <div class="form-group">
                                        <label>管理员编号</label>
                                        <input type="text" class="form-control"
                                               value="${user.uid}" disabled>
                                    </div>
                                    <input type="hidden" name="uid" id="uid" value="${user.uid}">
                                    <div class="form-group">
                                        <label>用户名</label>
                                        <input type="text" class="form-control" name="username" id="username"
                                               placeholder="请输入用户名" value="${user.username}" onblur="checkName()">
                                    </div>
                                    <div class="form-group">
                                        <label>密码</label>
                                        <input type="password" class="form-control" name="password"
                                               placeholder="请输入密码" value="${user.password}">
                                    </div>
                                    <div class="form-group">
                                        <label>确认密码</label>
                                        <input type="password" class="form-control" name="rePassword"
                                               placeholder="请输入确认密码" value="${user.password}">
                                    </div>
                                    <div class="form-group">
                                        <label>真实姓名</label>
                                        <input type="text" class="form-control" name="detail.realName"
                                               placeholder="请输入真实姓名" id="realName" value="${user.detail.realName}">
                                    </div>
                                    <div class="form-group">
                                        <label>电子邮箱</label>
                                        <input type="email" class="form-control" name="detail.email"
                                               placeholder="请输入电子邮箱" id="email" value="${user.detail.email}">
                                    </div>
                                    <div class="form-group">
                                        <label>电话号码</label>
                                        <input type="text" class="form-control" name="detail.phone"
                                               placeholder="请输入电话号码" id="phone" value="${user.detail.phone}">
                                    </div>
                                    <button type="submit" class="btn btn-primary">修改</button>
                                </form>
                            </c:if>
                            <c:if test="${empty requestScope.user}">
                                <label class="label label-danger">不存在该管理员</label>
                            </c:if>
                        </div>
                    </div>
                </section>
            </div>
            <%--添加管理员信息表单输入验证--%>
            <script type="text/javascript">

                function checkName() {
                    $.ajax({
                        url: '${path}admin/checkUsername',
                        type: 'POST',
                        data: {
                            username: $('#username').val()
                        },
                        success: function (data) {
                            if (data == true) {
                                if ($('#username').val() != '') {
                                    $('#nameMsg').removeClass('label-danger');
                                    $('#nameMsg').addClass('label-success');
                                    $('#nameMsg').html('用户名可用');
                                    $('#add').attr('disabled',false);
                                }
                            } else {
                                $('#nameMsg').removeClass('label-success');
                                $('#nameMsg').addClass('label-danger');
                                $('#nameMsg').html('用户名已被占用');
                                $('#add').attr('disabled',true);
                            }
                        }
                    });
                }

                function checkUser() {
                    //电子邮箱正则验证
                    var regEmail = /^[A-Za-zd0-9]+([-_.][A-Za-zd]+)*@([A-Za-z0-9]+[-.])+[A-Za-zd]{2,5}$/;
                    //手机号码正则验证
                    var regPhone = /^(13[0-9]|14[01456879]|15[0-35-9]|16[2567]|17[0-8]|18[0-9]|19[0-35-9])\d{8}$/;
                    //真是姓名验证
                    var regRealName = /^[a-zA-Z\u4e00-\u9fa5]+$/;
                    var msg = document.getElementById("msg");
                    var realName = document.getElementById("realName");
                    var email = document.getElementById("email");
                    var phone = document.getElementById("phone");

                    if (form1.username.value == '' || form1.username.value == null) {
                        msg.innerText = "用户名不能为空！";
                        return false;
                    } else if (form1.password.value == '' || form1.password.value == null) {
                        msg.innerText = "密码不能为空！";
                        return false;
                    } else if (form1.rePassword.value != form1.password.value) {
                        msg.innerText = "两次输入密码不一致！";
                        return false;
                    } else if (realName.value == '' || realName.value == null) {
                        msg.innerText = "真实姓名不能为空！";
                        return false;
                    } else if (!(regRealName.test(realName.value))) {
                        msg.innerText = "真实姓名格式不正确！";
                        return false;
                    } else if (email.value == '' || email.value == null) {
                        msg.innerText = "电子邮箱不能为空！";
                        return false;
                    } else if (!(regEmail.test(email.value))) {
                        msg.innerText = "电子邮箱格式不正确！";
                        return false;
                    } else if (phone.value == '' || phone.value == null) {
                        msg.innerText = "电话号码不能为空！";
                        return false;
                    } else if (!(regPhone.test(phone.value))) {
                        msg.innerText = "电话号码格式不正确！";
                        return false;
                    } else {
                        msg.innerText = '';
                        return true;
                    }
                }
            </script>
            <%@include file="common.jsp" %>
        </section>
    </div>
</div>
</body>
</html>