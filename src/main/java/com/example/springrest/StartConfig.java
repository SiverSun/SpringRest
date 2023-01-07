package com.example.springrest;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.io.IOException;

import static java.lang.String.format;

@Configuration
@Profile("auto-start")
public class StartConfig {

    @Bean
    Process startPageRest(@Value("${start.command}") String command,
                          @Value("${start.url}") String url) throws IOException {
        Runtime runtime = Runtime.getRuntime();
        return runtime.exec(format("%s %s", command, url));
    }
}
