package com.javacourse.demo.autoconfigure;

import com.javacourse.demo.School;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(School.class)
public class DemoAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public School school() {
        return new School("Yale");
    }

}
