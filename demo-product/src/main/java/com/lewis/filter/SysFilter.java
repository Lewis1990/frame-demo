package com.lewis.filter;

import com.lewis.util.JsonUtil;
import io.micrometer.core.instrument.util.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebFilter(filterName = "sysFilter",urlPatterns = "/*")
public class SysFilter implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest r = (HttpServletRequest)req;
        String header = r.getHeader("FROM-GATEWAY-REQUEST");
        if(StringUtils.isBlank(header)){
            writeErr(res);
            return;
        }
        chain.doFilter(req, res);
    }

    private void writeErr(ServletResponse res){
        HttpServletResponse response = (HttpServletResponse) res;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");

        PrintWriter writer = null;

        Map<String,String> map = new HashMap<>();
        map.put("msg","不允许直接访问该服务");
        // 写为字节流
        try {
            writer = response.getWriter();
            writer.write(JsonUtil.obj2Str(map));
            writer.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(null != writer){
                writer.close();
            }
        }
    }
}
