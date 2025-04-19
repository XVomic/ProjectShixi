package com.hd.config;

import com.hd.convert.DateFormatter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final DateFormatter dateFormatter;

    public WebConfig(DateFormatter dateFormatter) {
        this.dateFormatter = dateFormatter;
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(dateFormatter);
    }
}