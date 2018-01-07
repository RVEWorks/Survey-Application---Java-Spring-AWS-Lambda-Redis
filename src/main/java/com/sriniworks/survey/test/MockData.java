package com.sriniworks.survey.test;

import java.util.UUID;

import com.sriniworks.survey.model.Survey;
import com.sriniworks.survey.model.User;
import com.sriniworks.survey.model.Survey.SurveyType;

public class MockData {

	public static User getUser() {
		User user = new User();
		user.setId(UUID.fromString("ab249ab9-ec83-43ad-8731-f1bb85a06e32"));
		user.setFullName("Srini Putla");
		user.setEmailAddress("test@t.com");

		return user;
	}

	public static Survey getSurvey() {
		Survey survey = new Survey();
		survey.setSurveyName("My First Survey");
		survey.setSurveyType(SurveyType.Social);
		return survey;
	}
}
