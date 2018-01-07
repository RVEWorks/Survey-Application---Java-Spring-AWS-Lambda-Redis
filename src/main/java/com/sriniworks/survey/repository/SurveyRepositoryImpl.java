package com.sriniworks.survey.repository;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import com.sriniworks.survey.model.Survey;
import com.sriniworks.survey.model.SurveyItem;
import com.sriniworks.survey.model.User;

@Component
public class SurveyRepositoryImpl implements SurveyRepository {

	private HashOperations hashOps = null;

	@Autowired
	private SurveyRepositoryImpl(RedisTemplate surveyRedisTemplate) {
		this.hashOps = surveyRedisTemplate.opsForHash();
	}

	@Override
	public List<Survey> getAllSurveys(final User user) {

		return new ArrayList<Survey>(hashOps.entries(getSurveyKey(user)).values());

	}

	@Override
	public Survey getSurveyById(final User user, final String Id) {
		return (Survey) hashOps.get(getSurveyKey(user), UUID.fromString(Id));
	}

	@Override
	public void addSurvey(final User user, Survey survey) {
		survey.setId(UUID.randomUUID());
		survey.setInitiatedDate(new Timestamp(System.currentTimeMillis()));
		hashOps.put(getSurveyKey(user), survey.getId(), survey);
	}

	@Override
	public void updateSurvey(final User user, Survey survey) {

		Survey cacheSurvey = getSurveyById(user, survey.getId().toString());
		cacheSurvey.setSurveyName(survey.getSurveyName());
		cacheSurvey.setSurveyType(survey.getSurveyType());
		hashOps.put(getSurveyKey(user), cacheSurvey.getId(), cacheSurvey);

	}

	@Override
	public void removeSurvey(final User user, final Survey survey) {
		hashOps.delete(getSurveyKey(user), survey.getId());

	}

	@Override
	public List<SurveyItem> getAllSurveyItemsBySurvey(User user, Survey survey) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveSurveyItem(User user, Survey survey, SurveyItem item) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeSurveyItem(User user, Survey survey, SurveyItem item) {
		// TODO Auto-generated method stub

	}

	private static String getSurveyKey(User user) {
		return new StringBuffer().append(user.getId()).append(":").append("Survey").toString();
	}

}
