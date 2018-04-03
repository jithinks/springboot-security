package com.jks.startup.springbootsecurity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT, classes = SpringbootSecurityApplication.class)
public class SpringbootSecurityApplicationTests {

	@Test
	public void contextLoads() {
	}

	TestRestTemplate restTemplate;
	URL base;
	@LocalServerPort int port;

	@Before
	public void setUp() throws MalformedURLException {
		restTemplate = new TestRestTemplate("jithin", "jithin");
		base = new URL("http://localhost:" + port+"/startup/");
	}

	@Test
	public void whenLoggedUserRequestsHomePage_ThenSuccess()throws IllegalStateException, IOException {
		ResponseEntity<String> response = restTemplate.getForEntity(base.toString(), String.class);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertTrue(response
				.getBody()
				.contains("Jack"));
	}

	@Test
	public void whenUserWithWrongCredentials_thenUnauthorizedPage()
			throws Exception {

		restTemplate = new TestRestTemplate("jithin", "jithin-wrongpassword");
		ResponseEntity<String> response = restTemplate.getForEntity(base.toString(), String.class);

		assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());
		/*assertTrue(response
				.getBody()
				.contains("Unauthorized"));*/
	}
}
