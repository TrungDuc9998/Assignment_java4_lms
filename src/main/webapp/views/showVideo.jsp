<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<div class="container">
	<table class="table text-white">
		<thead>
			<tr>
				<th>Id</th>
				<th>Title</th>
				<th>Poster</th>
				<th>Description</th>
				<th>View</th>
				<th>Active</th>
				<th>Links</th>
				<th colspan="2">Thao tác</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${listVideo}" var="video">
				<tr>
					<td>${video.id}</td>
					<td>${video.title}</td>
					<td>${video.poster}</td>
					<td>${video.description}</td>
					<td>${video.views}</td>
					<td>${video.active}</td>
					<td>${video.links}</td>
					<td>
						<a href="/SOF3011/admin/users/updateVideo?id=${video.id}" class="btn btn-primary">Cập nhập</a>
					</td>
					<td>
						<a href="/SOF3011/admin/users/removeVideo?id=${video.id}" class="btn btn-danger">Xoá</a>
					</td>
				</tr>
			</c:forEach>
			
		</tbody>
	</table>
</div>
