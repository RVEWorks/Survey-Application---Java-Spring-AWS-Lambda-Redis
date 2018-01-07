package com.sriniworks.survey.test;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.sriniworks.survey.config.AppConfig;
import com.sriniworks.survey.model.Survey;
import com.sriniworks.survey.repository.SurveyRepository;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AppConfig.class)

public class SurveyRepositoryTest {

	@Autowired
	private SurveyRepository repository = null;

	@Test
	public void testAddSurvey() {

		repository.addSurvey(MockData.getUser(), MockData.getSurvey());

		System.out.println(" survey ID : " + MockData.getSurvey().getId());
		assertNotNull(MockData.getSurvey().getId());
	}

	@Test
	public void testGetAllSurvey() {

		List<Survey> surveys = repository.getAllSurveys(MockData.getUser());

		System.out.println(" survey size  : " + surveys.size());
		assertNotNull(surveys);
	}

}
