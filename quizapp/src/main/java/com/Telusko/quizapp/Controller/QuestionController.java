package com.Telusko.quizapp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Telusko.quizapp.Model.Question;
import com.Telusko.quizapp.Service.QuestionService;

@RestController
@RequestMapping("question")
public class QuestionController 
{
	@Autowired
	QuestionService questionService;
	
	
	@RequestMapping("allQuestions")
	public ResponseEntity<List<Question>> getAllQuestion()
	{
		return questionService.getAllQuestions();
	}
	
	@GetMapping("category/{category}")
	public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category)
	{
		return questionService.getQuestionsByCategory(category);
	}
	
	@PostMapping("add")
	public ResponseEntity<String>addQuestion(@RequestBody Question question)
	{
		return questionService.addQuestion(question);
	}
	
	
	
	@PutMapping("/products")
	public void updateProduct(@RequestBody Question prod)
	{
		questionService.updateProduct(prod);
	}
	
	@DeleteMapping("del/{id}")
	public void deleteQuestion(@PathVariable Integer id)
	{
		questionService.deleteQuestion(id);
		
	}

}
