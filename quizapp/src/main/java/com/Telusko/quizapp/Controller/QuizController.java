package com.Telusko.quizapp.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Telusko.quizapp.Model.Question;
import com.Telusko.quizapp.Model.Response;
import com.Telusko.quizapp.Model.questionWrapper;
import com.Telusko.quizapp.Service.quizService;

@RestController
@RequestMapping("quiz")
public class QuizController 
{ 
	@Autowired
	quizService service;
	
	@PostMapping("/create")
	public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String title )
	{
		return service.createQuiz(category,numQ,title);
	}
	
	@GetMapping("get/{id}")
	public ResponseEntity<List<questionWrapper>> getQuizQuestion(@PathVariable Integer id)
	{
		return service.getQuizQuestions(id); 
		
	}
	@PostMapping("submit/{id}")
	public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id,@RequestBody List<Response> response)
	{
		return service.calculateResult(id,response);
	}
}
