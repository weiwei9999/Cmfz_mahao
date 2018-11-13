<%@page pageEncoding="UTF-8" isELIgnored="false" %>
<script>
    $(function () {
        //通过js创建datagrid
        $("#dg8").datagrid({
            url:'${pageContext.request.contextPath}/course/findAll',//用来请求远程数据
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
                {title:'title',field:'title',width:120,sortable:true},
                {title:'marking',field:'marking',width:120,},
                {title:'datetime',field:'datetime',width:120,sortable:true},

                {title:'options',field:'options',width:200,
                    formatter:function(value,row,index){
                        return "<a href='javascript:;' class='options' onclick=\"delRow('"+row.id+"')\" data-options=\"iconCls:'icon-remove',plain:true\">删除</a>";

                    }
                }
            ]],
            onLoadSuccess:function () {
                $(".options").linkbutton();
            },
            toolbar:'#tb2',
            view: detailview,
            detailFormatter: function(rowIndex, rowData){
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/' + rowData.headpic +'" style="height:50px;"></td>' +
                    '<td style="border:0">' +
                    '<p>姓名: ' + rowData.name + '</p>' +
                    '<p>性别: ' + rowData.gender + '</p>' +
                    '</td>' +
                    '</tr></table>';
            }


        });


    });




    //删除一行的事件
    function delRow(id){
        //获取当前点击id发送ajax请求删除id这个人的信息
        $.post("${pageContext.request.contextPath}/course/delete",{"id":id},function (result) {//响应成功之后回调
            //刷新datagrid数据
            $("#dg8").datagrid('reload');//刷新当前datagrid
        });
    }

    //打开保存用户对话框函数
    function openSaveUserDialog3(){
        $("#saveUserDialog3").dialog({
            buttons:[{
                iconCls:'icon-save',
                text:'保存',
                handler:function(){
                    //保存用户信息
                    $("#saveCourseraInputForm").form('submit',{
                        url:'${pageContext.request.contextPath}/course/add',
                        success:function(result){//响应的一定是json格式字符串   使用应该先转为js对象
                            var resultObj = $.parseJSON(result);
                            if(resultObj.success){
                                //提示信息
                                $.messager.show({title:'提示',msg:"用户添加成功!!!"});
                            }else{
                                $.messager.show({title:'提示',msg:resultObj.message});
                            }
                            //关闭对话框
                            $("#saveUserDialog3").dialog('close');
                            //刷新datagrid
                            $("#dg8").datagrid('reload');
                        }
                    });
                }
            },{
                iconCls:'icon-cancel',
                text:'关闭',
                handler:function(){
                    $("#saveUserDialog3").dialog('close');
                }
            }]
        });
    }
    //批量删除多行
    function delBatchRows(){
        var rows = $("#dg8").datagrid('getSelections');
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
                url:"${pageContext.request.contextPath}/course/delete",
                type:"POST",
                //传递数据类型的数据时必须设置这个属性为true
                data:{id:ids},
                traditional:true,
                success:function(result){
                    //消息提示
                    $.messager.show({title: '提示', msg: "删除成功!!!"});
                    //刷新datagrid
                    $("#dg8").datagrid('reload');
                },
                error:function(){
                    //消息提示
                    $.messager.show({title:'提示',msg:"删除失败!!!"});
                    //刷新datagrid
                    $("#dg8").datagrid('reload');
                }
            })
        }
    }
</script>




<%--datagrid数据表格--%>
<table id="dg8"></table>

<%--datagrid工具栏--%>
<div id="tb2">
  <a href="#" class="easyui-linkbutton" onclick="openSaveUserDialog3();" data-options="iconCls:'icon-add',plain:true">添加</a>
  <a href="#" class="easyui-linkbutton" onclick="delBatchRows();" data-options="iconCls:'icon-remove',plain:true">批量删除</a>
</div>

<%--保存用户对话框--%>
<div id="saveUserDialog3" data-options="href:'${pageContext.request.contextPath}/back/course/courseradd.jsp',draggable:false,iconCls:'icon-save',width:600,height:400,title:'保存用户信息'">

</div>