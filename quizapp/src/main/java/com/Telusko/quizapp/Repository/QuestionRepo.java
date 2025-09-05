package com.Telusko.quizapp.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.Telusko.quizapp.Model.Question;

@Repository
public interface QuestionRepo extends JpaRepository<Question, Integer> 
{
	List<Question>findByCategory(String category);

//	@Query(value = "SELECT * FROM question q where q.category=:category ORDER BY RANDOM() LIMIT:numQ",nativeQuery = true);
//	List<Question> findRandomQuestionsByCategory(String category, int numQ);

	@Query(value = "SELECT * FROM question q WHERE q.category = :category ORDER BY RAND() LIMIT :numQ", nativeQuery = true)
	List<Question> findRandomQuestionsByCategory(String category,int numQ);

	
	
	
	//String save(String category);
	//List<Question> saveById(Integer id);
}
