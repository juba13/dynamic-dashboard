package com.juba13.dyboard.interceptor;

import com.juba13.dyboard.Config;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component(value = "coreAuthInterceptor")
public class AuthInterceptor extends HandlerInterceptorAdapter {
    
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if("OPTIONS".equalsIgnoreCase(request.getMethod())){
            response.setStatus(response.SC_OK);
            return true;
        }
        else {
            try {
                final Claims claims = Jwts.parser().setSigningKey(Config.JWT_PRIVATE_KEY).parseClaimsJws(request.getHeader(Config.KEY.TOKEN)).getBody();
                request.setAttribute(Config.KEY.SESSION_ID,claims.getId());
                request.setAttribute(Config.KEY.USER_ID,claims.getIssuer());
                request.setAttribute(Config.KEY.ORG_ID,claims.getAudience());
                return true;
            } catch (Exception e) {
              
            }
            response.setStatus(response.SC_UNAUTHORIZED);
            return false;
        }
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
            throws Exception {
        System.out.println("this is interceptor, postHandle method");
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("this is interceptor, afterCompletion method");
    }
    
}
