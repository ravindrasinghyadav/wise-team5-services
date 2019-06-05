
package com.db.wise.team5.model;

public class Topic {

	TopicDetail topicDetail;
	long topicId;

	public long getTopicId() {
		return topicId;
	}

	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}

	public Topic(TopicDetail topicDetail, long topicId) {
		super();
		this.topicDetail = topicDetail;
		this.topicId = topicId;
	}
	
	public TopicDetail getTopicDetail() {
		return topicDetail;
	}

	public void setTopicDetail(TopicDetail topicDetail) {
		this.topicDetail = topicDetail;
	}

}
