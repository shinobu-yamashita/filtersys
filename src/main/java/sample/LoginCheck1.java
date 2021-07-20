package sample;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import sample.Beans.AccountsBeans;

public class LoginCheck1 extends HttpServlet {

	protected Connection conn = null;

    public void init() throws ServletException{

    	System.out.print("【LoginCheck1】init\n");

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

    	System.out.print("【LoginCheck1】destory\n");
    	try{
		    if (conn != null){
		        conn.close();
		    }
		}catch (SQLException e){
		    log("SQLException:" + e.getMessage());
		}
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{

    	System.out.print("【LoginCheck1】doPost\n");

        response.setContentType("text/html; charset=Shift_JIS");
        //PrintWriter out = response.getWriter();

		String user = request.getParameter("user_id");
		String pass = request.getParameter("password");

        HttpSession session = request.getSession(true);

        boolean check = authUser(user, pass, session);
        if (check){
            /* 認証済みにセット */
            session.setAttribute("login", "OK");

            /* 認証成功後は必ずMonthViewサーブレットを呼びだす */
            response.sendRedirect("/filtersys/menu");
        }else{
            /* 認証に失敗したら、ログイン画面に戻す */
            session.setAttribute("status", "Not Auth");
            response.sendRedirect("/filtersys/logon");
        }
    }

    protected boolean authUser(String user, String pass, HttpSession session){

    	System.out.print("【LoginCheck1】authUser\n");

    	boolean ret = false;
		AccountsBeans accounts = new AccountsBeans();

		//エラーメッセージを初期化
		String messege =  "ユーザーIDまたはパスワードが違います";


		session.setAttribute("user_id", user);
		
		if (user == null || user.length() == 0 || pass == null || pass.length() == 0){
        }
    	else {

    		try {
       
    			String sql = "Select * from accounts where userid = ? and active = ? ";

                PreparedStatement pstmt = conn.prepareStatement(sql);

                pstmt.setString(1, user);
                pstmt.setString(2, "1" );
                ResultSet rs = pstmt.executeQuery();


    			//該当USER情報が存在するか
    			if(rs.next()) {
    				//該当あり
    				
    				accounts.setUserid(rs.getString("userid"));
    				accounts.setPasswd(rs.getString("passwd"));
    				accounts.setUsernm(rs.getString("usernm"));
    				accounts.setUserac(rs.getString("userac"));
    				accounts.setMenunm(rs.getString("menunm"));
    				accounts.setActive(rs.getString("active"));

    				//PASSWORDが一致するか
    				if(accounts.getPasswd().equals(pass)) {
    					//PASSWORDが一致
    					
    					messege = "";


    					ret = true;

    				}

    			}

            }
//            catch(NamingException ex) {
//    			// の呼び出しで、この例外が発生する可能性があります。
//    			log("NamingException:" + ex.getMessage());
//                return false;
//    		}
    		catch(SQLException ex) {
    			//ds. で、この例外が発生する可能性があります。
    			log("SQLException:" + ex.getMessage());

    			accounts = new AccountsBeans();
				messege = "SQLException:" + ex.getMessage();

    		}
    		
    	}
    	
		session.setAttribute("password", accounts.getPasswd());
		session.setAttribute("username", accounts.getUsernm());
		session.setAttribute("menuname", accounts.getMenunm());
		session.setAttribute("message", messege);

		return ret;
    
    }
}