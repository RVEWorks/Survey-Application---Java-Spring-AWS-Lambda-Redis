package com.sriniworks.survey.model;

import java.io.Serializable;
import java.util.UUID;

public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String authenticationKEy = null;
	private String emailAddress = null;
	private String fullName = null;

	private UUID id = null;

	public String getAuthenticationKEy() {
		return authenticationKEy;
	}

	public void setAuthenticationKEy(String authenticationKEy) {
		this.authenticationKEy = authenticationKEy;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

}
