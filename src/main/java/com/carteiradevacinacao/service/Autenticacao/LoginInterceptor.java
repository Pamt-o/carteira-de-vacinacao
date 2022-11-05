package com.carteiradevacinacao.service.Autenticacao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.carteiradevacinacao.service.CookieService;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        if (CookieService.getCookie(request, "usuarioId") != null) {
            return true;
        }

        response.sendRedirect("/login");
        return false;

    }
}