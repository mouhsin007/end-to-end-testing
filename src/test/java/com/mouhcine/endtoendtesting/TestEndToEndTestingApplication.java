package com.mouhcine.endtoendtesting;

import org.springframework.boot.SpringApplication;

public class TestEndToEndTestingApplication {

    public static void main(String[] args) {
        SpringApplication.from(EndToEndTestingApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
