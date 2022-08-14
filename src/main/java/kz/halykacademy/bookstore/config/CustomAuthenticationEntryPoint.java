package kz.halykacademy.bookstore.config;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class CustomAuthenticationEntryPoint extends BasicAuthenticationEntryPoint {
    public CustomAuthenticationEntryPoint() {
    }

    @Override
    public void commence(
            HttpServletRequest request, HttpServletResponse response, AuthenticationException authEx)
            throws IOException {
        PrintWriter writer = response.getWriter();
        if(authEx.getMessage().equals("Not found")){
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            writer.println("404 - username not found");
        } else {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            writer.println("403 - " + authEx.getMessage());
        }

    }

    @Override
    public void afterPropertiesSet() {
        setRealmName("Realm");
        super.afterPropertiesSet();
    }
}
