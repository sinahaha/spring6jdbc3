package com.pluralsight.conference;

import com.pluralsight.conference.model.Speaker;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class Spring6jdbc3ApplicationTests {

    @SuppressWarnings("null")
	@Test
    void testGetSpeakers() {
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<List<Speaker>> speakersResponse = restTemplate.exchange(
                "http://localhost:8080/", HttpMethod.GET,
                null, new ParameterizedTypeReference<List<Speaker>>() {
                });

        assertTrue(speakersResponse.getBody() != null, "Body is null");

        List<Speaker> speakers = speakersResponse.getBody();

        for (Speaker speaker : speakers) {
            System.out.println("Speaker name: " + speaker.getName());
        }
    }
}
