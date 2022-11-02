package pl.nw.hehexd.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class JwtFilter implements javax.servlet.Filter {


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        String header = httpServletRequest.getHeader("authorization");

        if(httpServletRequest == null || !header.startsWith("Bearer ")) {
            throw new ServletException("Wrong or empty header");
        } else {
            try {
                String token = header.substring(7);
                Claims claims = Jwts.parser().setSigningKey("hehe").parseClaimsJws(token).getBody();
                servletRequest.setAttribute("claims", claims);
            } catch (Exception e){
                throw new ServletException("Wrong password");
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
