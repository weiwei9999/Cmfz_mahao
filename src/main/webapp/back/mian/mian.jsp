<%@page pageEncoding="UTF-8" isELIgnored="false" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, admin-scalable=no, initial-scale=1.0, maximum-scale=1.0,
   minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back/easyui/themes/icon.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/easyui/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/easyui/form.validator.rules.js"></script>
    <script>
        $(function () {
            //页面加载完成之后显示菜单数据
            $.post("${pageContext.request.contextPath}/tclass/findAll",function (menu) {
                //通过accordion的添加方法追加菜单
                console.log(menu);
                //遍历一级菜单
                $.each(menu,function (index,m) {
                    //遍历二级菜单
                    var content = "<div style='text-align: center;'>";
                    $.each(m.tclass,function(idx,child){
                        content += "<a onclick=\"addTabs('"+child.name+"','"+child.iconCls+"','"+child.href+"')\" style='width:95%;margin:10px 0px; border: 2px #CC2222 solid;' class='easyui-linkbutton' data-options=\"plain:true,iconCls:'"+child.iconCls+"'\">"+child.name+"</a><br>";
                    });
                    content += "</div>"
                    //添加菜单
                    $("#menu").accordion('add',{
                        title:m.name,
                        iconCls:m.iconCls,
                        content:content,
                    })
                });

            });
        });

        //点击菜单追加选项卡
        function addTabs(title,iconCls,href){
            //添加以前先判断tabs中是否存在这个选项卡
            if(!$("#tabs").tabs('exists',title)){
                $("#tabs").tabs('add',{
                    title:title,
                    iconCls:iconCls,
                    closable:true,
                    fit:true,
                    href:"${pageContext.request.contextPath}/"+href,
                });
            }else{
                $("#tabs").tabs('select',title);
            }

        }
    </script>
</head>
<body class="easyui-layout">


<%--页面的头部分--%>
<div data-options="region:'north',split:false,href:'${pageContext.request.contextPath}/back/mian/head.jsp'"  style="height:100px;text-align: center;color:orangered"></div>



<%--页面的左侧位置--%>
<div data-options="region:'west',title:'系统菜单',split:false" style="width:200px;">

    <div id="menu" class="easyui-accordion" data-options="fit:true"></div>

</div>

<%--页面的中间位置--%>
<div data-options="region:'center'" >

    <%--选项卡--%>
        <div id="tabs" class="easyui-tabs" data-options="fit:true"></div>
</div>


<%--页面的尾部分--%>
<div data-options="region:'south',split:false,href:'${pageContext.request.contextPath}/back/mian/footer.jsp'" style="height:60px;text-align: center"></div>

</body>
</html>