<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <style>
    
    .card input[type="email"],[type="password"]{
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
<div class="container">
	<div class="row">
		<h4 class="text-white text-center">Đăng nhập</h4>
        <div class="card col-md-5 container shadow-lg p-3 mb-5  rounded mt-2" >
            <div class="card-body" >
                <form method="post" action="/SOF3011/admin/users/login">
                    <div class="form-group mt-2">       
                        <input type="email" class="form-control rounded-pill text-center my-2 mt-4" value="${email}" name="email" placeholder="Email?" >
                    </div>
                    <div class="form-group mt-2">
                        <input type="password" class="form-control rounded-pill text-center  my-2 mt-4" value="${password}" name="password" placeholder="Mật khẩu?" >
                    </div>
       
                    <div class="mt-4 text-center">
                        <button class="btn peach-gradient btn-outline-light rounded-pill">Đăng nhập</button>
                    </div>
                    <div class="text-center mt-2 text-light">
                    	<p>Chưa có tài khoản ? <a href="/SOF3011/admin/user/register">Đăng ký ngay</a> </p>
                    </div>
                    <div class="text-center text-light">
                    	<p>Chính sách và quy định</p>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
                   