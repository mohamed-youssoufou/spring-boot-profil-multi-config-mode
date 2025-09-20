package fr.demo.youssoufou.ack;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AckApplication {
	private static final Logger log = LoggerFactory.getLogger(AckApplication.class);

	@Value("${profil}")
	String env;

	public static void main(String[] args) {
		var rs = SpringApplication.run(AckApplication.class, args);
	}

	@PostConstruct
	public void test(){
		log.info(env);
	}

}
