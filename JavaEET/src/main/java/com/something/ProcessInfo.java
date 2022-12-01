package com.something;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest; // to provide client request info to a servlet
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;


/**
 * Servlet implementation class ProcessInfo
 */
public class ProcessInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcessInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String url = "/DisplayInfo.jsp";
		// Get info from the index jsp 
		String fName = request.getParameter("fname");
		String lName = request.getParameter("lname");
		String phone = request.getParameter("phone");
		//put the fields into MySQL
		updateDB(fName, lName, phone);
		Customer cust = new Customer(fName, lName, phone);
		// pass entire object, passing Customer in our situation
		request.setAttribute("cust", cust);
		getServletContext().getRequestDispatcher(url).forward(request, response);
		
	}
	
	protected void updateDB(String fName, String lName, String phone) {
		Connection con;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost/test1";
			String user = "dbadmin";
			String pw = "turtledove";
			//issue queries into the database
			con = DriverManager.getConnection(url,user,pw);
			//send queries to the database
			Statement  s =  con.createStatement();
			String query = "INSERT INTO CUSTOMER " + "(first_name, last_name, phone, cust_id) " + "VALUES ('" + fName + "', '" + lName + "', '" + phone + "', NULL)";
			s.executeUpdate(query);
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	

}
