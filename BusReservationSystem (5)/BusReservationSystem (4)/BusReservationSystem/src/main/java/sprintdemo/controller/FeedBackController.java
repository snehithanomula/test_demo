package sprintdemo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//import springfox.documentation.swagger2.annotations.EnableSwagger2;
import sprintdemo.DAO.FeedBackDAO;
import sprintdemo.exception.FeedBackAlreadyExsistsException;
import sprintdemo.exception.FeedBackInvalidRatingException;
import sprintdemo.exception.FeedBackNotFoundException;
import sprintdemo.exception.LoginException;
import sprintdemo.model.Feedback;
//@EnableSwagger2
@RestController
@CrossOrigin
public class FeedBackController {
	@Autowired
	private FeedBackDAO dao;
	
	@RequestMapping(path="/FeedBack")
	public List<Feedback> getFeedBack() throws LoginException
	{
		return dao.viewAllFeedBack();
	}
	@PostMapping(path="/addFeedBack")
	public Feedback addFeedBack(@Valid @RequestBody Feedback f)throws FeedBackAlreadyExsistsException,FeedBackInvalidRatingException, LoginException {
	{
		
		return dao.addFeedBack(f);
	}
	}
	@PostMapping(path="/updateFeedBack")
	public ResponseEntity<Feedback> saveOrUpdate(@Valid @RequestBody Feedback feedback) throws FeedBackInvalidRatingException, FeedBackAlreadyExsistsException, LoginException {
		Feedback f=dao.updateFeedBack(feedback);
		return new ResponseEntity<Feedback>(f,HttpStatus.OK);
	}
	
	@GetMapping(path="/viewFeedBack/{feedBackId}")
	public Optional<Feedback> viewbyId(@PathVariable int feedBackId)throws FeedBackNotFoundException, LoginException {
	{
	return dao.viewFeedBack(feedBackId);
	}
	
	}	
@RequestMapping(path="/viewAllFeedBack")
	public List<Feedback> viewAllFeedBack() throws LoginException {
		return dao.viewAllFeedBack();
	}

}
