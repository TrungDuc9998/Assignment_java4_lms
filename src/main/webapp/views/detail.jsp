<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<style>
	.card{
		background-color:rgb(17,17,17);
	}
	.comments{
		bacground-color:rgb(17,17,17);
		color:rgb(125,125,125);
	}
	
	.detail input{
		background-color: black;
		border:1px solid black;
	}
</style>

<div class="row">	
	<iframe width="1290" class="rounded"  height="600" src="https://www.youtube.com/embed/${listVideo.links}" 
	title="YouTube video player" frameborder="0" 
	allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" 
	allowfullscreen></iframe>
</div>
<div class="mt-3">
	<div class="row">
		<div class="col-3 col-md-2 bg-light">
			<div class="card mt-3 text-center">
				 <div class="card-header">
			 	 	<img class="row rounded" style="width:200px;height:300px" src="/SOF3011/files/${listVideo.poster}">
			 	</div>
			</div>
		</div>
		<div class="col-7 col-md-6 text-white bg-primary">
			<h4 class=" mt-4"> ${listVideo.title}</h4>
			<button class="btn peach-gradient btn-outline-light mt-2">Like</button>
			<button class="btn peach-gradient btn-outline-warning mt-2">Share</button>
			<p class=" mt-2">Nội dung</p>
			<p>${listVideo.description}</p>
		</div>
		<div class="col-2 col-md-4 bg-danger"></div>
		
	</div>
	<div class="row bg-black ms-1 rounded mt-4">
		<p class="text-white fs-4 ms-2 mt-2">Bình luận</p>
		<div class="col-12 comments">
			<p class="ms-2">10 bình luận</p>
			<form action="/SOF3011/admin/users/comment" method="post">
			<div class="row">
				<c:choose>
					<c:when test="${fullname!='Tài Khoản'}">
						<div class="col-3 detail">
						<p class="text-center"> Mời nhập bình luận:</p>
						<input class="disabled"  value="${listVideo.id}" name="Idvideo">
						<input value="${UserId}" name="favorite">
						
					</div>
					<div class="col-6">
						<input class="form-control" name="comment" >
					</div>
					<div class="col-3">
						
						<button class="btn btn-primary">Bình luận</button>
					</div>
					</c:when>
					<c:when test="${fullname=='Tài Khoản'}">
						<p class="text-light">Vui lòng đăng nhập để bình luận</p>
					</c:when>
				</c:choose>
					
				</div>
				</form>
			<c:forEach items="${listComment}" var="fv">
				<div class="row">
					<div class="col-1 text-center">
							<img alt="" src="/SOF3011/image/logo_user-comment.jpg" class="rounded-circle" style="width:50px;height:50px">	
					</div>
					<div class="col-11">
						<h5 class="text-light">${fullname}  </h5>
						<p class="fs-7" style="margin-top:-10px">${fv.commentDate}</p>
						<p>${fv.commentContent}</p>
					</div>
				</div>	
			</c:forEach>
		</div>
	</div>
</div>


			
		
	
