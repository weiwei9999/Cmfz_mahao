<%@page pageEncoding="UTF-8" isELIgnored="false" %>
<script>
    $(function () {
        //通过js创建datagrid
        $("#dg1").datagrid({
            url:'${pageContext.request.contextPath}/banner/findAll',//用来请求远程数据
            pagination:true,//显示分页工具栏
            pageNumber:1,//当前页
            pageSize:5,//每页显示记录数
            pageList:[5,10,15,30,100],
            striped:true,
            rownumbers:true,
            singleSelect:false,
            ctrlSelect:true,
            remoteSort:false,
            multiSort:true,
            fit:true,
            columns:[[
                {title:'cks',field:"cks",checkbox:true},
                {title:'id',field:'id',width:120,},
                {title:'title',field:'title',width:120,},
                {title:'imgpth',field:'imgpth',width:120,sortable:true},
                {title:'descstr',field:'descstr',width:120,sortable:true},
                {title:'status',field:'status',width:120,},
                {title:'date',field:'date',width:120,},
                {title:'options',field:'options',width:200,
                    formatter:function(value,row,index){
                        return "<a href='javascript:;' class='options' onclick=\"delRow('"+row.id+"')\" data-options=\"iconCls:'icon-remove',plain:true\">删除</a>&nbsp;&nbsp;" +
                            "<a href='javascript:;' class='options' onclick=\"openEditUserDialog('"+row.id+"')\" data-options=\"iconCls:'icon-edit',plain:true\">更新</a>";
                    }
                }
            ]],
            onLoadSuccess:function () {
                $(".options").linkbutton();
            },
            toolbar:'#tb',
            view: detailview,
            detailFormatter: function(rowIndex, rowData){
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/' + rowData.imgpth +'" style="height:50px;"></td>' +
                    '<td style="border:0">' +
                    '<p>Attribute: ' + rowData.title + '</p>' +
                    '<p>Status: ' + rowData.status + '</p>' +
                    '</td>' +
                    '</tr></table>';
            }


        });


    });


    //打开修改用户的对话框
    function openEditUserDialog(id){
        $("#editUserDialog").dialog({
            href:'${pageContext.request.contextPath}/back/dept/edit.jsp?id='+id,
            buttons:[
                {
                    iconCls:'icon-save',
                    text:"修改",
                    handler:function(){
                        $("#editUserInputForm").form('submit',{
                            url:"${pageContext.request.contextPath}/banner/update",
                            success:function (result) {//注意一定是json字符串  使用需要转为js对象
                                //关闭dialog
                                $("#editUserDialog").dialog('close');
                                //刷新datagrid
                                $("#dg1").datagrid('reload');//刷新当前datagrid
                                //提示修改信息
                                var resultObj = $.parseJSON(result);

                                if(resultObj.success){
                                    //提示信息
                                    $.messager.show({title:'提示',msg:"用户添加成功!!!"});
                                }else{
                                    $.messager.show({title:'提示',msg:resultObj.message});
                                }

                            }
                        })
                    }
                },
                {
                    iconCls:'icon-cancel',
                    text:"取消",
                    handler:function(){
                        $("#editUserDialog").dialog('close');
                    }
                },
            ]
        });

    }

    //删除一行的事件
    function delRow(id){
        //获取当前点击id发送ajax请求删除id这个人的信息
        $.post("${pageContext.request.contextPath}/banner/delete",{"id":id},function (result) {//响应成功之后回调
            //刷新datagrid数据
            $("#dg1").datagrid('reload');//刷新当前datagrid
        });
    }

    //打开保存用户对话框函数
    function openSaveUserDialog(){
        $("#saveUserDialog").dialog({
            buttons:[{
                iconCls:'icon-save',
                text:'保存',
                handler:function(){
                    //保存用户信息
                    $("#saveUserInputForm").form('submit',{
                        url:'${pageContext.request.contextPath}/banner/add',
                        success:function(result){//响应的一定是json格式字符串   使用应该先转为js对象
                            var resultObj = $.parseJSON(result);
                            if(resultObj.success){
                                //提示信息
                                $.messager.show({title:'提示',msg:"用户添加成功!!!"});
                            }else{
                                $.messager.show({title:'提示',msg:resultObj.message});
                            }
                            //关闭对话框
                            $("#saveUserDialog").dialog('close');
                            //刷新datagrid
                            $("#dg1").datagrid('reload');
                        }
                    });
                }
            },{
                iconCls:'icon-cancel',
                text:'关闭',
                handler:function(){
                    $("#saveUserDialog").dialog('close');
                }
            }]
        });
    }
    //批量删除多行
    function delBatchRows(){
        var rows = $("#dg1").datagrid('getSelections');
        if(rows.length<=0){
            $.messager.show({title:'提示',msg:"至少选中一行!!!"});
        }else{
            var ids = [];
            for (var i = 0; i < rows.length ; i++) {
                console.log(rows[i].id);
                ids.push(rows[i].id);
            }
            console.log(ids);
            //发送ajax请求传递数组  注意: $.get $.post 只能传递简单数据(key=value) 不能数组类型的数据
            //                        如果想要传递数组类型的数据只能使用  $.ajax 并且还要设置其中的一个属性
            $.ajax({
                url:"${pageContext.request.contextPath}/banner/delete",
                type:"POST",
                //传递数据类型的数据时必须设置这个属性为true
                data:{id:ids},
                traditional:true,
                success:function(result){
                    //消息提示
                    $.messager.show({title: '提示', msg: "删除成功!!!"});
                    //刷新datagrid
                    $("#dg1").datagrid('reload');
                },
                error:function(){
                    //消息提示
                    $.messager.show({title:'提示',msg:"删除失败!!!"});
                    //刷新datagrid
                    $("#dg1").datagrid('reload');
                }
            })
        }
    }
</script>




<%--datagrid数据表格--%>
<table id="dg1"></table>

<%--datagrid工具栏--%>
<div id="tb">
  <a href="#" class="easyui-linkbutton" onclick="openSaveUserDialog();" data-options="iconCls:'icon-add',plain:true">添加</a>
  <a href="#" class="easyui-linkbutton" onclick="delBatchRows();" data-options="iconCls:'icon-remove',plain:true">批量删除</a>
</div>

<%--保存用户对话框--%>
<div id="saveUserDialog" data-options="href:'${pageContext.request.contextPath}/back/dept/Banneradd.jsp',draggable:false,iconCls:'icon-save',width:600,height:400,title:'保存用户信息'">



</div>

<%--更新用户对话框--%>
<div id="editUserDialog" data-options="draggable:false,iconCls:'icon-edit',width:600,height:400,title:'更新用户信息'">


</div>



