package com.dapp.commom.utils.session;

import com.dapp.commom.constants.BaseConstants;
import com.dapp.commom.dto.UserSessionDto;

import javax.servlet.http.HttpSession;

public class SessionUtils {



    public static UserSessionDto getSession(HttpSession session) {
        UserSessionDto user = null;
        if (null != session) {
            try {
                user = (UserSessionDto) session.getAttribute(BaseConstants.USER_LOGIN_SESSION);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return user;
    }

    public static void setSession(HttpSession session, UserSessionDto userSessionDto) {
        if (null != session) {
            try {
                session.setAttribute(BaseConstants.USER_LOGIN_SESSION, userSessionDto);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void removeSession(HttpSession session) {
        if (null != session) {
            try {
                session.removeAttribute(BaseConstants.USER_LOGIN_SESSION);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
