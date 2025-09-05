package com.Telusko.quizapp.Service;

import java.net.ResponseCache;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Telusko.quizapp.Model.Question;
import com.Telusko.quizapp.Repository.QuestionRepo;
@Service
public class QuestionService 
{
	@Autowired
	QuestionRepo questionDao;
	
	public ResponseEntity<List<Question>> getAllQuestions()
	{
		try {
		return new ResponseEntity<> (questionDao.findAll(), HttpStatus.OK);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<List<Question>> getQuestionsByCategory(String category) 
	{
		return new ResponseEntity<>(questionDao.findByCategory(category),HttpStatus.OK);
	}

	public ResponseEntity<String> addQuestion(Question question) 
	{
		questionDao.save(question);
		return new ResponseEntity<>("Success",HttpStatus.OK);
	}

//	public void updateQuestionByCategory(Question question) 
//	{
//		questionDao.save(question);
//		//return "Success";
//	}
	public void updateProduct(Question prod) 
	{
		questionDao.save(prod);
		
	}

	public void deleteQuestion(Integer id) 
	{
		questionDao.deleteById(id);
		// TODO Auto-generated method stub
		
	}

	
}
