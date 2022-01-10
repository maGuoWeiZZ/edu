<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    request.setAttribute("path", basePath);
%>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="${path}assets/js/jquery-2.1.0.min.js"></script>
    <script type="text/javascript" src="${path}assets/js/jquery-ui.min.js"></script>
    <script type="text/javascript" src="${path}assets/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${path}assets/libs/tinymce/tinymce.min.js"></script>
    <script type="text/javascript" src="${path}assets/js/Chart.min.js"></script>
    <script type="text/javascript" src="${path}assets/js/echarts.min.js"></script>
    <script type="text/javascript" src="${path}assets/js/alpha.js"></script>
    <script type="text/javascript" src="${path}assets/js/dashboard.js"></script>
    <script type="text/javascript">
        function testt() {
            <%--$.ajax({--%>
                <%--url: '${path}admin/tt',--%>
                <%--type: 'POST',--%>
                <%--data:{--%>
                    <%--uid:1--%>
                <%--},--%>
                <%--dataType: "json",--%>
                <%--success: function (value) {--%>
                    <%--console.log(value);--%>
                    <%--console.log(value.uid);--%>
                    <%--console.log(value.username);--%>
                    <%--console.log(value.password);--%>
                    <%--console.log(value.detail.realName);--%>
                    <%--console.log(value.detail.email);--%>
                    <%--console.log(value.detail.phone);--%>
                <%--}--%>
            <%--});--%>
            <%--$.ajax({--%>
                <%--url:'${path}admin/ss',--%>
                <%--type:'POST',--%>
                <%--data:{--%>
                    <%--sNo:1--%>
                <%--},--%>
                <%--dataType:'json',--%>
                <%--success: function (data) {--%>
                    <%--console.log(data);--%>
                <%--}--%>
            <%--});--%>

            $.ajax({
                url:'${path}admin/cc',
                type:'POST',
                data:{
                    sNo:1
                },
                contentType:'application/x-www-form-urlencoded',
                dataType:'json',
                success: function (data) {
                    console.log(data);
                }
            });
        }
    </script>
</head>
<body>
<button onclick="testt()">ajax</button>
</body>
</html>
