package com.fitness.interceptor;

import com.alibaba.fastjson.JSON;
import com.fitness.annotations.OathAnnotation;
import com.fitness.api.domain.Oath;
import com.fitness.constant.Constant;
import com.fitness.result.BaseResult;
import com.fitness.util.OathUtil;
import com.mysql.jdbc.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created on 2017/7/1.
 */
public class FitnessInterceptor extends HandlerInterceptorAdapter {

    /**
     * redis缓存操作
     */
    @Autowired
    private RedisTemplate redisTemplate;

    private static final Logger LOGGER = LoggerFactory.getLogger(FitnessInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        LOGGER.info("请求拦截:-------------------");
        if (handler instanceof HandlerMethod) {
//            response.setContentType("application/json;charset=UTF-8");
//            response.setHeader("Access-Control-Allow-Origin", "*");
//            response.setHeader("Access-Control-Allow-Methods", "POST,GET,OPTIONS,DELETE");
//            response.setHeader("Access-Control-Max-Age", "3600");
//            response.addHeader("Access-Control-Allow-Headers",
//                    "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
            HandlerMethod handlerMethod = (HandlerMethod) handler;

            /**
             * 接口访问权限   放行
             */
            OathAnnotation oath = handlerMethod.getMethodAnnotation(OathAnnotation.class);
            if (null == oath) {
                LOGGER.debug("请求返回------>>");
                return true;
            }
            //获取请求头部 oath
            String oathStr = request.getHeader("oath");

            //授权失败
            if (null == oathStr) {
                response.getWriter().write(JSON.toJSONString(BaseResult.oathError()));
                return false;
            }

            //授权失败
            String decryptOath = OathUtil.aesDecrypt(oathStr, Constant.OATH_KEY);
            Oath oathObj = JSON.parseObject(decryptOath, Oath.class);
            if (null == oathObj) {
                response.getWriter().write(JSON.toJSONString(BaseResult.oathError()));
                return false;
            }
            ValueOperations valueOperations = redisTemplate.opsForValue();

            //读取缓存信息
            String loginContent = (String) valueOperations.get(Constant.ON_LINE + oathObj.getMember().getPhone());

            //授权超时
            if (StringUtils.isNullOrEmpty(loginContent)) {
                response.getWriter().write(JSON.toJSONString(BaseResult.oathTimeout()));
                return false;
            }


        }
        return super.preHandle(request, response, handler);
    }
}
