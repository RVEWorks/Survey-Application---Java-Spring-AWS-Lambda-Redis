package com.sriniworks.survey.model;

import java.io.Serializable;
import java.util.List;

public class SurveyItem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public enum QuestionType {
		Text, SingleCheckBox, MultipleCheckBox, Radio, Select
	}

	private Long id;

	private String question = null;
	private QuestionType questionType = null;
	private List<String> possibleAnswers = null;
	private List<String> selectedAnswers = null;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public QuestionType getQuestionType() {
		return questionType;
	}

	public void setQuestionType(QuestionType questionType) {
		this.questionType = questionType;
	}

	public List<String> getPossibleAnswers() {
		return possibleAnswers;
	}

	public void setPossibleAnswers(List<String> possibleAnswers) {
		this.possibleAnswers = possibleAnswers;
	}

	public List<String> getSelectedAnswers() {
		return selectedAnswers;
	}

	public void setSelectedAnswers(List<String> selectedAnswers) {
		this.selectedAnswers = selectedAnswers;
	}

}
