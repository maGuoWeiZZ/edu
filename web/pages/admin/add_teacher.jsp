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
                <li class="treeview active">
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
                        <li class="active">
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
        <section class="page-body">
            <div class="row widget">
                <section class="col-md-12 col-sm-12 col-xs-12">
                    <div class="box form">
                        <div class="box-header">
                            <h3 class="box-title">添加教师信息</h3>
                        </div>
                        <div class="box-body">
                            <form name="form1" action="${path}admin/addTeacher"
                                  onsubmit="return checkTeacher()" method="post">
                                <div class="form-group">
                                    <label id="msg" class="label label-danger"></label>
                                </div>
                                <input type="hidden" name="tPassword" value="123456">
                                <div class="form-group">
                                    <label>姓名</label>
                                    <input type="text" class="form-control" name="tName"
                                           placeholder="请输入姓名">
                                </div>
                                <div class="form-group">
                                    <label>性别</label>
                                    <div class="radio">
                                        <label>
                                            <input type="radio" name="tSex" value="男">男
                                        </label>
                                        <label>
                                            <input type="radio" name="tSex" value="女">女
                                        </label>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label>年龄</label>
                                    <input type="number" class="form-control" name="tAge" id="tAge"
                                           placeholder="请输入年龄">
                                </div>
                                <div class="form-group">
                                    <label>薪资</label>
                                    <input type="number" class="form-control" name="tSalary"
                                           placeholder="请输入薪资">
                                </div>
                                <div class="form-group">
                                    <label>专业</label>
                                    <select name="tDept" class="form-control">
                                        <option value="">--请选择专业--</option>
                                        <option value="计算机科学与技术">计算机科学与技术</option>
                                        <option value="大数据">大数据</option>
                                        <option value="软件工程">软件工程</option>
                                        <option value="电子信息">电子信息</option>
                                        <option value="人工智能">人工智能</option>
                                        <option value="电子商务">电子商务</option>
                                    </select>
                                </div>
                                <button type="submit" class="btn btn-primary">添加</button>
                            </form>
                        </div>
                    </div>
                </section>
            </div>
            <%--添加教师信息表单输入验证--%>
            <script type="text/javascript">
                function checkTeacher() {
                    var reg = /^[a-zA-Z\u4e00-\u9fa5]+$/;
                    var msg = document.getElementById("msg");
                    if (form1.tName.value == '' || form1.tName.value == null) {
                        msg.innerText = "姓名不能为空！";
                        return false;
                    } else if(!(reg.test(form1.tName.value))) {
                        msg.innerText = "姓名格式不正确！";
                        return false;
                    } else if (form1.tSex.value == '' || form1.tSex.value == null) {
                        msg.innerText = "请选择性别！";
                        return false;
                    } else if (form1.tAge.value == '' || form1.tAge.value == null) {
                        msg.innerText = "年龄不能为空！";
                        return false;
                    } else if (!(form1.tAge.value > 18 && form1.tAge.value < 65)) {
                        msg.innerText = "年龄范围有误(18-65)！";
                        return false;
                    } else if (form1.tDept.value == '' || form1.tDept.value == null) {
                        msg.innerText = "请选择专业！";
                        return false;
                    } else if (form1.tSalary.value == '' || form1.tSalary.value == null) {
                        msg.innerText = "薪资不能为空！";
                        return false;
                    } else if (form1.tSalary.value < 3000 || form1.tSalary.value > 100000) {
                        msg.innerText = "薪资范围有误(3000-100000)！";
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