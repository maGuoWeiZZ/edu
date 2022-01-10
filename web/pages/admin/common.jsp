<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<!-- 修改密码模态框 -->
<div class="modal fade menu-setpassword" tabindex="-1" role="dialog">
    <form name="formPwd" action="${path}admin/modifyPwd?uid=${sessionScope.user.uid}"
          onsubmit="return check()"
          method="post">
        <div class="modal-dialog modal-sm" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                    <h4 class="modal-title">修改密码</h4>
                </div>
                <div class="modal-body">
                    <table class="table">
                        <tbody>
                        <tr>
                            <%--确认密码提示信息--%>
                            <td id="pwd_msg" colspan="2" class="label label-danger"></td>
                        </tr>
                        <tr>
                            <th>
                                新密码
                            </th>
                            <td>
                                <input type="password" class="form-control" placeholder="请输入新密码"
                                       name="newPassword">
                            </td>
                        </tr>
                        <tr>
                            <th>
                                确认密码
                            </th>
                            <td>
                                <input type="password" class="form-control" placeholder="请再次输入新密码"
                                       name="verifyPassword">
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="submit" class="btn btn-primary">保存</button>
                </div>
            </div>
        </div>
    </form>
</div>
<%--密码验证--%>
<script type="text/javascript">
    function check() {
        var td = document.getElementById("pwd_msg");
        if (formPwd.newPassword.value == '' || formPwd.verifyPassword.value == '') {
            td.innerText = "密码不能为空";
            return false;
        } else if (formPwd.newPassword.value != formPwd.verifyPassword.value) {
            td.innerText = "两次输入密码不一致";
            return false;
        } else {
            td.innerText = "";
            return true;
        }
    }
</script>
<%--按学号查询学生信息模态框--%>
<div class="modal fade menu-selectStuById" tabindex="-1" role="dialog">
    <div class="modal-dialog modal-sm" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title">请输入学号</h4>
            </div>
            <form action="${path}admin/selectStuBySno"
                  method="post">
                <div class="modal-body">
                    <table class="table">
                        <tbody>
                        <tr>
                            <th>
                                学号
                            </th>
                            <td>
                                <input type="number" class="form-control" placeholder="请输入学号"
                                       name="sNo">
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="submit" class="btn btn-primary">查询</button>
                </div>
            </form>
        </div>
    </div>
</div>
<%--按学号修改学生信息模态框--%>
<div class="modal fade menu-updateStuById" tabindex="-1" role="dialog">
    <div class="modal-dialog modal-sm" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title">请输入学号</h4>
            </div>
            <form action="${path}admin/updateStuForm"
                  method="post">
                <div class="modal-body">
                    <table class="table">
                        <tbody>
                        <tr>
                            <th>
                                学号
                            </th>
                            <td>
                                <input type="number" class="form-control" placeholder="请输入学号"
                                       name="sNo">
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="submit" class="btn btn-primary">确定</button>
                </div>
            </form>
        </div>
    </div>
</div>
<%--按学号删除学生信息模态框--%>
<div class="modal fade menu-deleteStuById" tabindex="-1" role="dialog">
    <div class="modal-dialog modal-sm" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title">请输入学号</h4>
            </div>
            <form action="${path}admin/deleteStu"
                  method="post" onsubmit="return confirm('是否删除该学生？')">
                <div class="modal-body">
                    <table class="table">
                        <tbody>
                        <tr>
                            <th>
                                学号
                            </th>
                            <td>
                                <input type="number" class="form-control" placeholder="请输入学号"
                                       name="sNo">
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="submit" class="btn btn-primary">确定</button>
                </div>
            </form>
        </div>
    </div>
</div>
<%--按学号查询成绩模态框--%>
<div class="modal fade menu-scoreById" tabindex="-1" role="dialog">
    <div class="modal-dialog modal-sm" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title">请输入学号</h4>
            </div>
            <form action="${path}admin/selectSCBySno"
                  method="post">
                <div class="modal-body">
                    <table class="table">
                        <tbody>
                        <tr>
                            <th>
                                学号
                            </th>
                            <td>
                                <input type="number" class="form-control" placeholder="请输入学号"
                                       name="sNo">
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="submit" class="btn btn-primary">确定</button>
                </div>
            </form>
        </div>
    </div>
</div>
<%--按课程号查询成绩模态框--%>
<div class="modal fade menu-scoreByCno" tabindex="-1" role="dialog">
    <div class="modal-dialog modal-sm" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title">请输入课程号</h4>
            </div>
            <form action="${path}admin/selectSCByCno"
                  method="post">
                <div class="modal-body">
                    <table class="table">
                        <tbody>
                        <tr>
                            <th>
                                课程号
                            </th>
                            <td>
                                <input type="number" class="form-control" placeholder="请输入学号"
                                       name="cNo">
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="submit" class="btn btn-primary">确定</button>
                </div>
            </form>
        </div>
    </div>
</div>
<%--按教师编号查询教师信息模态框--%>
<div class="modal fade menu-selectTeacherById" tabindex="-1" role="dialog">
    <div class="modal-dialog modal-sm" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title">请输入教师编号</h4>
            </div>
            <form action="${path}admin/selectTeacherById"
                  method="post">
                <div class="modal-body">
                    <table class="table">
                        <tbody>
                        <tr>
                            <th>
                                教师编号
                            </th>
                            <td>
                                <input type="number" class="form-control" placeholder="请输入教师编号"
                                       name="tNo">
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="submit" class="btn btn-primary">确定</button>
                </div>
            </form>
        </div>
    </div>
</div>
<%--按教师编号修改教师信息模态框--%>
<div class="modal fade menu-updateTeacherById" tabindex="-1" role="dialog">
    <div class="modal-dialog modal-sm" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title">请输入教师编号</h4>
            </div>
            <form action="${path}admin/updateTeacherForm"
                  method="post">
                <div class="modal-body">
                    <table class="table">
                        <tbody>
                        <tr>
                            <th>
                                教师编号
                            </th>
                            <td>
                                <input type="number" class="form-control" placeholder="请输入教师编号"
                                       name="tNo">
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="submit" class="btn btn-primary">确定</button>
                </div>
            </form>
        </div>
    </div>
</div>
<%--按教师编号删除教师信息模态框--%>
<div class="modal fade menu-deleteTeacherById" tabindex="-1" role="dialog">
    <div class="modal-dialog modal-sm" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title">请输入教师编号</h4>
            </div>
            <form action="${path}admin/deleteTeacher"
                  method="post" onsubmit="return confirm('是否删除该教师？')">
                <div class="modal-body">
                    <table class="table">
                        <tbody>
                        <tr>
                            <th>
                                教师编号
                            </th>
                            <td>
                                <input type="number" class="form-control" placeholder="请输入教师编号"
                                       name="tNo">
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="submit" class="btn btn-primary">确定</button>
                </div>
            </form>
        </div>
    </div>
</div>
<%--按管理员编号查询管理员信息模态框--%>
<div class="modal fade menu-selectUserById" tabindex="-1" role="dialog">
    <div class="modal-dialog modal-sm" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title">请输入管理员编号</h4>
            </div>
            <form action="${path}admin/selectUserById"
                  method="post">
                <div class="modal-body">
                    <table class="table">
                        <tbody>
                        <tr>
                            <th>
                                管理员编号
                            </th>
                            <td>
                                <input type="number" class="form-control" placeholder="请输入管理员编号"
                                       name="uid">
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="submit" class="btn btn-primary">确定</button>
                </div>
            </form>
        </div>
    </div>
</div>
<%--按管理员编号修改管理员信息模态框--%>
<div class="modal fade menu-updateUserById" tabindex="-1" role="dialog">
    <div class="modal-dialog modal-sm" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title">请输入管理员编号</h4>
            </div>
            <form action="${path}admin/updateUserForm"
                  method="post">
                <div class="modal-body">
                    <table class="table">
                        <tbody>
                        <tr>
                            <th>
                                管理员编号
                            </th>
                            <td>
                                <input type="number" class="form-control" placeholder="请输入管理员编号"
                                       name="uid">
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="submit" class="btn btn-primary">确定</button>
                </div>
            </form>
        </div>
    </div>
</div>
<%--按管理员编号删除管理员信息模态框--%>
<div class="modal fade menu-deleteUserById" tabindex="-1" role="dialog">
    <div class="modal-dialog modal-sm" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title">请输入管理员编号</h4>
            </div>
            <form action="${path}admin/deleteUser"
                  method="post" onsubmit="return confirm('是否删除该管理员？')">
                <div class="modal-body">
                    <table class="table">
                        <tbody>
                        <tr>
                            <th>
                                管理员编号
                            </th>
                            <td>
                                <input type="number" class="form-control" placeholder="请输入管理员编号"
                                       name="uid">
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="submit" class="btn btn-primary">确定</button>
                </div>
            </form>
        </div>
    </div>
</div>
<!-- 退出提示模态框 -->
<div class="modal fade menu-logout" tabindex="-1" role="dialog">
    <div class="modal-dialog modal-sm" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title">提示</h4>
            </div>
            <div class="modal-body">
                <p>是否确定退出</p>
            </div>
            <div class="modal-footer">
                <form action="${path}logout" method="post">
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    <button type="submit" class="btn btn-primary">登出</button>
                </form>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="${path}assets/js/jquery-2.1.0.min.js"></script>
<script type="text/javascript" src="${path}assets/js/jquery-ui.min.js"></script>
<script type="text/javascript" src="${path}assets/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${path}assets/libs/tinymce/tinymce.min.js"></script>
<script type="text/javascript" src="${path}assets/js/Chart.min.js"></script>
<script type="text/javascript" src="${path}assets/js/echarts.min.js"></script>
<script type="text/javascript" src="${path}assets/js/alpha.js"></script>
<script type="text/javascript" src="${path}assets/js/dashboard.js"></script>
</body>
</html>
