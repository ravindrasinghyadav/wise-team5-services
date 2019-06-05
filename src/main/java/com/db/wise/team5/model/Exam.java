package com.db.wise.team5.model;
import java.util.List;

public class Exam {

	long topicId;
	List<QuestionAnswers> lisOfQuestoinsAnswers;

	public Exam(int topicId, List<QuestionAnswers> lisOfQuestoinsAnswers) {
		super();
		this.topicId = topicId;
		this.lisOfQuestoinsAnswers = lisOfQuestoinsAnswers;
	}

	public long getTopicId() {
		return topicId;
	}

	public void setTopicId(long topicId) {
		this.topicId = topicId;
	}

	public List<QuestionAnswers> getLisOfQuestoinsAnswers() {
		return lisOfQuestoinsAnswers;
	}

	public void setLisOfQuestoinsAnswers(List<QuestionAnswers> lisOfQuestoinsAnswers) {
		this.lisOfQuestoinsAnswers = lisOfQuestoinsAnswers;
	}

}
