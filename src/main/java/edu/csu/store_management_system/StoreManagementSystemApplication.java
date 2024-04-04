package edu.csu.store_management_system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("edu.csu.store_management_system.mapper")
public class StoreManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(StoreManagementSystemApplication.class, args);
    }

}
