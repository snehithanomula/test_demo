package sprintdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sprintdemo.model.Feedback;

public interface IFeedBackRepository extends JpaRepository<Feedback, Integer>{
	//@Query("SELECT i FROM FeedBack i WHERE i.feedBackId= ?1")
	//Feedback viewbyId(int feedBackId);

}
