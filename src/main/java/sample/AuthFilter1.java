package sample;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class AuthFilter1 implements Filter{

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain){

    	System.out.print("【AuthFilter1】doFilter\n");

    	try{

            //String target = ((HttpServletRequest)request).getRequestURI();

            HttpSession session = ((HttpServletRequest)request).getSession();

            if (session == null){
                session = ((HttpServletRequest)request).getSession(true);

                ((HttpServletResponse)response).sendRedirect("/filtersys/logon");
            }else{
                Object loginCheck = session.getAttribute("login");
                if (loginCheck == null){
                    ((HttpServletResponse)response).sendRedirect("/filtersys/logon");
                }
            }
            
            
            chain.doFilter(request, response);

        }catch (ServletException se){
        }catch (IOException e){
        }catch (Exception ex) {
        	System.out.print("【AuthFilter1】exception\n");
        }

    }

    public void init(FilterConfig filterConfig) throws ServletException{
    }

    public void destroy(){
    }
}
