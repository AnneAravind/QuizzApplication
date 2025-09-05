package com.Telusko.quizapp.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Telusko.quizapp.Model.Question;
import com.Telusko.quizapp.Model.Quiz;
import com.Telusko.quizapp.Model.Response;
import com.Telusko.quizapp.Model.questionWrapper;
import com.Telusko.quizapp.Repository.QuestionRepo;
import com.Telusko.quizapp.Repository.QuizRepo;

@Service
public class quizService 
{
	@Autowired
	QuizRepo quizDao;
	
	@Autowired
	QuestionRepo questionDao;

	public  ResponseEntity<String> createQuiz(String category, int numQ, String title) 
	{
		List<Question> questions = questionDao.findRandomQuestionsByCategory(category,numQ);
		
		Quiz quiz = new Quiz();
		quiz.setTitle(title);
		quiz.setQuestions(questions);
		quizDao.save(quiz);
		return new ResponseEntity<>("Success",HttpStatus.CREATED);
	}

	public ResponseEntity<List<questionWrapper>> getQuizQuestions(Integer id) {
		Optional<Quiz> quiz = quizDao.findById(id);	
		List<Question> questionFromDb = quiz.get().getQuestions();
		List<questionWrapper> questionForUser= new ArrayList<>();
		for(Question q:questionFromDb)
		{
			questionWrapper qw = new questionWrapper(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
		    questionForUser.add(qw);
		}
		
		
		
		return new ResponseEntity<>(questionForUser, HttpStatus.OK);
	}

	public ResponseEntity<Integer> calculateResult(Integer id, List<Response> response) 
	{
		Quiz quiz = quizDao.findById(id).get();
		List<Question>  questions = quiz.getQuestions();
		int right=0;
		int i=0;
		for(Response response2:response)
		{
			if(response2.getResponse().equals(questions.get(i).getRightAnswer()))
				right++;
			
			i++;
			
		}
		return new ResponseEntity<>(right,HttpStatus.OK);
	}
	

}
