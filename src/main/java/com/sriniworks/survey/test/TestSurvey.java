package com.sriniworks.survey.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.sriniworks.survey.model.Survey;
import com.sriniworks.survey.model.Survey.SurveyType;
import com.sriniworks.survey.repository.SurveyRepository;

public class TestSurvey {

	

	@Autowired
	SurveyRepository repository = null;
	
	
	@Test
	public void creatSurvey() throws Exception {
		
		Survey survey = new Survey();
		survey.setSurveyName("This is my first Survey");
		survey.setSurveyType(SurveyType.Social);

	}

}
