<%@page contentType="text/html;UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
    $(function () {
        // alert("11111111111111")
        //添加弹出框
        $("#ljtj3").linkbutton({
            iconCls:"icon-add"
        });
        $('#tianjia').dialog({
            title: '添加',
            width: 400,
            height: 200,
            closed: true
        });
        $('#dg').edatagrid({
            url: '${pageContext.request.contextPath}/banner/getAllBanner',
            columns: [[
                {field: 'name', title: '标题', width: 100},
                {
                    field: 'status', title: '状态', width: 100, editor: {
                        type: "text",
                        options: {
                            required: true
                        }
                    }
                },
                {field: 'description', title: '描述', width: 100, align: 'right'},
                {field: 'createDate', title: '时间', width: 100},
            ]],
            fit: true,
            fitColumns: true,
            pagination: true,
            pageSize: 5,
            pageList: [2, 3, 4, 5, 8, 10, 15],
            toolbar: [{
                iconCls: 'icon-add',
                text: "添加",
                handler: function () {
                    // alert('添加按钮')
                    // $("#dg").edatagrid("addRow");
                    $("#tianjia").dialog("open");
                }
            }, '-', {
                iconCls: 'icon-edit',
                text: "修改",
                handler: function () {
                    var row = $("#dg").edatagrid("getSelected");
                    if (row == null) {
                        alert("请先选中行")
                    } else {
                        var index = $("#dg").edatagrid("getRowIndex", row);
                        $("#dg").edatagrid("editRow", index);
                    }
                }
            }, '-', {
                iconCls: 'icon-remove',
                text: "删除",
                handler: function () {
                    var row = $("#dg").edatagrid("getSelected");
                    if (row == null) {
                        alert("请先选中行")
                    } else {
                        $.messager.confirm("确认对话框", "您确定要删除么？", function (r) {
                            if (r) {
                                $.ajax({
                                    url: "${pageContext.request.contextPath}/banner/delete",
                                    type: "post",
                                    dataType: "json",
                                    data: {id: row.id},
                                    success: function (data) {
                                        if (data) {
                                            $("#dg").datagrid("reload");
                                        } else {
                                            alert("删除失败")
                                        }

                                    }
                                });
                            }
                        })
                        // var row = $("#dg").edatagrid("getSelected");

                    }

                    /* // alert('删除按钮')
                     var row = $("#dg").edatagrid("getSelected");
                     if (row == null) {
                         alert("请先选中行")
                     } else {
                         var index = $("#dg").edatagrid("getRowIndex", row);
                         $("#dg").edatagrid("destroyRow", index);
                         // $("#dg").datagrid("deleteRow");
                     }*/
                    <%--$.ajax({  url : "${pageContext.request.contextPath}/banner/banner.jsp"})--%>
                    // $("#dg").reload(true)
                    // $("#dg").datagrid("reload");
                },

            }, '-', {
                iconCls: 'icon-save',
                text: "保存",
                handler: function () {
                    // alert("aaaaaaaaaaaaaaa")
                    $("#dg").edatagrid("saveRow");
                    $("#dg").datagrid("reload");
                    <%--$.ajax({  url : "${pageContext.request.contextPath}/banner/banner.jsp"})--%>
                }
            }],
            view: detailview,
            detailFormatter: function (rowIndex, rowData) {
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/banner/' + rowData.url + '" style="height:50px;"></td>' +
                    '<td style="border:0">' +
                    '<p>描述: ' + rowData.description + '</p>' +
                    '<p>上传时间: ' + rowData.createDate + '</p>' +
                    '<p style="display:none"> ' + rowData.id + '</p>' +
                    '</td>' +
                    '</tr></table>';
            },
            updateUrl: "${pageContext.request.contextPath}/banner/update",
            <%--destroyUrl:"${pageContext.request.contextPath}/banner/delete",--%>
        });
        // alert("2222222")
    })

    //添加
    function insert() {
        $('#formtianjia').form('submit', {
            url: "${pageContext.request.contextPath}/banner/insert",
            dataType: "json",
            success: function (data) {
                // alert(data+"2222222222222222222")
                if (data) {
                    $("#tianjia").dialog("close");
                    $("#dg").datagrid("reload");
                    alert("添加成功");
                } else {
                    alert("添加失败");
                }
                //刷新datagrid
            }
        });
    }
</script>

<table id="dg"></table>

<!-- 添加 -->
<div id="tianjia">
    <form method="post" id="formtianjia" enctype="multipart/form-data">
        图片名字：<input name="name"/><br>
        描述：<input name="description"/><br>
        图片url：<input name="file" type="file"/><br>
        <a id="ljtj3" onclick="insert()">立即添加</a>
    </form>
</div>

<%--
//轮播图删除
function banner_Remove() {
    var row = $("#dg").edatagrid("getSelected");
    $.ajax({
        url:"${pageContext.request.contextPath}/banner/delete",
        type:"post",
        dataType:"json",
        data:{id:row.id},
        success:function (data) {
            $("#dg").datagrid("reload");
        }
    });
}
--%>