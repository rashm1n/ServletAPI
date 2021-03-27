package com.rashm1n.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Date;

@WebFilter("/*")
public class LoggingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String path = request.getServletPath();
        String remoteAddr = request.getRemoteAddr();
        String logText = "path: "+path+" addr: "+remoteAddr+" timestamp: "+new Date().getTime()+" \n";
        try {
            Files.write(Paths.get("/home/rashmin/Documents/log1.txt"), logText.getBytes(), StandardOpenOption.APPEND);
        }catch (IOException e) {
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
