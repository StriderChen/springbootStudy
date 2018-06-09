package com.chenjie.springbootmybatis.druid;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author chenjie
 * @Date 2018/6/9 20:52
 * @Description:Druid的一个过滤器
 */
@Configuration
public class DruidConfiguration {

    @Value("${druid.username}")
    private String username;
    @Value("${druid.password}")
    private String password;
    @Value("${druid.resetEnable}")
    private String resetEnable;

    @Bean
    public ServletRegistrationBean statViewServlet() {
        //创建servlet注册实体类
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/");
        //设置ip白名单
        servletRegistrationBean.addInitParameter("allow", "127.0.0.1");
        //设置ip黑名单,如果allow和deny同时存在,则deny优先于allow
        servletRegistrationBean.addInitParameter("deny", "192.168.0.1");
        //druid管理页面的登录名密码
        servletRegistrationBean.addInitParameter("loginUsername", username);
        servletRegistrationBean.addInitParameter("loginPassword", password);
        //是否可以重置数据
        servletRegistrationBean.addInitParameter("resetEnable", resetEnable);
        return servletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean statFilter() {
        //创建一个过滤器
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
        //设置过滤器过滤路径
        filterRegistrationBean.addUrlPatterns("/");
        //设置过滤器忽略的形式
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }

}
