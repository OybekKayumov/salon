package com.ok.service;

import com.ok.payload.dto.SignupDTO;
import lombok.RequiredArgsConstructor;
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


	}



}
