package com.blueyonder.FS20CrudOperations;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class FS20CrudOperationsApplication {

	private static final Logger logger = LoggerFactory.getLogger(FS20CrudOperationsApplication.class);

	public static void main(String[] args) {
		log.info("[INFO] Started");
		SpringApplication.run(FS20CrudOperationsApplication.class, args);
		log.info("[INFO] Ended");
		log.error("[ERROR] This is an error.");
		log.debug("[DEBUG] This is for debugging.");
	}
}
