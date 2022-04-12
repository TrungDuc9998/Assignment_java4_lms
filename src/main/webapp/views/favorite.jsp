<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>


  
  <div >
  	<div class="form-group text-white">
  		<form action="/SOF3011/admin/users/favorites" method="post">	
  		<div class="row">		
	  			<div class="col-3 text-center mt-1">
	  				<p>Video title</p>
	  			</div>
	  			<div class="col-6">
	  					<select  class="form-control" name="title">
					  		<c:forEach items="${listVideo}" var="item">
					  			<option value="${item.title}">${item.title}</option>
					  		</c:forEach>
				  		</select>
	  			</div>
	  			<div class="col-3">
	  					<button class="btn btn-primary">Tìm kiếm </button>
	  			</div>
  					
  		</div>
  		</form>  
	  	<table class="table text-white">
	  		<thead>
	  			<tr>
	  				<th>Username</th>
	  				<th>FullName</th>
	  				<th>Email</th>
	  				<th>Fatorite Date</th>
	  			</tr>
	  		</thead>
	  		<tbody>
  				<c:forEach items="${list}" var="user">
  					<tr>
  						<td class="text-white">${user.email}</td>
  					</tr>
  				</c:forEach>
	  		</tbody>
	  	</table>
  </div>
  </div>
 
