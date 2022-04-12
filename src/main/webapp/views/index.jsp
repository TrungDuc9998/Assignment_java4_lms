<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
   <style>
	.card{
		background-color:rgb(17,17,17);
	}
	.card-body a:hover{
		color:red;
	}
	</style>
	<div id="carouselExampleFade" class="carousel slide carousel-fade" data-bs-ride="carousel" >
	  <div class="carousel-inner">
	    <div class="carousel-item active">
	      <img src="/SOF3011/image/khong-them-yeu-duong-voi-sep-93011-03-2022_14g53-10.webp" style="height:550px;width:700px" class="d-block w-100 rounded " alt="...">
	    </div>
	    <div class="carousel-item">
	      <img src="/SOF3011/image/930-204-01-2022_10g51-20.webp" style="height:550px;width:700px" class="d-block w-100 rounded " alt="...">
	    </div>
	    <div class="carousel-item">
	      <img src="/SOF3011/image/930-228-02-2022_15g51-19.webp"  style="height:550px;width:700px" class="d-block w-100 rounded " alt="...">
	    </div>
	  </div>
	  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleFade" data-bs-slide="prev">
	    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
	    <span class="visually-hidden">Previous</span>
	  </button>
	  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleFade" data-bs-slide="next">
	    <span class="carousel-control-next-icon" aria-hidden="true"></span>
	    <span class="visually-hidden">Next</span>
	  </button>
	</div>
	<div class="mt-3">
		<h4 class="text-white">Phim bộ hot</h4>
		<div class="row">
		<c:forEach items="${listVideo}" var="video">
			<div class="col-1 col-md-2">
				<div class="card text-center">
					 <div class="card-header">
					 	 <img class="row rounded" style="width:200px;height:300px" src="/SOF3011/files/${video.poster}">
					 </div>
					  <div class="card-body">
					  		<a class="text-white title"  href="/SOF3011/admin/users/detail?id=${video.id}" style="text-decoration:none;">${video.title}</a>
					  </div>
				</div>
			</div>
		</c:forEach>
		</div>
	</div>
