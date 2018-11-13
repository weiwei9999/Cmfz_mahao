<%@page pageEncoding="UTF-8" isELIgnored="false"%>



<div style="margin-top:40px;text-align: center;">

    <form id="saveAlbumForm" method="post" class="easyui-form" enctype="multipart/form-data">
        <div style="margin-top: 40px;">
            标<span style="color:#fff;"></span>题：<input type="text" class="easyui-textbox" name="title">
        </div>
        <div style="margin-top: 20px;">
            星<span style="color:#fff;"></span>级：<input type="text" class="easyui-textbox" name="score">
        </div>
        <div style="margin-top: 20px;">
            作<span style="color:#fff;"></span>者：<input type="text" class="easyui-textbox" name="author">
        </div>
        <div style="margin-top: 20px;">
            播<span style="color:#fff;"></span>音：<input type="text" class="easyui-textbox" name="broadcast">
        </div>
        <div style="margin-top: 20px;">
            简<span style="color:#fff;"></span>介：<input type="text" class="easyui-textbox" name="brief">
        </div>
        <div style="margin-top: 20px;">
            发布<span style="color:#fff;"></span>时间： <input type="text" name="publishdate"  class="easyui-datebox">
        </div>
        <div style="margin-top: 20px;margin-left:74px;">
            专辑封面：<input type="file" name="wei"/>
        </div>
    </form>

</div>