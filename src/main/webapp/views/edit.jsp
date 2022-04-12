<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <style>
		.card{
		background-color:rgb(31,31,31);
		}
		.card input[type="text"],[type="email"],[type="password"]{
			background-color:rgb(31,31,31);
			color:white;
		}
	</style>
	<div class="container">
	<div class="row">
        <div class="card col-md-5 container shadow-lg p-3 mb-5  rounded mt-2" >
            <div class="card-body" >
                <form class="text-white" action="/SOF3011/admin/users/edit?id=${user.id}" method="post">
                <h4 class="text-white text-center">CẬP NHẬT</h4>
                <hr  style="height:2px;">
                    <div class="form-group mt-2">      
                    	 <label class="text-white">FullName:</label> 
                        <input type="text" name="fullname" value="${user.fullname}" class=" form-control my-2 mt-2 "  >
                    </div>
                    <div class="form-group mt-2">
                     <label class="text-white">Email:</label> 
                        <input type="email" name="email" value="${user.email}" class="form-control my-2 mt-2"  >
                    </div>
                    <div class="form-group mt-2">
                     <label class="text-white">Password:</label> 
                        <input type="password" name="password" value="${user.password}" class="form-control my-2 mt-2"  >
                    </div>
                    <label class="text-white">Phân quyền:</label> 
                    <br>
                    <div class="form-check form-check-inline text-white mt-2">
					  <input class="form-check-input " type="radio" name="admin" id="inlineRadio1" ${user.admin==0?"selected":"" } value="1">
					  <label class="form-check-label " for="inlineRadio1">Admin</label>
					</div>
					<div class="form-check form-check-inline text-white">
					  <input class="form-check-input" type="radio" name="admin" id="inlineRadio2"  ${user.admin==0?"selected":"" } value="0" checked>
					  <label class="form-check-label" for="inlineRadio2">User</label>
					</div>
                    <div class="text-center mt-3">
                        <button class="btn peach-gradient btn-outline-light ">Cập nhật</button>
                    </div>           
                </form>
            </div>
        </div>
    </div>
</div>
