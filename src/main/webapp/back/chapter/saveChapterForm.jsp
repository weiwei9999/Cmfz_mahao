<%@page isELIgnored="false" pageEncoding="UTF-8" %>

<div style="text-align: center;margin-top: 60px;">

    <form method="post" class="easyui-form" enctype="multipart/form-data" id="saveChapterForm">
        <div style="margin-top: 20px;margin-left: 74px;">
            上传章节：<input name="upload" type="file"/>
        </div>
        <input  type="hidden" value="${param.id}" name="albumid"/>

    </form>

</div>