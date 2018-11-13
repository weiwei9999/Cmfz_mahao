<%@page pageEncoding="UTF-8" isELIgnored="false" %>

<div style="text-align: center;">
    <form id="saveMyInputForm" class="easyui-form" method="post"  enctype="multipart/form-data">
        <div style="margin-top: 70px;">
            username: <input type="text" name="username" class="easyui-textbox" data-options="missingMessage:'亲，不可不填哟！',iconCls:'icon-man',required:true,validType:'uname'">
        </div>
        <div style="margin-top: 20px;">
            password: <input type="text" name="password"  class="easyui-passwordbox" data-options="iconCls:'icon-edit'">
        </div>
        <div style="margin-top: 20px;">
            salt: <input type="text" name="salt"  class="easyui-textbox" data-options="iconCls:'icon-edit'">
        </div>
        <div style="margin-top: 20px;">
            province: <input type="text" name="province"  class="easyui-textbox" data-options="iconCls:'icon-edit'">
        </div>
        <div style="margin-top: 20px;">
            city: <input type="text" name="city"  class="easyui-textbox" data-options="iconCls:'icon-edit'">
        </div>
        <div style="margin-top: 20px;">
            nickname: <input type="text" name="nickname"  class="easyui-textbox" data-options="iconCls:'icon-edit'">
        </div>
        gender:
        <select class="easyui-combobox" name="gender"  data-options="width:159">
            <option value="man">男</option>
            <option value="wuman">女</option>
        </select>
        <div style="margin-top: 20px;">
            sgin: <input type="text" name="sgin"  class="easyui-textbox" data-options="iconCls:'icon-edit'">
        </div>
        <div style="margin-top: 20px;">
            headpic: <input type="text" name="headpic"  class="easyui-textbox" data-options="iconCls:'icon-edit'">
        </div>
        <div style="margin-top: 20px;">
            status: <input type="text" name="status"  class="easyui-textbox" data-options="iconCls:'icon-edit'">
        </div>

        <div style="margin-top: 20px;">
            时间: <input type="text" name="date"  class="easyui-datebox">
        </div>
        <div style="margin-top: 20px;">
            图片: <input type="text" name="wei"  class="easyui-filebox" data-options="iconCls:'icon-edit'">
        </div>

    </form>
</div>
