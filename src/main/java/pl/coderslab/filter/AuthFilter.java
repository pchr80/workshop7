package pl.coderslab.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;

@WebFilter(filterName = "AuthFilter", urlPatterns = {"/tweet/*", "/comment/*"}) // "/user/*"
public class AuthFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpSession session = request.getSession();
        if (session.getAttribute("login") == null) {
            HttpServletResponse response = (HttpServletResponse) resp;
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED,
                    "You are not authorized to access this page");
                request.getHeaderNames();

            for (Enumeration<String> e = request.getHeaderNames(); e.hasMoreElements();)
                System.out.println(e.nextElement());
            System.out.println("__________");
            System.out.println("getPathInfo(): " + request.getPathInfo());
            System.out.println("getPathTranslated(): " + request.getPathTranslated());
            System.out.println("getServletPath(): " + request.getServletPath());
            System.out.println("getContextPath(): " + request.getContextPath());

//            response.sendRedirect("/");
        } else {
            chain.doFilter(req, resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
