package controller;
import model.Blog;
import model.User;
import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet(urlPatterns= {"/blog"})
public class BlogController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public BlogController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/blogView.jsp");
		rd.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String blogDetails = request.getParameter("selectedAnswers");
		String blogData[] = blogDetails.split(",");
		String title = blogData[0];
		String description = blogData[1];
		LocalDate date = LocalDate.now(); 
		
		Blog blog = new Blog(title, description, date);
		blog.setTitle(title);
		blog.setDescription(description);
		blog.setPostedOn(date);
		
		System.out.println("Blog Title: "+title);
        System.out.println(" Blog Description: "+description);
        System.out.println("Posted on: "+date); 
         
		if(blog!=null) {
			request.setAttribute("blog", blog);
			User user = null;
			request.setAttribute("user", user);
			RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/blogView.jsp");
			rd.forward(request, response);
		}
		
	}

}
