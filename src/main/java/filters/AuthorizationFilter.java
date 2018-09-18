package filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthorizationFilter implements Filter {
    public void init(FilterConfig filterConfig) {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpSession session = httpServletRequest.getSession();
        Boolean authorized = (Boolean) session.getAttribute("authorized");
        if (authorized != null) {
            if (authorized) {
                chain.doFilter(request, response);
            } else {
                HttpServletResponse httpServletResponse = (HttpServletResponse) response;
                httpServletResponse.sendRedirect("/view/login.html");
            }
        } else {
            session.setAttribute("authorized", "false");
            request.getRequestDispatcher("/view/login.html").forward(request, response);
        }
    }

    public void destroy() {
    }
}
