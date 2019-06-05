package com.db.wise.team5.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

import org.springframework.stereotype.Repository;

import com.db.wise.team5.model.Exam;
import com.db.wise.team5.model.QuestionAnswers;

@Repository
public class WiseQuestionRepositoryDAO {

	private static List<QuestionAnswers> listOfQuesAns = new ArrayList<>();
	static {
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

	}

	public Exam getQuestionaire() {
		// return new Exam(getRandomNumber(), listOfQuesAns);
		Connection connection = null;
		Statement statement = null;
		Exam exam = null;
		try {
			connection = getConnection();
			statement = connection.createStatement();
//			ResultSet result = statement.executeQuery(
//					"select q.question, q.choices, q.right_choice from question_answer q where q.id in (select distinct(e.question_id) from exam e group by exam_id");
			ResultSet result = statement.executeQuery(
					"select q.question, q.choices, q.right_choice from question_answer q");
			List<QuestionAnswers> listOfQuesAns = new ArrayList<>();
			Map<Integer, String> choiceMap = null;
			while (result.next()) {
				System.out.println("q.question : " + result.getString(1));
				System.out.println("q.choices : " + result.getString(2));
				System.out.println("q.right_choice : " + result.getString(3));
				if (result.getString(2) != null) {
					String[] choicesList = result.getString(2).split("<>");
					choiceMap = new LinkedHashMap<Integer, String>();
					for (int i = 0; i < choicesList.length; i++) {
						String[] keyVals = choicesList[i].split("=");
						choiceMap.put(Integer.parseInt(keyVals[0].trim()), keyVals[1]);
					}
				}
				QuestionAnswers questionAnswers = new QuestionAnswers(result.getString(1), choiceMap,
						Integer.parseInt(result.getString(3)));
				listOfQuesAns.add(questionAnswers);
			}
			exam = new Exam(getRandomNumber(), listOfQuesAns);

		} catch (ClassNotFoundException | SQLException e) {

		} finally {
			try {
				statement.close();
				connection.close();

			} catch (SQLException e) {
				System.out.println("Exception while closing the connection in wiseWuestioRepository java file");
			}
		}
		return exam;

	}

	private int getRandomNumber() {
		Random r = new Random(System.currentTimeMillis());
		return 10000 + r.nextInt(20000);
	}

	private Connection getConnection() throws ClassNotFoundException, SQLException {

		Class.forName("org.postgresql.Driver");
		String hostName = "team5db1.postgres.database.azure.com";
		String dbName = "postgres";
		String user = "team5@team5db1";
		String password = "CaryHack!";
		Connection connection = null;

		try {
			String url = String.format("jdbc:postgresql://%s/%s", hostName, dbName);
			// set up the connection properties
			Properties properties = new Properties();
			properties.setProperty("user", user);
			properties.setProperty("password", password);
			properties.setProperty("ssl", "false");

			// get connection
			connection = DriverManager.getConnection(url, properties);
		} catch (SQLException e) {
			throw new SQLException("Failed to create connection to database.", e);
		}

		if (connection != null) {
			return connection;
		} else {
			throw new SQLException("Unable to coonect to AZURE DATABASE from Wise APP!");
		}

	}
}