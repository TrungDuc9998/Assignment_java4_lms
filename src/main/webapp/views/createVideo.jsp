<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
	.card{
		background-color:rgb(17,17,17);
	}
	
	.row input[type="text"],[type="number"],[type="file"]{
		background-color:rgb(17,17,17);
		color:white;
	}
	.row textarea {
		background-color:rgb(17,17,17);
	}
</style>
<script>
	function chooseFile(fileInput) {
	  if (fileInput.files && fileInput.files[0]){
	      var reader = new FileReader();
	      
	      reader.onload = function (e){
	           $('#image').attr('src', e.target.result);
	      }
	      reader.readAsDataURL (fileInput.files[0]);
	  	}
	  }
</script>
<div class="row text-white">
	<div class="col-3"></div>
	<div class="col-6">
		<form method="post" action="/SOF3011/admin/users/insertVideo" enctype="multipart/form-data">
			<div class="row">
					<div class="col-5 " style="height:350px;">
						<div class="card border border-light">
							<div class="card-body">
								 <img src="" alt="" id="image" width="220" height="250">
							        <input type="file" name="poster" id="imageFile" class="form-control mt-3" onchange="chooseFile(this)"
							             accept="image/gif, image/jpeg, image/png">
							
							</div>
						</div>
					</div>
					<div class="col-7">
						<div class="form-group mt-2">
						<label>Video Title:</label>
						<input type="text" class="form-control mt-1" name="title">
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
	</div>
	<div class="col-3"></div>
</div>