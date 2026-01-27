package br.comaprendizado.modulo_04.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class TestLogController {

    private Logger logger = LoggerFactory.getLogger(TestLogController.class.getName());

    @GetMapping("/test-log")
    public String testLog() {
        logger.debug("This is a debug log message.");
        logger.info("This is an info log message.");
        logger.warn("This is a warning log message.");
        logger.error("This is an error log message.");
        return "Log test successful";
    }
    @GetMapping("/teste")
    public String testLogg() {
        logger.info("Request received on /test-log");

        try {
            logger.debug("Starting business logic");
            String result = "Log test successful";
            logger.debug("Business logic finished successfully");

            return result;
        } catch (Exception e) {
            logger.error("Error while processing /test-log", e);
            throw e;
        }
    }

}
