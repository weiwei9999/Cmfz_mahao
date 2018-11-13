<%@page pageEncoding="UTF-8" isELIgnored="false" %>
<script>
    $(function(){
        $("#showAlbumForm").form("load","${pageContext.request.contextPath}/album/findone?id="+${param.id});
    });
</script>
<div style="text-align: center;">
    <form id="showAlbumForm" class="easyui-form" method="post">
        <div style="margin-top: 40px;">
            标<span style="color:#fff;">你好</span>题：<input readonly type="text" class="easyui-textbox" name="title">
        </div>


        <div style="margin-top: 20px;">
            星<span style="color:#fff;">你好</span>级：<input readonly type="text" class="easyui-textbox" name="score">
        </div>
        <div style="margin-top: 20px;">
            作<span style="color:#fff;">你好</span>曲：<input readonly type="text" class="easyui-textbox" name="author">
        </div>
        <div style="margin-top: 20px;">
            播<span style="color:#fff;">你好</span>音：<input readonly type="text" class="easyui-textbox" name="broadcast">
        </div>
        <div style="margin-top: 20px;">
            发布时间：<input readonly type="text" class="easyui-textbox" name="publishdate">
        </div>
        <div style="margin-top: 20px;">
            <p style="margin-left:-147px;">专辑封面：</p><img style="width:100px;height:100px;margin-top:-28px;margin-left:10px;" src="${pageContext.request.contextPath}/${sessionScope.wei}"/>
        </div>
    </form>

</div>