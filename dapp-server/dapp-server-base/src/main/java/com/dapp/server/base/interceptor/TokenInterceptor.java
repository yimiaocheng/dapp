package com.dapp.server.base.interceptor;

import com.dapp.commom.constants.BaseConstants;
import com.dapp.commom.dto.UserSessionDto;
import com.dapp.commom.utils.redis.RedisUtils;
import com.dapp.commom.utils.session.SessionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Enumeration;

public class TokenInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    private RedisUtils redisUtils;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            UserSessionDto sessionDto = SessionUtils.getSession(request.getSession());
            if (sessionDto == null || sessionDto.getUserId() == null) {//用户未登陆
                //从请求的header中获取token
                Enumeration e = request.getHeaders("X-Requested-Token");
                String token = "";
                while (e.hasMoreElements()) {
                    token = (String) e.nextElement();
                }

                Enumeration ce = request.getHeaders("X-Requested-Clientid");
                String clientid = "";
                while (ce.hasMoreElements()) {
                    clientid = (String) ce.nextElement();
                }

                //判断是否有token
                if (StringUtils.isNotBlank(token)) {
                    sessionDto = (UserSessionDto) redisUtils.getValue(BaseConstants.LOGIN_USER_REDIS_KEY + token);
                    if (sessionDto != null && sessionDto.getClientid().equals(clientid)) {
                        SessionUtils.setSession(request.getSession(), sessionDto);
                    }
                }
            }
        }
        return super.preHandle(request, response, handler);
    }

    /**
     *改变跨域请求的respone请求头
     * @param request
     * @param response
     */
    private void checkXRequest(HttpServletRequest request, HttpServletResponse response){
        String XRequested =request.getHeader("X-Requested-With");
        if(XRequested != null && "XMLHttpRequest".equals(XRequested)){
            response.addHeader("Access-Control-Allow-Credentials", "true");
            response.addHeader("Access-Control-Allow-Origin", "*");
            response.addHeader("Content-Type", "application/json;charset=UTF-8");
            response.addHeader("Date", new Date().toString());
            response.addHeader("Transfer-Encoding", "chunked");
            response.addHeader("Vary", "Origin");
        }
    }
}
