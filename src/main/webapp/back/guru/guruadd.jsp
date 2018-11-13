<%@page pageEncoding="UTF-8" isELIgnored="false" %>

<div style="text-align: center;">
    <form id="saveGuruInputForm" class="easyui-form" method="post"  enctype="multipart/form-data">
        <div style="margin-top: 70px;">
            名称: <input type="text" name="name" class="easyui-textbox" data-options="missingMessage:'亲，不可不填哟！',iconCls:'icon-man',required:true,validType:'uname'">
        </div>
        <div style="margin-top: 20px;">
            图片: <input type="text" name="wei"  class="easyui-filebox" data-options="iconCls:'icon-edit'">
        </div>
        <div style="margin-top: 20px;">
            性别:
            <select class="easyui-combobox" name="gender"  data-options="width:159">
                <option value="man">男</option>
                <option value="wuman">女</option>
            </select>
        </div>

    </form>
</div>
