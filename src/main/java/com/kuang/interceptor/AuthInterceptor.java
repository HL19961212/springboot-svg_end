package com.kuang.interceptor;
import com.alibaba.fastjson.JSON;

import com.kuang.entity.OceanUser;
import com.kuang.service.OceanUserService;
import com.kuang.utils.HttpContextUtil;
import com.kuang.utils.Result;
import com.kuang.utils.TokenUtil;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

public class AuthInterceptor implements HandlerInterceptor {
    @Autowired
    private OceanUserService oceanUserService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        String token = TokenUtil.getRequestToken(request);
        if (StringUtils.isBlank(token)) {
            setReturn(response, 400, "用户未登录，请先登录");
            return false;
        }
        //1. 根据token，查询用户信息
        OceanUser user = oceanUserService.findByToken(token);
        //2. 若用户不存在,
        if (user == null) {
            setReturn(response, 400, "用户不存在");
            return false;
        }
        //3. token失效
        if (user.getExpireTime().isBefore(LocalDateTime.now())) {
            setReturn(response, 400, "用户登录凭证已失效，请重新登录");
            return false;
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

    }

    private static void setReturn(HttpServletResponse response, int status, String msg) throws IOException {
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.setHeader("Access-Control-Allow-Credentials", "true");
        httpResponse.setHeader("Access-Control-Allow-Origin", HttpContextUtil.getOrigin());
        httpResponse.setCharacterEncoding("UTF-8");
        httpResponse.setStatus(400);
        response.setContentType("application/json;charset=utf-8");
        Result build = Result.build(status, msg);
        String json = JSON.toJSONString(build);
        httpResponse.getWriter().print(json);
    }

}
