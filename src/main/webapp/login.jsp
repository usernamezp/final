<%@page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>持名法州后台管理中心</title>

    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">

    <link rel="icon" href="img/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="css/common.css" type="text/css"></link>
    <link rel="stylesheet" href="css/login.css" type="text/css"></link>
    <script type="text/javascript" src="script/jquery.js"></script>
    <script type="text/javascript" src="script/common.js"></script>

    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.easyui.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/easyui-lang-zh_CN1.3.5.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/themes/default/easyui.css">
    <script type="text/javascript">

        $(function () {
            //点击更换验证码：
            $("#captchaImage").click(function () {//点击更换验证码
                // alert("自己做");
                var time = new Date();
                $("#captchaImage").prop("src", "${pageContext.request.contextPath }/defaultKaptcha?d=" + time.getTime());
            });

            //用户名验证
            $("#username").blur(function () {
                // alert("11111111111");
                var name = $("#username").val();
                // alert(name)
                if (name == "") {
                    $("#checkname").html("用户名不能为空");
                } else {
                    $("#checkname").html("");
                }
            });
        });

        function formlogin() {
            //  form 表单提交
            $("#loginForm").form("submit", {
                url: "http://localhost:9292/cmfz/admin/login",
                success: function (data) {
                    // alert(data)
                    if (data == true + "") {
                        window.location.href = "http://localhost:9292/cmfz/menu/getAllMenu";
                    } else {
                        $.messager.alert("提示", "用户名或密码错误，请重新输入!", "info");
                    }
                }
                // alert("自己做");
                //return false;
            });

            // $("#enCode")
        }

    </script>
</head>
<body>

<div class="login">
    <form id="loginForm" method="post">

        <table>
            <tbody>
            <tr>
                <td width="190" rowspan="2" align="center" valign="bottom">
                    <img src="img/header_logo.gif"/>
                </td>
                <th>
                    用户名:
                </th>
                <td>
                    <input type="text" name="name" class="text" maxlength="20" id="username" value=""/>
                    <span style="font-size: 20px" id="checkname"></span>
                </td>
            </tr>
            <tr>
                <th>
                    密&nbsp;&nbsp;&nbsp;码:
                </th>
                <td>
                    <input type="password" name="password" class="text" maxlength="20" autocomplete="off" value=""/>
                </td>
            </tr>

            <tr>
                <td>&nbsp;</td>
                <th>验证码:</th>
                <td>
                    <input type="text" id="enCode" name="code" class="text captcha" maxlength="4" autocomplete="off"/>
                    <img id="captchaImage" class="captchaImage" src="${pageContext.request.contextPath }/defaultKaptcha"
                         title="点击更换验证码"/>
                </td>
            </tr>
            <tr>
                <td>
                    &nbsp;
                </td>
                <th>
                    &nbsp;
                </th>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <th>&nbsp;</th>
                <td>
                    <input type="button" class="homeButton" value="" onclick="location.href='/'"><input type="button"
                                                                                                        class="loginButton"
                                                                                                        value="登录"
                                                                                                        onclick="formlogin()">
                </td>
            </tr>
            </tbody>
        </table>
        <div class="powered">COPYRIGHT © 2008-2017.</div>
        <div class="link">
            <a href="http://www.chimingfowang.com/">持名佛网首页</a> |
            <a href="http://www.chimingbbs.com/">交流论坛</a> |
            <a href="">关于我们</a> |
            <a href="">联系我们</a> |
            <a href="">授权查询</a>
        </div>
    </form>
</div>
</body>
</html>