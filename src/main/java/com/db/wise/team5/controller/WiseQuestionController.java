package com.db.wise.team5.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.db.wise.team5.model.Exam;
import com.db.wise.team5.model.QuestionAnswers;
import com.db.wise.team5.model.Topic;
import com.db.wise.team5.model.TopicDetail;
import com.db.wise.team5.model.User;

@RestController
@RequestMapping("/")
public class WiseQuestionController {

	@RequestMapping("/getQuestionsByCategory")
	@ResponseBody
	public Exam getQuestionsByCategory() {
		System.out.println("getQuestionsByCategory");
		//validateUser(user);
		
		List<QuestionAnswers> listOfQuesAns = new ArrayList<>();

		Map<Integer, String> ansMap = new LinkedHashMap<Integer, String>();
		ansMap.put(1, "Because their parents did the same thing.");
		ansMap.put(2, "They earn a better rate than if they invested in long-term stocks.");
		ansMap.put(3, "They do not want a lot of investment risk.");
		ansMap.put(4, "Because it helps them save money more easily.");

		String question = "Why do older people put their money in savings accounts?";

		QuestionAnswers questionAnswers = new QuestionAnswers(question, ansMap, 1);

		String question2 = "What is the available balance of a bank account?";
		Map<Integer, String> ansMap2 = new LinkedHashMap<Integer, String>();
		ansMap2.put(1, "The total amount of all the checks written.");
		ansMap2.put(2, "The amount the bank allows the customer to borrow.");
		ansMap2.put(3, "The amount the bank allows the customer to use now.");
		ansMap2.put(4, "The total amount of all checks deposited.");

		QuestionAnswers questionAnswers2 = new QuestionAnswers(question2, ansMap2, 3);

		Map<Integer, String> ansMap3 = new LinkedHashMap<Integer, String>();

		String question3 = "Since the late 1980s, the interests of _____ have decreased.";
		ansMap3.put(1, "credit cards");
		ansMap3.put(2, "savings accounts");
		ansMap3.put(3, "mortgage loans");
		ansMap3.put(4, "checking accounts");

		QuestionAnswers questionAnswers3 = new QuestionAnswers(question3, ansMap3, 2);

		listOfQuesAns.add(questionAnswers);
		listOfQuesAns.add(questionAnswers2);
		listOfQuesAns.add(questionAnswers3);

		//Topic topic = new Topic(new TopicDetail(listOfQuesAns), 1000);

		return new Exam(1000, new TopicDetail(listOfQuesAns));
	}

	private boolean validateUser(User user) {
		return initializeDBConnection() && validateuserExistsInWise(user);
	}

	private boolean initializeDBConnection() {
		return true;
	}

	private boolean validateuserExistsInWise(User user) {
		// validate user existence in database
		return true;

	}
}
