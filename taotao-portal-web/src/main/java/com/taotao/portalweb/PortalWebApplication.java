package com.taotao.portalweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class PortalWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(PortalWebApplication.class, args);
	}

}
