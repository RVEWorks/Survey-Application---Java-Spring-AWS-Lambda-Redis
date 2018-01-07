package com.sriniworks.survey.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

public class Survey implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public enum SurveyType {
		Social, Private
	}

	private UUID id;

	private String surveyName = null;
	private SurveyType surveyType = null;
	private Timestamp initiatedDate = null;





	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getSurveyName() {
		return surveyName;
	}

	public void setSurveyName(String surveyName) {
		this.surveyName = surveyName;
	}

	public SurveyType getSurveyType() {
		return surveyType;
	}

	public void setSurveyType(SurveyType surveyType) {
		this.surveyType = surveyType;
	}

	public Timestamp getInitiatedDate() {
		return initiatedDate;
	}

	public void setInitiatedDate(Timestamp initiatedDate) {
		this.initiatedDate = initiatedDate;
	}

	@Override
	public String toString() {
		return "Survey [id=" + id.toString() + ", surveyName=" + surveyName + ", surveyType=" + surveyType + ", initiatedDate="
				+ initiatedDate + "]";
	}

	
}
