<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/SOF3011/ThuVien/bootstrap.min.css">
<link rel="stylesheet" href="/SOF3011/ThuVien/all.min.css">
<title>Index</title>
<style type="text/css">
	.navbar-nav{
		  font-weight: bold;
		   font-family:Arial, Helvetica, sans-serif;
		   
	}
	.navbar-nav li{
		padding-left:30px;
	}
	
	body{
	background-color:rgb(17,17,17);
	}
</style>
</head>
<body >
	<div class="row">
		<nav class="navbar navbar-expand-lg fixed-top navbar-dark bg-black ">
          <div class="container-fluid">
            <img src="/SOF3011/image/logo-2.png"  width="90px;" class="ms-3" >
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
              <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                  <a class="nav-link active" aria-current="page" href="/SOF3011/admin/users/index">Trang chủ</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="#subjects">Quản lý user</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="#introduce">Giới thiệu</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="#contact">Liên hệ</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="#feedback">Góp ý</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="#Q&A">Hỏi đáp</a>
                </li> 
                <li class="nav-item">
                  <a class="nav-link" href="#history">Lịch sử làm bài</a>
                </li>    
              </ul>
              <ul class="row navbar-nav">  
                <li class="nav-item dropdown">
                  <a class="nav-link dropdown-toggle text-white" href="#" id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                   ${fullname}
                  </a>
                  <ul class="dropdown-menu " aria-labelledby="navbarDropdownMenuLink">
                    <div>
                        <a class="dropdown-item" href="#register">Đăng ký</a>
                        <a class="dropdown-item" href="/SOF3011/admin/users/login">Đăng nhập</a>
                        <a class="dropdown-item"  href="/SOF3011/admin/users/forgotpassword">Quên mật khẩu</a>
                        <a class="dropdown-item"  href="/SOF3011/admin/users/history">Yêu thích</a>
                        <a class="dropdown-item"  href="/SOF3011/admin/users/logout">Đăng xuất</a>
                    </div>
                  </ul>
                </li>
              </ul>
            </div>
          </div>
        </nav>
	</div>
	
	<div class="container">
		<div class="row" style="margin-top:60px;">
			<div class="col-12 mt-4">
				<jsp:include page="${ view }"></jsp:include>
			</div>
		</div>
	</div>
	<div class="row bg-black mt-4">
			<div class="col-3 mt-3">
				<img class="offset-4" src="/SOF3011/image/logo-2.png">
				<img class="offset-4 mt-4" src="/SOF3011/image/logo-sale-noti.bc5b290.png">
				<img class="offset-4 mt-4" src="/SOF3011/image/dmca_protected_sml_120n.png">
			</div>
			<div class="col-6 text-white mt-3">
				<div style="float:left">
					<a>Gói data</a>
				</div>
				<div style="float:left; margin-left:20px">
					<a>Quảng cáo</a>
				</div>
				<div style="float:left; margin-left:20px">
					<a>Dịch vụ</a>
				</div>
				<div style="float:left; margin-left:20px">
					<a>Điều khoản</a>
				</div>
				<div style="float:left; margin-left:20px">
					<a>Chính sách</a>
				</div>
				<div style="float:left; margin-left:20px">
					<a>Liên hệ</a>
				</div>
				<div style="float:left; margin-left:20px">
					<a>Cửa hàng</a>
				</div>
				<hr class="bg-white mt-5">
				<div>
					<p>Công ty Cổ phần Viễn Thông FPT - Người đại diện: Ông Hoàng Việt Anh</p>
				</div>
				<div>
					<p>Trụ sở: Tầng 8, tòa nhà FPT Tower, số 10 Phạm Văn Bạch, Cầu Giấy, Hà Nội</p>
				</div>
				<div>
					<p>Điện thoại: 19006600. Email: support@fptplay.net</p>
				</div>
				<div>
					Số giấy chứng nhận đăng ký kinh doanh: 0101778163 do Sở Kế Hoạch Đầu Tư Thành Phố Hà Nội cấp vào ngày 28/07/2005
				</div>
				<div class="mt-2">
					<p>Giấy phép Cung cấp Dịch vụ Phát thanh, Truyền hình trên mạng Internet số 568/GP-BTTTT cấp ngày 7/12/2020.</p>
				</div>
			</div>
			<div class="col-3"></div>
		</div>
	<script src="/SOF3011/ThuVien/popper.min.js"></script>
	<script src="/SOF3011/ThuVien/jquery.min.js"></script>
	<script src="/SOF3011/ThuVien/bootstrap.min.js"></script>
</body>
</html>