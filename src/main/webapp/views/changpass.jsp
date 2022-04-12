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
		border: 1px solid  rgb(45,233,244);
	}
</style>
<div class="container">
	<div class="row">
        <div class="card col-md-5 container shadow-lg p-3 mb-5  rounded mt-2" >
            <div class="card-body" >
                <form method="post" action="/SOF3011/admin/users/changpassword">
                	<p class=" fw-bold fs-3 text-center" style="color: rgb(45,233,244);" >Change Password</p>
                    <div class="form-group mt-2">
                    <label style="color: rgb(45,233,244);">Fullname:</label>       
                        <input type="text" class="form-control  my-2 mt-2" name="fullname" >
                    </div>
                    <div>
                    <label style="color: rgb(45,233,244);">Email:</label>       
                        <input type="email" class="form-control my-2 mt-2" name="email" >
                    </div>
                    <div>
                     <label style="color: rgb(45,233,244);">Password:</label>       
                        <input type="password" class="form-control   my-2 mt-2" name="password" >
                    </div>
                    <div class="text-center mt-3">
                        <button class="btn peach-gradient btn-outline-primary" style="color: rgb(45,233,244);">Change</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>