<%@page pageEncoding="UTF-8" isELIgnored="false" %>

<div style="text-align: center;">
    <form id="saveUserInputForm" class="easyui-form" method="post"  enctype="multipart/form-data">
        <div style="margin-top: 70px;">
            名称: <input type="text" name="title" class="easyui-textbox" data-options="missingMessage:'亲，不可不填哟！',iconCls:'icon-man',required:true,validType:'uname'">
        </div>
        <div style="margin-top: 20px;">
            图片: <input type="text" name="wei"  class="easyui-filebox" data-options="iconCls:'icon-edit'">
        </div>
        <div style="margin-top: 20px;">
            描述: <input type="text" name="descstr"  class="easyui-textbox" data-options="iconCls:'icon-edit'">
        </div>
        <div style="margin-top: 20px;">
            状态: <input type="text" name="status"  class="easyui-textbox" data-options="iconCls:'icon-edit'">
        </div>

        <div style="margin-top: 20px;">
            时间: <input type="text" name="date"  class="easyui-datebox">
        </div>

    </form>
</div>
