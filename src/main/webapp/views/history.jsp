<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<style>
	.card{
		background-color:rgb(17,17,17);
	}
</style>
<div class="mt-3">
		<h4 class="text-white">Danh sách yêu thích</h4>
		<div class="row">
		<c:forEach items="${listVideo}" var="video">
			<div class="col-2">
					<div class="card text-center">
					 <div class="card-header">
					 	 <img class="row rounded" style="width:200px;height:300px" src="/SOF3011/files/${video.poster}">
					 </div>
					  <div class="card-body">
					   <a class="text-white" href="/SOF3011/admin/users/detail?id=${video.id}" style="text-decoration:none;">${video.title}</a>
					  </div>
				</div>
			</div>
		</c:forEach>
		</div>
	</div>