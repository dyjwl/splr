package com.mm.splr.config;


import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mm.splr.Filter.ConsumerTimerFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.text.SimpleDateFormat;
import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Bean
    public FilterRegistrationBean consumerLoginFilterRegistration() {
        FilterRegistrationBean<ConsumerTimerFilter> registration = new FilterRegistrationBean<>();
        registration.setFilter(new ConsumerTimerFilter());
        registration.addUrlPatterns("/*");
        registration.setName("consumerLoginFilter");
        registration.setOrder(2);
        return registration;
    }


    //定义时间格式转换器
    @Bean
    public MappingJackson2HttpMessageConverter jackson2HttpMessageConverter() {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        converter.setObjectMapper(mapper);
        return converter;
    }

    //添加转换器
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        //将我们定义的时间格式转换器添加到转换器列表中,
        //这样jackson格式化时候但凡遇到Date类型就会转换成我们定义的格式
        converters.add(jackson2HttpMessageConverter());
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 处理静态资源，例如图片、JS、CSS等
        registry.addResourceHandler("/images/**").addResourceLocations
                ("classpath:images/");
    }


    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/cors/**")
                .allowedHeaders("*")
                .allowedMethods("POST","GET","DELETE","PUT")
                .allowedOrigins("*");
        System.out.println("生效了麽");
    }

    /**
     * 配置日期格式化
     * @param registry
     */
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new DateFormatter("yyyy-MM-dd HH:mm:ss"));
    }

}
