

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.io.*;
/**
 * Servlet implementation class Book
 */
@WebServlet("/Book")
public class Book extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Book() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		out.println("<html>\n" + "<head><title>Database Result</title></head>" + "<h1 style=\"text-align:center;\"> Database Result </h1>");
		
		final String db_url = "jdbc:mysql://localhost:3306/book_proj";
		final String user_name = "root";
		final String password = "nerf";
		final String Query = "SELECT * FROM book;";
		
		out.println("<table style=\"border:1px solid black;margin:auto;\"><tr><th>ISBN</th><th>Title</th><th>Author</th><th>Price</th></tr>");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(db_url, user_name, password);
			
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(Query);
			while(rs.next()) {
				long isbn = rs.getLong("isbn");
				float price = rs.getFloat("price");
				String title = rs.getString("title");
				String author = rs.getString("author");
				
				out.println("<tr>");
				out.println("<td>" + isbn + "</td>");
				out.println("<td>" + title + "</td>");
				out.println("<td>" + author + "</td>");
				out.println("<td>" + price + "</td>");
				
				out.println("</tr");
			}
			out.println("</body></html>");
			
			rs.close();
			st.close();
			con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
