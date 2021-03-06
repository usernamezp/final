﻿<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>持名法州主页</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/themes/IconExtension.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/themes/default/easyui.css">
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.easyui.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/easyui-lang-zh_CN1.3.5.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/datagrid-detailview.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.edatagrid.js"></script>
    <script type="text/javascript">
        <!--菜单处理-->
        $(function () {
            var first=$("#addtabs").val();
            $('#aa').accordion('add', {
                title: first.title,
               // content: c,
                iconCls: first.iconCls,
                selected: false
            });
        });
        function addTabs(title, url, iconCls) {
            // alert(url)//现在url什么都没有,需要去数据库添加
            // alert(title)
            var flag = $("#tt").tabs("exists", title);
            var iconCls1="icon-"+iconCls;
            if (flag){
                $("#tt").tabs("select", title);
            }else {
                $('#tt').tabs('add', {
                    title: title,
                    selected: true,
                    iconCls: iconCls1,
                    href: "${pageContext.request.contextPath}/banner/" + url,
                    closable:true
                })
            }
        };
    </script>

</head>
<body class="easyui-layout">
<div data-options="region:'north',split:true" style="height:60px;background-color:  #5C160C">
    <div style="font-size: 24px;color: #FAF7F7;font-family: 楷体;font-weight: 900;width: 500px;float:left;padding-left: 20px;padding-top: 10px">
        持名法州后台管理系统
    </div>
    <div style="font-size: 16px;color: #FAF7F7;font-family: 楷体;width: 300px;float:right;padding-top:15px">欢迎您:${sessionScope.admin}
        &nbsp;<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">修改密码</a>&nbsp;&nbsp;<a href="#"
                                                                                                              class="easyui-linkbutton"
                                                                                                              data-options="iconCls:'icon-01'">退出系统</a>
    </div>
</div>
<div data-options="region:'south',split:true" style="height: 40px;background: #5C160C">
    <div style="text-align: center;font-size:15px; color: #FAF7F7;font-family: 楷体">&copy;百知教育 htf@zparkhr.com.cn</div>
</div>

<div data-options="region:'west',title:'导航菜单',split:true" style="width:220px;">
    <div id="aa" class="easyui-accordion" data-options="fit:true">
        <c:forEach items="${requestScope.list}" var="menu">
            <div title="${menu.title}" data-options="iconCls:'icon-${menu.iconCls}',selected:true"
                 style="padding:10px;">
                <c:forEach items="${menu.menulist}" var="mm">
                        <img src="${pageContext.request.contextPath }/themes/icons/${mm.iconCls}.png" alt="">
                    <a id="addtabs" data-options="iconCls:'icon-${mm.iconCls}',plain:true" onclick="addTabs('${mm.title}','${mm.url}','${mm.iconCls}')">
                    ${mm.title}
                    </a>
                </c:forEach>
            </div>
        </c:forEach>
    </div>
</div>
<div data-options="region:'center'">
    <div id="tt" class="easyui-tabs" data-options="fit:true,narrow:true,pill:true">
        <div title="主页" data-options="iconCls:'icon-neighbourhood',"
             style="background-image:url(../main/image/shouye.jpg);background-repeat: no-repeat;background-size:100% 100%;"></div>
    </div>
</div>
</body>
</html>