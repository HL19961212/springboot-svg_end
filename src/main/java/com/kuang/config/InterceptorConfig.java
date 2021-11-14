package com.kuang.config;

import com.kuang.interceptor.AuthInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {


    @Bean
    public AuthInterceptor authInterceptor() {
        return new AuthInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List<String> patterns = new ArrayList();
        patterns.add("/webjars/**");
        patterns.add("/druid/**");
        patterns.add("/sys/login");
        patterns.add("/swagger/**");
        patterns.add("/v2/api-docs");
        patterns.add("/swagger-ui.html");
        patterns.add("/swagger-resources/**");
        patterns.add("/login");
        patterns.add("/svg2");
        patterns.add("/pdf");
        patterns.add("/svg1");
        patterns.add("/table2-1");
        patterns.add("/table2-2");
        patterns.add("/table2-1/**");
        patterns.add("/table2-139/**");
        patterns.add("/table2-149/**");
        patterns.add("/table2-150/**");
        patterns.add("/table2-152/**");
        patterns.add("/deleteSelector");
        patterns.add("/table2-139");
        patterns.add("/table2-149");
        patterns.add("/table2-150");
        patterns.add("/table2-152");
        patterns.add("/table139_add");
        patterns.add("/table149_add");
        patterns.add("/table150_add");
        patterns.add("/table152_add");
        patterns.add("/table_139_add");
        patterns.add("/table_149_add");
        patterns.add("/table_150_add");
        patterns.add("/table_152_add");
        patterns.add("/table2-139/**");
        patterns.add("/deleteSelector139");


        patterns.add("/cluster");
        patterns.add("/table2-pj");
        patterns.add("/id_1");
        patterns.add("/id_2");
        patterns.add("/id_3");
        patterns.add("/id_4");
        patterns.add("/id_5");
        patterns.add("/petri");
        patterns.add("/pattern");
        patterns.add("/pattern_add");
        patterns.add("/patterninsert");
        patterns.add("/software");
        patterns.add("/software_add");
        patterns.add("/softinsert");
        patterns.add("/userdata");
        patterns.add("/userdata_add");
        patterns.add("/userinsert");
        patterns.add("/fvcom2");
        patterns.add("/optimization");
        patterns.add("/heatmap_test");
        patterns.add("/index11");
        patterns.add("/oceanlogin");
        patterns.add("/oceanuserinsert");
        patterns.add("/zhibiaoinsert");
        //patterns.add("/table2-pj/**");
        patterns.add("/signup");
        patterns.add("/static/**");

        //patterns.add("/table2-1");
        patterns.add("/css/**");
        patterns.add("/js/**");
        registry.addInterceptor(authInterceptor()).addPathPatterns("/**").excludePathPatterns(patterns);
    }
}

