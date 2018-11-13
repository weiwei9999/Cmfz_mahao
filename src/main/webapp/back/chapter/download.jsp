<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page pageEncoding="UTF-8" isELIgnored="false" %>
<script>

</script>

<div style="margin-top: 60px;">
    <c:if test="${sessionScope.flag==true}">
        <c:forEach items="${sessionScope.chapterList}" var="chapter">
            <div style="margin-top:20px;margin-left:80px;">
                <a id="checkDownload" class="easyui-linkbutton" href='${pageContext.request.contextPath}/chapter/download?downPath=${chapter.downPath}&id=${chapter.cid}'>${chapter.title}</a>
            </div>
        </c:forEach>
    </c:if>
    <c:if test="${sessionScope.flag==false}">
        <p>此张专辑还未添加歌曲！！！</p>
    </c:if>
</div>