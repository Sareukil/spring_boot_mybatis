<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>파일 업로드</title>
    </head>
    <body>
        <h2>파일 업로드</h2>
        <form id="fileUploadForm"method="post"action="<c:url value='/fileUpload'/>"enctype="multipart/form-data">
            파일 : <input type="file" id="uploadFile" name="uploadFile">
            <input type="submit" value="업로드">

        </form><br>

        <h2>여러 개의 파일 업로드</h2>
        <form id="fileUploadFormMulti"method="post"action="<c:url value='/fileUploadMultiple'/>"enctype="multipart/form-data">
            파일 : <input type="file" id="uploadFileMulti" name="uploadFileMulti" multiple="multiple">
            <input type="submit" value="업로드"><br><br>

        </form><br>

        <h2>파일이름 업로드</h2>
        <form id="fileUploadForm"method="post"action="<c:url value='/fileOriginalFileNameUpload'/>"enctype="multipart/form-data">
            파일 : <input type="file" id="uploadOriginalFile" name="uploadOriginalFile">
            <input type="submit" value="업로드">

        </form><br>
        <a href="<c:url value='/'/>">메인 화면으로 이동</a>
    </body>
</html>