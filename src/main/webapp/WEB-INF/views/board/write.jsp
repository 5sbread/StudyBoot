<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Write 🖋</title>
	<c:import url="../temp/boot.jsp"></c:import>
	<c:import url="../temp/summer.jsp"></c:import>
	<script defer src="/js/fileManager.js"></script>

	<style>
		.center {
			text-align: center;
			margin: 3rem;
		}
	</style>
</head>
	
<body>
	
	<div class="container-fluid">
	<div class="row justify-content-center">
		<div class="col-6">
		<h1 class="center"> 📑🖋 </h1>
		<form action="add" method="post" enctype="multipart/form-data">
			<div class="mb-3">
			  <label for="title" class="form-label">제목</label>
			  	<input type="text" name="title" class="form-control" id="title" placeholder="제목">
			</div>
			<div class="mb-3">
			  <label for="writer" class="form-label">작성자</label>
			  	<input type="text" name="writer" class="form-control" id="writer" placeholder="작성자">
			</div>
			<div class="mb-3">
			  <label for="contents" class="form-label">내용</label>
			  <textarea class="form-control" name="contents" id="contents"></textarea>
			</div>
			
			<div class="mb-3" id="fileAddBody">
				
				
			</div>
			
			<div class="mb-3">
				<button type="button" id="fileAddBtn">파일 추가 ➕</button>
			</div>
			
<!-- 			<div class="mb-3">
			  <label for="contents" class="form-label">File</label>
			  <input type="file" name="files">
			</div>
			<div class="mb-3">
			  <label for="contents" class="form-label">File</label>
			  <input type="file" name="files">
			</div> -->
			
			<div>
				<button class="btn btn-secondary">WRITE</button>
			</div>
		</form>
		</div>
	</div>
	</div>
	
	<script type="text/javascript">
    $('#contents').summernote({
        tabsize: 1,
        height: 250
      });
	</script>

</body>
</html>