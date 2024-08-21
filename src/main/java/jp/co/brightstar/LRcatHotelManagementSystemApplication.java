package jp.co.brightstar;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan
@SpringBootApplication
public class LRcatHotelManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(LRcatHotelManagementSystemApplication.class, args);
	}

}
