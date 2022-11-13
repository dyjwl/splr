package com.mm.splr.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;


@EnableSwagger2
@Configuration
public class Swagger2Config implements WebMvcConfigurer {
    private static ApiInfo DEFAULT = null;
    @Bean//创建swagger实例
    public Docket docket(Environment environment){
        Contact DEFAULT_CONTACT = new Contact("zhaojunwei", "http://www.baidu.com", "344604924@qq.com");
        DEFAULT = new ApiInfo("系统的后端接口",
                "Api Documentation",
                "V1.0",
                "http://www.baidu.com",
                DEFAULT_CONTACT,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
        Profiles profiles = Profiles.of("dev");//设置在那个环境下显示swagger
        boolean b = environment.acceptsProfiles(profiles);//获得项目的环境
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(DEFAULT)
                .enable(b)//配置swagger是否开启，如果为false则关闭swagger，默认为true
                .select()
                .build();
    }
}

