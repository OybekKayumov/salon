package com.ok.payload.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserRequest {
	private String username;
	private Boolean enabled;
	private String firstname;
	private String lastname;
	private String email;
	private String password;

	private List<Credential> credentials = new ArrayList<Credential>();
}
