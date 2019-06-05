package com.db.wise.team5.model;

import java.util.Map;

public class QuestionAnswers {

	String question;
	Map<Integer, String> answersMap;
	Integer rightChoice;

	public QuestionAnswers(String question, Map<Integer, String> answersMap, Integer rightChoice) {
		super();
		this.question = question;
		this.answersMap = answersMap;
		this.rightChoice = rightChoice;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Map<Integer, String> getAnswersMap() {
		return answersMap;
	}

	public void setAnswersMap(Map<Integer, String> answersMap) {
		this.answersMap = answersMap;
	}

	public Integer getRightChoice() {
		return rightChoice;
	}

	public void setRightChoice(Integer rightChoice) {
		this.rightChoice = rightChoice;
	}
}
