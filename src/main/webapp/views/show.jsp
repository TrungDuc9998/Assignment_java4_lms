<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<style>
	.table{
	}
</style>
<div class="container">
	<h3 class="text-white text-center">DANH SÁCH USER</h3>
	<table class="table text-white">
		<thead>
			<tr>
				<th>Id</th>
				<th>FullName</th>
				<td>Email</td>
				<td>Admin</td>
				<td colspan="2">Thao tác</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${listUser}" var="user">
				<tr>
					<td>${user.id}</td>
					<td>${user.fullname}</td>
					<td>${user.email}</td>
					<td>${user.admin==0?"Người dùng":"Quản trị"}</td>
					<td>
						<a href="/SOF3011/admin/users/edit?id=${user.id}" class="btn btn-primary">Cập nhật</a>
					<td>
					<td>
						<a href="/SOF3011/admin/users/delete?id=${user.id}" type="button" class="btn btn-primary"   data-bs-target="#exampleModal">Xoá</a>
						<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
						  <div class="modal-dialog">
						    <div class="modal-content">
						      <div class="modal-header">
						        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
						        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
						      </div>
						      <div class="modal-body">
						       <p class="text-dark">Bạn có muốn xoá bản ghi này không?</p>
						       <p class="text-dark">${user.id}</p>
						      </div>
						      <div class="modal-footer">
						        <a href="/SOF3011/admin/users/delete?id=${user.id}" class="btn btn-danger">Xoá</a>
						        <a type="button" class="btn btn-secondary" data-bs-dismiss="modal">Không</a>
						      </div>
						    </div>
						  </div>
						</div>
					<td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>