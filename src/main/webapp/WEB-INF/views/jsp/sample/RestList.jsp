<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sample List</title>
 
<script type="text/javascript">
<!--
 
function fnCmdNew() {
    document.sampleVo.sampleNo.value = 0;
    document.sampleVo.action = 'form.do';
    document.sampleVo.submit();
}
 
function fnCmdEdit(sampleNo) {
    document.sampleVo.sampleNo.value = sampleNo;
    document.sampleVo.action = 'form.do';
    document.sampleVo.submit(); 
}
 
function fnCmdDelete(sampleNo) {
    document.sampleVo.sampleNo.value = sampleNo;
    document.sampleVo.action = 'delete.do';
    document.sampleVo.submit(); 
}
 
 
// -->
</script>
 
</head>
<body>
 
메시지 : ${message}<br />
 
<a href="#" onclick="fnCmdNew()">[신규]</a>
 
<form:form id="sampleVo" name="sampleVo" method="post">
    <input type="hidden" name="sampleNo" />
 
    <table border="1">
        <thead>
            <tr>
                <th>Sample No</th>
                <th>Title</th>
                <th>Description</th>
                <th>수정</th>
                <th>삭제</th>
                <th>ddd</th>
            </tr>
        </thead>
        <tbody>
            
                <tr>
                    <td>${result2.sampleNo}</td>
                    <td>${result2.title}</td>
                    <td>${result2.description}</td>
                    <td><a href="#" onclick="fnCmdEdit('${result2.sampleNo}')">수정</a></td>
                    <td><a href="#" onclick="fnCmdDelete('${result2.sampleNo}')">삭제</a></td>
                    <td>${result2.sampleNo}</td>
                </tr>
           
        </tbody>
    </table>
</form:form>
 
</body>
</html>