package filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginFilter implements Filter {
    final String USERNAME = "user";
    final String PASSWORD = "pass";

    public void init(FilterConfig filterConfig) {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String name = request.getParameter("name");
        String password = request.getParameter("pass");

        if (name.equals(USERNAME) && password.equals(PASSWORD)) {
            chain.doFilter(request, response);
        } else {
            HttpServletResponse httpServletResponse = (HttpServletResponse)response;
            httpServletResponse.sendRedirect("/html/login.html");
        }
    }

    public void destroy() {
    }
}
