package com.nutztest;

import javax.sql.DataSource;

import org.nutz.dao.Dao;
import org.nutz.dao.impl.DaoRunner;
import org.nutz.dao.impl.NutDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

@Configuration
public class NutzConfig {

  @Bean
  public ServletRegistrationBean druidServlet() {
    return new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
  }

  @Bean
  public FilterRegistrationBean filterRegistrationBean() {
    FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
    filterRegistrationBean.setFilter(new WebStatFilter());
    filterRegistrationBean.addUrlPatterns("/*");
    filterRegistrationBean.addInitParameter("exclusions",
        "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
    return filterRegistrationBean;
  }

  @Bean
  Dao nutDao(@Autowired DataSource dataSource) {
    DaoRunner runner = new org.nutz.integration.spring.SpringDaoRunner();
    NutDao nutDao = new NutDao(dataSource);
    nutDao.setRunner(runner);
    return nutDao;
  }
}
