package sample;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import sample.Beans.MenuBeans;

/**
 * Servlet implementation class menuServlet
 */
public class menuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public menuServlet() {
        super();
    }

	protected Connection conn = null;

    public void init() throws ServletException{

    	System.out.print("【menuServlet】init\n");

    	String jndi_url = "java:comp/env/jdbc/sample";

		try {
			Context ctx = new javax.naming.InitialContext();
			DataSource ds = (DataSource)ctx.lookup(jndi_url);
			conn = ds.getConnection();
			//Connection conn = ds.getConnection();
		}
		catch(NamingException ex) {
			// の呼び出しで、この例外が発生する可能性があります。
			log("NamingException:" + ex.getMessage());
			throw new ServletException("DB接続に失敗しました");
		}
		catch(SQLException ex) {
			//ds. で、この例外が発生する可能性があります。
			log("SQLException:" + ex.getMessage());
			throw new ServletException("SQLエラー");
		}

    }

    public void destory(){

    	System.out.print("【menuServlet】destory\n");
    	try{
		    if (conn != null){
		        conn.close();
		    }
		}catch (SQLException e){
		    log("SQLException:" + e.getMessage());
		}
    }
    
    
    
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String forward = null;

        HttpSession session = request.getSession(true);
		String menunm = (String) session.getAttribute("menuname");

        ArrayList<MenuBeans> lst = new ArrayList<MenuBeans>();
		
		try {

			String sql = "Select * from menu where menunm = ? and active = ? order by menuix" ;
			
	        PreparedStatement pstmt = conn.prepareStatement(sql);

	        pstmt.setString(1, menunm);
	        pstmt.setString(2, "1" );
	        ResultSet rs = pstmt.executeQuery();

	        lst =  new ArrayList<MenuBeans>();
	        
	        while(rs.next()) {
	        	MenuBeans menu = new MenuBeans();
	        	
	        	menu.setMenunm(rs.getString("menunm"));
	        	menu.setMenuix(rs.getInt("menuix"));
	        	menu.setMenunn(rs.getString("menunn"));
	        	menu.setMenumm(rs.getString("menumm"));
	        	menu.setActive(rs.getString("active"));
	        	

	        	lst.add(menu);
	        }
			
		}
		catch(SQLException ex) {
			//ds. で、この例外が発生する可能性があります。
			log("SQLException:" + ex.getMessage());

//			accounts = new AccountsBeans();
//			messege = "SQLException:" + ex.getMessage();
		}
		

		request.setAttribute("menulist", lst);
		
		// menu.jspへフォワードする
		forward = "/JSP/menu.jsp";

		// JSPへのフォワード
		RequestDispatcher rd = request.getRequestDispatcher(forward);
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
