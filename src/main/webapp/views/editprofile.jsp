<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <style>
    
    .card input[type="text"]{
    	background-color:rgb(31,31,31);
		color:white;
    }
    .card input[type="email"],[type="password"]{
    	background-color:rgb(31,31,31);
		color:white;
    }
    .card input[type="password"]{
    	background-color:rgb(31,31,31);
		color:white;
    }
	.card{
	background-color:rgb(31,31,31);
	}
	.card input{
		background-color:rgb(31,31,31);
		
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
<div class="row">
	<div class="col-3"></div>
	<div class="col-6">
		<div class="card text-white">
			<div class="card-body">
				<form method="post" action="/SOF3011/admin/users/changpassword">
				<div class="row">
					<p class=" fw-bold fs-3 text-center text-light" >Edit Profile</p>
						<div class="col-5">
							<img class="ms-2 rounded-circle border border-light" alt="" id="image" width="220" height="220">
							 <input class="form-control mt-3" type="text" value="" name="poster">
					        	<input type="file"  name="poster" id="imageFile" class="form-control mt-3 text-danger" onchange="chooseFile(this)"
					             accept="image/gif, image/jpeg, image/png">
						</div>
						<div class="col-7 ">
			                    <div class="form-group mt-2">
			                    <label >Fullname:</label>       
			                        <input type="text" value="${fullname}" class="form-control  my-2 mt-2" name="fullname" >
			                    </div>
			                    <div class="form-group mt-4">
			                    <label >Email:</label>       
			                        <input type="email" value="${email}" class="form-control my-2 mt-2" name="email" >
			                    </div>
			                    <div class="form-group mt-4">
			                     <label >Password:</label>       
			                        <input type="password" value="${password}" class="form-control  my-2 mt-2" name="password" >
			                    </div>
			                    <div class="text-center mt-3">
			                        <button class="btn peach-gradient btn-outline-light" >Change</button>
			                    </div>
			                
						</div>
						</div>
						</form>
					</div>
					</div>
					</div>
		
	</div>
	<div class="col-3"></div>
</div>