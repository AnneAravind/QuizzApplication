package com.Telusko.quizapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Telusko.quizapp.Model.Quiz;

@Repository
public interface QuizRepo extends JpaRepository<Quiz, Integer>  {

}
