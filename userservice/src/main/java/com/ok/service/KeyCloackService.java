package com.ok.service;

import com.ok.payload.dto.Credential;
import com.ok.payload.dto.SignupDTO;
import com.ok.payload.dto.UserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class KeyCloackService {

	private static final String KEYCLOACK_BASE_URL = "http://localhost:8080";

	private static final String KEYCLOACK_ADMIN_API =
					KEYCLOACK_BASE_URL + "/admin/realms/master/users";

	private static final String TOKEN_URL =
					KEYCLOACK_BASE_URL + "/realms/master/protocol/openid-connect/token";

	private static final String CLIENT_ID = "salon-booking-client";
	private static final String CLIENT_SECRET = "4TLgEBFTBG0bhsVNCmP5GWdws0IKJyv3";

	private static final String GRANT_TYPE = "password";
	private static final String scope = "openid email profile";

	private static String username = "admin1";
	private static String password = "123456";

	private static final String clientId = "d016b90f-14c6-401e-899e-12d91f183543";

	private final RestTemplate restTemplate;

	public void createUser(SignupDTO signupDTO) throws Exception {

		String ACCESS_TOKEN = "";

		Credential credential = new Credential();
		credential.setTemporary(false);
		credential.setType("password");
		credential.setValue(signupDTO.getPassword());

		UserRequest userRequest = new UserRequest();
		userRequest.setUsername(signupDTO.getUsername());
		userRequest.setEmail(signupDTO.getEmail());
		userRequest.setEnabled(true);
		userRequest.setLastname(signupDTO.getLastName());
		userRequest.setFirstname(signupDTO.getFirstName());

		HttpHeaders headers = new HttpHeaders();

		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setBearerAuth(ACCESS_TOKEN);

		HttpEntity<UserRequest> requestEntity = new HttpEntity<>(userRequest, headers);

		ResponseEntity<String> response = restTemplate.exchange(
						KEYCLOACK_ADMIN_API,
						HttpMethod.POST,
						requestEntity,
						String.class
		);

		if (response.getStatusCode() == HttpStatus.CREATED) {

			System.out.println("User created successfully");
		}
	}

}
