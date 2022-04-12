package Servlets.admin.user;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.beanutils.BeanUtils;

import com.mysql.cj.x.protobuf.MysqlxExpr.Object.ObjectFieldOrBuilder;

import Cookie.CookieUtils;
import DAO.CommentDAO;
import DAO.FavoriteDAO;

import DAO.UserDAO;
import DAO.VideoDAO;
import Entity.Comment;
import Entity.Favorite;

import Entity.User;
import Entity.Video;


@MultipartConfig()
@WebServlet({
	"/admin/users/index"
	,"/admin/users/login",	
	"/admin/users/create",
	"/admin/users/show",
	"/admin/users/edit",
	"/admin/users/delete",
	"/admin/users/detail",
	"/admin/users/insertVideo",
	"/admin/users/viewVideo",
	"/admin/users/updateVideo",
	"/admin/users/removeVideo",
	"/admin/users/favorites",
	"/admin/users/changpassword",
	"/admin/users/forgotpassword",
	"/admin/users/updateUser",
	"/admin/users/history",
	"/admin/users/logout",
	"/admin/users/comment"
	
	})
public class homeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDao;
	private VideoDAO videoDAO;
	private FavoriteDAO favoriteDao;
	private CommentDAO commentDao;
//	private EntityManager em;
//	private ReportDAO reportDAO;
	
	
    
    public homeServlet() {
    	super();
       this.userDao=new UserDAO();
       this.videoDAO=new VideoDAO();
//       this.reportDAO=new ReportDAO();
       this.favoriteDao=new FavoriteDAO();
       this.commentDao=new CommentDAO();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		String uri=request.getRequestURI();
		if(uri.contains("index")) {
			this.index(request,response);
		}else if(uri.contains("login")){
			this.login(request, response);
		}
		if(uri.contains("register")) {
//			this.register(request, response);
		}else if(uri.contains("create")) {
			this.create(request, response);
		}else if(uri.contains("show")) {
			this.show(request, response);
		}else if(uri.contains("edit")) {
			this.edit(request,response);
		}else if(uri.contains("delete")) {
			this.delete(request,response);
		}else if(uri.contains("detail")) {
			this.detail(request,response);
		}else if(uri.contains("insertVideo")) {
			this.createVideo(request,response);
		}else if(uri.contains("viewVideo")) {
			this.showVideo(request,response);
		}else if(uri.contains("updateVideo")) {
			this.editVideo(request,response);
		}else if(uri.contains("removeVideo")) {
			this.removeVideo(request,response);
		}else if(uri.contains("favorites")) {
			this.favorites(request,response);
		}else if(uri.contains("changpassword")) {
			this.changpassword(request,response);
		}else if(uri.contains("forgotpassword")) {
			this.forgotpassword(request,response);
		}else if(uri.contains("updateUser")) {
			this.editprofile(request,response);
		}else if(uri.contains("logout")) {
			this.logout(request,response);
		}else if(uri.contains("history")) {
			this.history(request, response);
		}
	}
	
	
	public void history(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		String email=CookieUtils.get("email", request);
		System.out.println("email"+email);
		if(!email.equals("")) {
			User u=this.userDao.findByEmail(email);
			String FullName=u.getFullname();
			request.setAttribute("fullname", FullName);
			int id=u.getId();
			System.out.println(id);
			List<Video>video=this.videoDAO.findAll1(id);
			System.out.println("list:"+video);
			request.setAttribute("listVideo", video);
			request.setAttribute("view", "/views/history.jsp");
			request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
		}else {
			String FullName="TÃ i khoáº£n";
			request.setAttribute("fullname", FullName);
		}
	}
	
	
	public void all(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		String email=CookieUtils.get("email", request);
		System.out.println("email"+email);
		if(!email.equals("")) {
			User u=this.userDao.findByEmail(email);
			String FullName=u.getFullname();
			request.setAttribute("fullname", FullName);
		}else {
			String FullName="Tài Khoản";
			request.setAttribute("fullname", FullName);
		}
	}
	
	
	
	
	private void editprofile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		all(request, response);
		String email=CookieUtils.get("email", request);
		User u=this.userDao.findByEmail(email);
		String FullName=u.getFullname();
		String password=u.getPassword();
		String email1=u.getEmail();
		request.setAttribute("fullname", FullName);
		request.setAttribute("password", password);
		request.setAttribute("email", email1);
		request.setAttribute("view", "/views/editprofile.jsp");
		request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
	}
	
	public void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String email=CookieUtils.get("email", request);
		String password=CookieUtils.get("password", request);
		if(email!=null&&password!=null) {
			email=null;
			password=null;
			CookieUtils.add("email", email, 0, response);
			CookieUtils.add("password", password, 0, response);
		}
		
		response.sendRedirect("/SOF3011/admin/users/index");
//		request.setAttribute("email", email);
//		request.setAttribute("password", password);
		
	}
	
	private void changpassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		all(request, response);
		request.setAttribute("view", "/views/changpass.jsp");
		request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
	}
	
	private void forgotpassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		all(request, response);
		request.setAttribute("view", "/views/forgotpass.jsp");
		request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
	}
	
	private void favorites(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		all(request, response);
		//		List<Report>list=this.reportDAO.getInfor();
//		System.out.println("list:"+list);
//		String jpql = "select new Report(o.video.title, count(o.id), max(o.likeDate), min(o.likeDate)) from Favorite o group by o.video.title";
//		List<Report> report = (List<Report>) em.createQuery(jpql, Report.class).getResultList();
//		request.setAttribute("reports", report);
////		System.out.println("list"+list);
		List<Video>video=this.videoDAO.findAll();
		request.setAttribute("listVideo", video);
		
		String title=CookieUtils.get("title", request);
		if(title!=null) {
			List<User>list=this.userDao.favoriteUser(title);
			for (User user : list) {
				System.out.println(user.getEmail());
			}
			request.setAttribute("list", list);
		}
		
//		String cb=request.getParameter("title");
//		System.out.println("title:"+cb);
//		List<User>user=this.userDao.favoriteUser("");
		request.setAttribute("view", "/views/favorite.jsp");
		request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
	}
	
	private void createVideo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		all(request, response);
		request.setAttribute("view", "/views/createVideo.jsp");
		request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
	}
	private void removeVideo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		all(request, response);
		String idStr=request.getParameter("id");
		int id=Integer.valueOf(idStr);
		Video video=this.videoDAO.findById(id);
		this.videoDAO.delete(video);
		response.sendRedirect("/SOF3011/admin/users/viewVideo");
	}
	
	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		all(request, response);
		String idStr=request.getParameter("id");
		System.out.println(idStr);
		int id=Integer.valueOf(idStr);
		User user=this.userDao.findById(id);
		this.userDao.delete(user);
		response.sendRedirect("/SOF3011/admin/users/show");
//		request.setAttribute("view", "/views/index.jsp");
//		request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
	}
	
	private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		
		all(request, response);
		String email=CookieUtils.get("email", request);
		if(email.equals("")) {
			email=null;
			request.setAttribute("email", email);
		}
		System.out.println("email cookie:"+email);
		
		List<Video> list=this.videoDAO.findAll();
		request.setAttribute("listVideo", list);
		request.setAttribute("view", "/views/index.jsp");
		request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
	}
	
	private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		all(request, response);
		
		
		String idStr=request.getParameter("id");
		int id=Integer.valueOf(idStr);
		System.out.println(id+"---");
		String email=CookieUtils.get("email", request);
		User idUser=this.userDao.findByEmail(email);
		Video list=this.videoDAO.findById(id);
		request.setAttribute("listVideo", list);
		if(idUser!=null) {
			request.setAttribute("fullname", idUser.getFullname());
			request.setAttribute("UserId", idUser.getId());
			List<Comment>listComment=this.commentDao.commentById(idUser.getId(),list.getId());
			
			request.setAttribute("listComment", listComment);
		}
		
	
		
		
		
		request.setAttribute("view", "/views/detail.jsp");
		request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
	}
	
	
	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		all(request, response);
		String email=CookieUtils.get("email", request);
		String password=CookieUtils.get("password", request);
		request.setAttribute("view", "/views/login.jsp");
		request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
	}
	
	private void show(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		all(request, response);
		List<User> list=this.userDao.findAll();
		request.setAttribute("listUser", list);
		request.setAttribute("view", "/views/show.jsp");
		request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
	}
	private void showVideo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		all(request, response);
		List<Video> list=this.videoDAO.findAll();
		request.setAttribute("listVideo", list);
		request.setAttribute("view", "/views/showVideo.jsp");
		request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
	}
	
//	private void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setAttribute("view", "/views/register.jsp");
//		request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
//	}
//	
	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		all(request, response);
		String idStr=request.getParameter("id");
		int id=Integer.valueOf(idStr);
		User user=this.userDao.findById(id);
		request.setAttribute("user", user);
		request.setAttribute("view", "/views/edit.jsp");
		request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
	}
	
	private void editVideo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		all(request, response);
		String idStr=request.getParameter("id");
		int id=Integer.valueOf(idStr);
		System.out.println(idStr);
		Video video=this.videoDAO.findById(id);
		request.setAttribute("video", video);
		request.setAttribute("view", "/views/editVideo.jsp");
		request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
	}
	
	private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		all(request, response);
		request.setAttribute("view", "/views/registerAdmin.jsp");
		request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri=request.getRequestURI();
		if(uri.contains("create")) {
			User u = new User();
			try {
				BeanUtils.populate(u, request.getParameterMap());
				u = this.userDao.insert(u);
			} catch (Exception e) {
				e.printStackTrace();
			}
			response.sendRedirect(request.getContextPath()+"/admin/users/show");
		}else if(uri.contains("login")) {
			String email=request.getParameter("email");
			String password=request.getParameter("password");
//			String remember=request.getParameter("remember");
			
			User user=this.userDao.login(email, password);
			if(user==null) {
				doGet(request, response);
			}else {
				int hours=(email==null)?0:30*24;
				CookieUtils.add("email", email, hours, response);
				CookieUtils.add("password", email, hours, response);
				request.setAttribute("email", email);
				request.setAttribute("password", password);
				
			}
			
			response.sendRedirect("/SOF3011/admin/users/index");
		}else if(uri.contains("edit")) {
			
			User u=new User();
			try {
				BeanUtils.populate(u, request.getParameterMap());
				this.userDao.update(u);
			} catch (Exception e) {
				e.printStackTrace();
			}
			response.sendRedirect("/SOF3011/admin/users/show");
		}else if(uri.contains("insertVideo")) {
			File dir=new File(request.getServletContext().getRealPath("/files"));
			if(!dir.exists()) {
				dir.mkdir();
			}
			
			Part photo=request.getPart("poster");
			File photoFile=new File(dir,photo.getSubmittedFileName());
			photo.write(photoFile.getAbsolutePath());
			Video vd=new Video();
			try {
				BeanUtils.populate(vd, request.getParameterMap());
				vd.setPoster(photo.getSubmittedFileName());
				vd=this.videoDAO.insert(vd);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			response.sendRedirect("/SOF3011/admin/users/viewVideo");
		}else if(uri.contains("updateVideo")) {
			File dir=new File(request.getServletContext().getRealPath("/files"));
			if(!dir.exists()) {
				dir.mkdir();
			}
			
			
			
			Part photo=request.getPart("poster");
			System.out.println("name:"+photo.getSubmittedFileName());
			System.out.println("Photo="+photo);
			if(photo.getSubmittedFileName()!=null) {
				File photoFile=new File(dir,photo.getSubmittedFileName());
				photo.write(photoFile.getAbsolutePath());
			}
			
			
			Video vd=new Video();
			try {
				BeanUtils.populate(vd, request.getParameterMap());
				System.out.println(vd.getPoster());
				System.out.println(vd.getLinks());
				System.out.println(vd.getTitle());
				System.out.println(vd.getViews());
				System.out.println(vd.getActive());
				System.out.println(vd.getDescription());
				
				if(photo.getSubmittedFileName()!=null) {
					vd.setPoster(photo.getSubmittedFileName());
				}
				
				this.videoDAO.update(vd);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			response.sendRedirect("/SOF3011/admin/users/viewVideo");
		}else if(uri.contains("changpassword")) {			
			User user=new User();
			String email=request.getParameter("email");
			String fullname=request.getParameter("fullname");
			User u=this.userDao.changPassword(email, fullname);
			try {
				BeanUtils.populate(user, request.getParameterMap());
				if(u!=null) {
					u.setPassword(user.getPassword());
					this.userDao.update(u);
				}else {
					System.out.println("sai");
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			response.sendRedirect("/SOF3011/admin/users/index");
		}else if(uri.contains("updateUser")) {
			User user=new User();
			String email=CookieUtils.get("email", request);
			User u=this.userDao.findByEmail(email);
			int id=u.getId();
			try {
				user.setId(id);
				BeanUtils.populate(user, request.getParameterMap());
				this.userDao.update(user);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}else if(uri.contains("favorites")) {
//			String title=request.getParameter("title");
//			System.out.println("title:"+title);
//			
//			CookieUtils.add1(title, 10, response);
//			request.setAttribute("title", title);
//			
//			response.sendRedirect(request.getContextPath()+"/admin/users/favorites");
		}else  if(uri.contains("comment")) {
		
		String IdvideoStr=request.getParameter("Idvideo");
		int idVideo=Integer.valueOf(IdvideoStr);
		
		String idUserStr=request.getParameter("favorite");
		int idUser=Integer.valueOf(idUserStr);
		
		
		String comment=request.getParameter("comment");
		Comment comments=new Comment();
		List<User>list=this.userDao.findAll();
		List<Video>listVd=this.videoDAO.findAll();
		try {
			
			
			for (Video video2 : listVd) {
				if(video2.getId()==idVideo) {
					comments.setVideoId(video2);
				}
			}
			
			for (User u : list) {
				if(u.getId()==idUser) {
					comments.setUserId(u);
				}
			}
		
			comments.setCommentContent(comment);
			
			comments.setCommentDate(new Date());

	
			comments=this.commentDao.insert(comments);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
			
		response.sendRedirect("/SOF3011/admin/users/detail?id="+idVideo);

			
			
		}
	}
}
