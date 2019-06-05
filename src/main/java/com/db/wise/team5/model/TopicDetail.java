package com.db.wise.team5.model;

import java.util.List;

public class TopicDetail {

	List<QuestionAnswers> lisOfQuestoinsAnswers;	
	public TopicDetail(List<QuestionAnswers> lisOfQuestoinsAnswers) {
		super();
		this.lisOfQuestoinsAnswers = lisOfQuestoinsAnswers;
	}

	public List<QuestionAnswers> getLisOfQuestoinsAnswers() {
		return lisOfQuestoinsAnswers;
	}

	public void setLisOfQuestoinsAnswers(List<QuestionAnswers> lisOfQuestoinsAnswers) {
		this.lisOfQuestoinsAnswers = lisOfQuestoinsAnswers;
	}

}
