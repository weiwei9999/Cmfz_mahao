<%@page pageEncoding="UTF-8" isELIgnored="false"%>
<script>

    $(function(){
        $("#albumDg").treegrid({
            url:"${pageContext.request.contextPath}/album/findAll",
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
            fitColumns:true,
            idField:'id',
            treeField:'title',
            fit:true,
            columns:[[
                {field:"title",title:"名字",width:150},
                {field:"size",title:"章节大小",width:150},
                {field:"downpath",title:"下载路径",width:150},
                {field:"duration",title:"章节时长",width:150}
            ]],
            toolbar:[
                {
                  text:"专辑详情",
                  iconCls:"icon-tip",
                  handler:function(){
                        var album = $("#albumDg").treegrid("getSelected");
                        if(album == "" || album == null){
                            $.messager.show({
                                title:"提示信息",
                                msg:"请选中一张您想查看的专辑"
                            });
                        }else{
                            var id = album.id;
                            //alert(id);
                            $("#showAlbumDialog").dialog({
                                width:400,
                                height:500,
                                title:"专辑展示",
                                iconCls:"icon-filter",
                                onOpen:function(){
                                    $.post("${pageContext.request.contextPath}/album/findone",{id:id});
                                },
                                href:"${pageContext.request.contextPath}/back/Album/showOne.jsp?id="+id,
                                buttons:[
                                    {
                                        text:"关闭",
                                        iconCls:"icon-no",
                                        handler:function(){
                                            $("#showAlbumDialog").dialog("close");
                                        }
                                    }
                                ]
                            });
                        }
                  }
                },
                {
                    text:"添加专辑",
                    iconCls:"icon-save",
                    handler:function(){
                        $("#saveAlbumDialog").dialog({
                            width:500,
                            height:400,
                            title:"专辑展示",
                            iconCls:"icon-filter",
                            href:"${pageContext.request.contextPath}/back/Album/saveAlbum.jsp",
                            buttons:[
                                {
                                    text:"提交",
                                    iconCls:"icon-save",
                                    handler:function(){
                                        $("#saveAlbumForm").form("submit",{
                                            url:"${pageContext.request.contextPath}/album/add",
                                            success:function(data){
                                                var result = $.parseJSON(data);
                                                if(result.success){
                                                    $.messager.show({
                                                        "title":"提示信息",
                                                        "msg":"专辑发布成功！！！"
                                                    });

                                                    $("#saveAlbumDialog").dialog("close");
                                                    $("#albumDg").treegrid("reload");

                                                }else{
                                                    $.messager.show({
                                                        "title":"提示信息",
                                                        "msg":"专辑发布失败！！！"
                                                    });
                                                    $("#saveAlbumDialog").dialog("close");

                                                }
                                            }
                                        });

                                    }

                                },{
                                    text:"关闭",
                                    iconCls:"icon-no",
                                    handler:function(){
                                        $("#saveAlbumDialog").dialog("close");
                                    }
                                }
                            ],
                        });
                    }
                },
                {
                    text:"添加章节",
                    iconCls:"icon-save",
                    handler:function(){
                        var album = $("#albumDg").treegrid("getSelected");
                        if(album == "" || album == null){
                            $.messager.show({
                                title:"提示信息",
                                msg:"请选中您想添加的专辑"
                            });
                        }else{
                            var id = album.id;
                            $("#saveChapterDialog").dialog({
                                width:400,
                                height:270,
                                title:"添加章节",
                                iconCls:"icon-music",
                                href:"${pageContext.request.contextPath}/back/chapter/saveChapterForm.jsp?id="+id,
                                buttons:[
                                    {
                                        text:"提交",
                                        iconCls:"icon-save",
                                        handler:function(){
                                            $("#saveChapterForm").form("submit",{
                                                url:"${pageContext.request.contextPath}/chapter/save",
                                                success:function(data){
                                                    var result = $.parseJSON(data);
                                                    if(result.success){
                                                        $.messager.show({
                                                            "title":"提示信息",
                                                            "msg":"章节插入成功！！！"
                                                        });

                                                        $("#saveChapterDialog").dialog("close");
                                                        $("#albumDg").treegrid("reload");

                                                    }else{
                                                        $.messager.show({
                                                            "title":"提示信息",
                                                            "msg":result.msg
                                                        });
                                                        $("#saveChapterDialog").dialog("close");

                                                    }
                                                }
                                            });
                                        }

                                    },{
                                        text:"关闭",
                                        iconCls:"icon-no",
                                        handler:function(){
                                            $("#saveChapterDialog").dialog("close");
                                        }
                                    }
                                ],
                            });

                        }

                    }
                },
                {
                    text:"下载音频",
                    iconCls:"icon-save",
                    handler:function () {
                        var idd = $("#albumDg").datagrid('getSelected');
                        if (idd.albumid!=null){
                            location.href='${pageContext.request.contextPath}/chapter/download?fileName='+idd.title;
                        }else {
                            $.messager.alert('下载的音频','亲！请选择你要下载的音频');
                        }
                    }
                }
            ],
        });

    });

</script>


<table id="albumDg" data-options="fit:true">
</table>

<!--展示专辑的dialog-->
<div id="showAlbumDialog">
</div>
<!--添加专辑的dialog-->
<div id="saveAlbumDialog">
</div>
<!--添加章节的dialog-->
<div id="saveChapterDialog">
</div>


