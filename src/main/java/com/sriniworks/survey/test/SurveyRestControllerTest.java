package com.sriniworks.survey.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.sriniworks.survey.SurveyApplication;
import com.sriniworks.survey.config.AppConfig;
import com.sriniworks.survey.model.Survey;
import com.sriniworks.survey.repository.SurveyRepository;

@RunWith(SpringRunner.class)
@WebMvcTest(value = SurveyApplication.class, secure = false)
@ContextConfiguration(classes = AppConfig.class)
public class SurveyRestControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private SurveyRepository surveyRepository;

	@Test
	public void getAllSurveys() throws Exception {

		fail("Not yet implemented");
		
		List<Survey> allSurveys = null;
		
		/*
		 * Mockito.when(
				studentService.retrieveCourse(Mockito.anyString(),
						Mockito.anyString())).thenReturn(mockCourse);

		 */

		Mockito.when(surveyRepository.getAllSurveys(MockData.getUser())).thenReturn(allSurveys);
		
		System.out.println( allSurveys.size());
		allSurveys.forEach( survey -> System.out.println( survey.toString()));
		
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/survey")
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
		assertNotNull( result );

		//JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}
}
