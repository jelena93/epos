package filters;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import util.Util;

@WebFilter(filterName = "LoginFilter", urlPatterns = {"/*"})
public class LoginFilter implements Filter {

    private ServletContext context;

    @Override
    public void init(FilterConfig fConfig) throws ServletException {
        this.context = fConfig.getServletContext();
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String uri = req.getRequestURI();
        System.out.println("uri" + uri);
        HttpSession session = req.getSession(false);
        if (uri.endsWith("odjava")) {
            session.invalidate();
            res.sendRedirect(context.getContextPath() + "/prijava.jsp");
            return;
        }
        if (uri.contains("action") && session.getAttribute(Util.ULOGOVAN) == null && !uri.endsWith("prijava")) {
            res.sendRedirect(context.getContextPath() + "/prijava.jsp");
            return;
        }
        if (session == null && !(uri.endsWith("jsp") || uri.endsWith("FrontController"))) {
            res.sendRedirect(context.getContextPath() + "/prijava.jsp");
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
        //close any resources here
    }
}
