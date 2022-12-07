package project.ProjectManagement;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;

@Component
public class LogRequestFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;

        if(Arrays.asList("POST","PUT").contains(httpRequest.getMethod())){
            CustomHttpRequestWrapper requestWrapper = new CustomHttpRequestWrapper(httpRequest);
            filterChain.doFilter(requestWrapper, servletResponse);
            return;
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
