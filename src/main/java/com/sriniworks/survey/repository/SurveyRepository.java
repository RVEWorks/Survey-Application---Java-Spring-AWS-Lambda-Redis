package com.sriniworks.survey.repository;

import java.util.List;

import com.sriniworks.survey.model.Survey;
import com.sriniworks.survey.model.SurveyItem;
import com.sriniworks.survey.model.User;

public interface SurveyRepository {

	public List<Survey> getAllSurveys(User user);

	public Survey getSurveyById(User user, String Id);

	public void addSurvey(User user, Survey survey);
	
	public void updateSurvey(User user, Survey survey);

	public void removeSurvey(User user, Survey survey);

	public List<SurveyItem> getAllSurveyItemsBySurvey(User user, Survey survey);

	public void saveSurveyItem(User user, Survey survey, SurveyItem item);

	public void removeSurveyItem(User user, Survey survey, SurveyItem item);

}
