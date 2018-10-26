<%@page contentType="text/html;UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
    //添加专辑
    function insert() {
        $('#formtianjia1').form('submit', {
            url: "${pageContext.request.contextPath}/album/insert",
            dataType: "json",
            success: function (data) {
                if (data == "true") {
                    // alert(date)
                    $("#tianjia").dialog("close");
                    $("#albumtt").treegrid("reload");
                    alert("添加成功");
                } else {
                    alert("添加失败");
                }
            }
        });
    }
    /*添加章节*/
    function insertadd() {
        $('#form12').form('submit', {
            url: "${pageContext.request.contextPath}/chapter/insert",
            dataType: "json",
            success: function (data) {
                if (data == "true") {
                    // alert(date)
                    $("#addChapter").dialog("close");
                    $("#albumtt").treegrid("reload");
                    alert("添加成功");
                } else {
                    alert("添加失败");
                }
            }
        });
    }
    $(function () {
        $("#ljtj").linkbutton({
            iconCls:"icon-add"
        });
        $("#ljtj2").linkbutton({
            iconCls:"icon-add"
        });
        $('#tianjia1').dialog({
            title: '添加专辑',
            width: 400,
            height: 200,
            closed: true
        });
        $('#addChapter').dialog({
            title: '添加章节',
            width: 400,
            height: 200,
            closed: true
        });
        $('#selectOne').dialog({
            title: '专辑详情',
            width: 400,
            height: 280,
            closed: true,
            cache:false,
            modal:true
        });
        $('#albumtt').treegrid({
            url: '${pageContext.request.contextPath }/album/getAll',
            idField: 'id',
            treeField: 'name',
            columns: [[
                {title: '名字', field: 'name', width: 180},
                {field: 'url', title: '下载路径', width: 60, align: 'right'},
                {field: 'size', title: '大小', width: 80},
                {field: 'duration', title: '时间', width: 80}
            ]],
            pagination: true,
            method: "get",
            fit: true,
            fitColumns: true,
            toolbar: [{
                text: "专辑详情",
                iconCls: 'icon-tip',
                handler: function () {
                    // alert('专辑详情')
                    var obj = $('#albumtt').treegrid("getSelected");
                    if (obj == null) {
                        alert('请先选择要查看哪个专辑！');
                    } else {
                        if (obj.id != 0) {
                            $.ajax({
                                url: "${pageContext.request.contextPath}/album/selectOne",
                                type: "get",
                                dataType: "json",
                                data: {id: obj.id},
                                success: function (data) {
                                    var j="<p>专辑名："+data.name+"</p><p>专辑封面:<img style='height: 20px;width: 40px' src='${pageContext.request.contextPath}/banner/"+data.coverlmg+"'></img></p><p>数量："+data.count+"</p><p>评分："+data.score+"</p><p>作者："+data.author+"</p><p>播音："+data.broadCast+"</p><p>介绍："+data.brief+"</p><p>发布日期："+data.pubishDate+"</p>"
                                    $('#selectOne').html(j);
                                    $('#selectOne').dialog("open");
                                }
                            });
                        } else {
                            alert('您选择的不是专辑！');
                        }
                    }
                }
            }, '-', {
                text: "添加专辑",
                iconCls: 'icon-save',
                handler: function () {
                    $("#tianjia1").dialog("open");
                }
            }, '-', {
                text: "添加章节",
                iconCls: 'icon-save',
                handler: function () {
                    var obj = $('#albumtt').treegrid("getSelected");
                    if (obj == null) {
                        alert('请选择要添加到哪个专辑！');
                    } else {
                        // var oid=$("#tt").treegrid("getParent")
                        // alert(oid.id)
                        if (obj.id!= 0) {
                            // alert(obj.id);
                            var id = obj.id;
                            $("#aid").prop("value", id);
                            $('#addChapter').dialog("open");
                            // $.ajax()
                        } else {
                            alert('您选择的不是专辑！');
                        }
                    }
                }
            }, '-', {
                text: "下载音频",
                iconCls: 'icon-undo',
                handler: function () {
                    // alert('下载音频')
                    var obj = $('#albumtt').treegrid("getSelected");
                    window.location.href="${pageContext.request.contextPath}/chapter/xiazai?url="+obj.url;
                }
            }]
        });
        //双击事件
        $("#albumtt").treegrid({
            onDblClickRow:function(row){
                //自动执行这个函数
                music1(row)
            }
        })
        //播放音频弹出框
        $('#music').dialog({
            title: '播放歌曲',
            width: 370,
            height: 100,
            closed: true
        });
    })
    //播放音乐
    function music1(row) {
        // alert("0000000000000")
        <%--console.log("${pageContext.request.contextPath}/banner/"+row.url);--%>
        $("#sour").prop("src","${pageContext.request.contextPath}/banner/"+row.url);
        // var a = $("#sour").prop("src");
        // alert(a)
        /*$('#music').dialog({
            title: '播放歌曲',
            closed:false
        });*/
        $('#music').dialog("open");
    }
</script>
<%--播放音乐---开始--%>
<div id="music">
    <audio controls="controls" autoplay="autoplay" src="" id="sour"></audio>
</div>
<%--专辑详情--%>
<div id="selectOne"></div>
<%--添加章节--%>
<div id="addChapter">
    <form id="form12" method="post" enctype="multipart/form-data">
        <input id="aid" type="hidden" name="album_id">
        章节名字:<input name="name"><br>
        文件:<input name="file" type="file"><br>
        <%--文件大小:<input name="size"><br>
        文件时长:<input name="duration"><br>--%>
        <a id="ljtj2" onclick="insertadd()">立即添加</a>
    </form>
</div>

<table id="albumtt"></table>

<!-- 添加专辑 -->
<div id="tianjia1">
    <form method="post" id="formtianjia1" enctype="multipart/form-data">
        专辑名字：<input name="name"/><br>
        专辑封面图：<input name="file" type="file"/><br>
        集数：<input name="count"/><br>
        专辑推荐指数：<input name="score"/><br>
        作者：<input name="author"/><br>
        播音：<input name="broadCast"/><br>
        内容简介：<input name="brief"/><br>
        <a id="ljtj" onclick="insert()">立即添加</a>
    </form>
</div>

