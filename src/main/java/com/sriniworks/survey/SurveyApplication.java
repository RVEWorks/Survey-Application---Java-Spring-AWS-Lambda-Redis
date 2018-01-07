package com.sriniworks.survey;

import java.net.URI;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.sriniworks.survey.model.Survey;
import com.sriniworks.survey.model.User;
import com.sriniworks.survey.repository.SurveyRepository;
import com.sriniworks.survey.test.MockData;

@SpringBootApplication
@RestController
@RequestMapping("/survey")
public class SurveyApplication implements RequestHandler<String, String> {

	private final SurveyRepository surveyRepository;

	@Autowired
	SurveyApplication(SurveyRepository surveyRepository) {
		this.surveyRepository = surveyRepository;

	}

	public static void main(String[] args) {
		SpringApplication.run(SurveyApplication.class, args);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> getAllSurveys() {

		List<Survey> result = surveyRepository.getAllSurveys(getUser());
		return new ResponseEntity<List<Survey>>(result, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<?> getSurvey(@PathVariable String id) {

		Survey survey = surveyRepository.getSurveyById(getUser(), id);
		return new ResponseEntity<Survey>(survey, HttpStatus.OK);

	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	ResponseEntity<?> addSurvey(@RequestBody Survey survey) {

		surveyRepository.addSurvey(getUser(), survey);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(survey.getId())
				.toUri();
		return ResponseEntity.created(location).build();

	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	ResponseEntity<?> updateSurvey(@PathVariable String id, @RequestBody Survey survey) {
		survey.setId(UUID.fromString(id));
		surveyRepository.updateSurvey(getUser(), survey);
		survey = surveyRepository.getSurveyById(getUser(), id);
		return new ResponseEntity<Survey>(survey, HttpStatus.OK);

	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<?> removeSurvey(@PathVariable String id) {

		Survey survey = surveyRepository.getSurveyById(getUser(), id);
		surveyRepository.removeSurvey(getUser(), survey);
		return new ResponseEntity<Survey>(HttpStatus.NO_CONTENT);

	}
	
	private static final User getUser( ) {
		return MockData.getUser();
	}

	@Override
	public String handleRequest(String arg0, Context arg1) {
		// TODO Auto-generated method stub
		return null;
	}

}
