package com.db.wise.team5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.db.wise.team5.model.Exam;
import com.db.wise.team5.repository.WiseQuestionRepositoryDAO;

@RestController
@RequestMapping("/")
public class WiseQuestionController {

	@Autowired
	WiseQuestionRepositoryDAO wiseQuestionRepositoryDAO;

	@RequestMapping("/getQuestionsByCategory")
	@ResponseBody
	public Exam getQuestionsByCategory() {
		System.out.println("getQuestionsByCategory");
		return wiseQuestionRepositoryDAO.getQuestionaire();

	}

}
