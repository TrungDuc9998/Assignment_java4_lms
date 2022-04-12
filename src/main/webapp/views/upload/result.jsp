<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <form method="post" action="/SOF3011/admin/users/insertVideo" enctype="multipart/form-data">
			<div class="row">
					<div class="col-5 " style="height:350px;">
						<div class="card">
							<div class="card-body">
								<h2>1. Hình: ${img.name}</h2>
							
							</div>
						</div>
					</div>
					<div class="col-7">
						<div class="form-group mt-2">
						<label>Video Title:</label>
						<input class="form-control mt-1" name="title">
						</div>
						<div class="form-group mt-2">
							<label>View:</label>
							<input class="form-control mt-1" type="number" name="views">
						</div>
						<div class="form-group mt-2">
							<label>Links:</label>
							<input class="form-control mt-1" type="text" name="links">
						</div>
						<div class="form-check form-check-inline text-white mt-3">
						  <input class="form-check-input " type="radio" name="active" id="inlineRadio1" value="1">
						  <label class="form-check-label " for="inlineRadio1">Active</label>
						</div>
						<div class="form-check form-check-inline text-white">
						  <input class="form-check-input mt-1" type="radio" name="active" id="inlineRadio2" value="0" checked>
						  <label class="form-check-label" for="inlineRadio2">In active</label>
						</div>
					</div>
					<div class="col-12">
							<label>Description:</label>
							<textarea rows="4" cols="20" name="description" class="form-control"></textarea>
					</div>
					<div class="form-group text-center col-12 mt-2">
						<button class="btn peach-gradient btn-outline-light">Thêm</button>
					</div>
			</div>
		</form>	  
<h2>1. Hình: ${img.name}</h2>
<img src="/SOF3011/files/${img.name}" height="100">
<h2>2. Tài liệu: ${doc.name}</h2>
<a href="/SOF3011/files/${doc.name}">Tải về</a>
