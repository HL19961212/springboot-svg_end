package com.kuang.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 自定义自动配置类：
 * 1. 加上@Configuration注解
 * 2. 实现webmvcconfigurer接口
 * 可以对springboot不包含的组件，进行创建，一般自定义工具的话，需要实现某个接口，重写方法，然后最后@bean创建对象即可
 * 还有的是重写springboot中的方法，实现创建对象
 */
@Configuration
public class MyAutoConfig implements WebMvcConfigurer {
    //视图跳转：实质上就是创建了一个controller，然后专门接收fvcom请求，然后转发到test页面
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/fvcom").setViewName("test");
        registry.addViewController("/fvcom1").setViewName("index");registry.addViewController("/echart_test").setViewName("echart_test");
        registry.addViewController("/echarts").setViewName("echarts");
        registry.addViewController("/heatmap").setViewName("heatmap-cartesian");
        registry.addViewController("/cluster").setViewName("cluster");
        registry.addViewController("/head").setViewName("head");
        registry.addViewController("/left").setViewName("left");
        registry.addViewController("/main").setViewName("main");
        registry.addViewController("/test").setViewName("Join");
        registry.addViewController("/main_test").setViewName("main_test");
        registry.addViewController("/heatmap_test").setViewName("heatmap_test");
        registry.addViewController("/index_tree").setViewName("index_tree");
        registry.addViewController("/fvcom2").setViewName("index_test");
        registry.addViewController("/petri").setViewName("petri_net");
    }

}
