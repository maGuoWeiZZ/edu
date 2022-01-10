<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    request.setAttribute("path", basePath);
%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>教务管理系统登录</title>
    <link rel="stylesheet" type="text/css" href="${path}assets/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${path}assets/libs/icheck/skins/all.css">
    <link rel="stylesheet" type="text/css" href="${path}assets/css/iconfont.css">
    <link rel="stylesheet" type="text/css" href="${path}assets/css/style.css">
</head>

<body class="login-page">
<div class="login-wrapper">
    <div class="header skew">
    </div>
    <div class="login-logo">
        <a href="../../index.jsp">
            <strong>教务管理系统</strong>
        </a>
    </div>
    <div class="login-body">
        <p class="text-primary text-center">欢迎使用教务管理系统</p>
        <p class="label label-danger">${empty requestScope.msg?"":requestScope.msg}</p>
        <form action="${path}login" method="post">
            <div class="form">
                <div class="form-group">
                    <div class="input-group">
                    	<span class="input-group-addon">
                    		<i class="iconfont icon-login-user"></i>
                    	</span>
                        <input type="username" name="username" id="username" class="form-control" placeholder="输入用户名/学号/教职工号">
                    </div>
                </div>
                <div class="form-group">
                    <div class="input-group">
                		<span class="input-group-addon">
                			<i class="iconfont icon-lock"></i>
                		</span>
                        <input type="password" name="password" id="password" class="form-control" placeholder="输入密码">
                    </div>
                </div>
                <div class="form-group">
                    <div class="row">
                        <div class="col-xs-7">
	                		<span>
	                			<input type="checkbox" class="minimal">
		                        	记住密码
		                     </span>
                        </div>
                    </div>
                </div>
                <div class="form-group text-center">
                    <div class="radio">
                        <label>
                            <input type="radio" name="job" value="student"
                                   checked> 学生
                        </label>
                        <label>
                            <input type="radio" name="job" value="teacher"> 教师
                        </label>
                        <label>
                            <input type="radio" name="job" value="admin"> 管理员
                        </label>
                    </div>
                </div>
                <div class="form-group">
                    <label>
                        <button id="login" type="submit" class="btn btn-primary">登录</button>
                    </label>
                </div>
            </div>
        </form>
    </div>

    <script type="text/javascript" src="${path}assets/js/jquery-2.1.0.min.js"></script>
    <script type="text/javascript" src="${path}assets/js/jquery-ui.min.js"></script>
    <script type="text/javascript" src="${path}assets/js/bootstrap.min.js"></script>
    <!-- icheck.js -->
    <script type="text/javascript" src="${path}assets/libs/icheck/icheck.min.js"></script>
</div>
</body>

</html>