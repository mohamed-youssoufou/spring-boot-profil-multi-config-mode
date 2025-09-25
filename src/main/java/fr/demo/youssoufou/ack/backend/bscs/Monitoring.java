package fr.demo.youssoufou.ack.backend.bscs;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component("customapi") // name will appear in /actuator/health
public class Monitoring implements HealthIndicator {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String apiUrl = "http://localhost:8888/health";

    @Override
    public Health health() {
        try {
            String response = restTemplate.getForObject(apiUrl, String.class);
            if ("OK".equalsIgnoreCase(response)) {
                return Health.up().withDetail("API Status", "Available").build();
            } else {
                return Health.down().withDetail("API Status", response).build();
            }
        } catch (Exception e) {
            return Health.down(e).withDetail("API Status", "Unavailable").build();
        }
    }
}
