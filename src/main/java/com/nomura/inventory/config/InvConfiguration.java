package com.nomura.inventory.config;

import com.nomura.inventory.filter.InvCORSFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InvConfiguration {

    @Bean
    public FilterRegistrationBean<InvCORSFilter> defaultFilter(){
        FilterRegistrationBean<InvCORSFilter> registrationBean
                = new FilterRegistrationBean<>();
        registrationBean.setFilter(new InvCORSFilter());
        registrationBean.addUrlPatterns("/*");
        registrationBean.setOrder(2);
        return registrationBean;
    }



}
