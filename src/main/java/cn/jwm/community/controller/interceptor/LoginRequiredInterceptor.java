package cn.jwm.community.controller.interceptor;

import cn.jwm.community.annotation.LoginRequired;
import cn.jwm.community.util.HostHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

@Component
public class LoginRequiredInterceptor implements HandlerInterceptor {

    @Autowired
    private HostHolder hostHolder;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {// handler是拦截到的东西，可以是类,方法，静态资源
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            LoginRequired loginRequired = method.getAnnotation(LoginRequired.class);// 反射，尝试取自定义的拦截注解
            if (loginRequired != null && hostHolder.getUser() == null) {// 获取到了注解表明该方法需要拦截
                response.sendRedirect(request.getContextPath() + "/login");//方法是继承接口，不能随便return”模板“，用response重定向到登录页面
                return false;
            }
        }
        return true;
    }
}
