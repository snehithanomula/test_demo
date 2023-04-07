package sprintdemo.service;

import java.util.List;
import java.util.Optional;

import sprintdemo.exception.FeedBackAlreadyExsistsException;
import sprintdemo.exception.FeedBackInvalidRatingException;
import sprintdemo.exception.FeedBackNotFoundException;
import sprintdemo.exception.LoginException;
import sprintdemo.model.Feedback;

public interface IFeedBackService {
	Feedback addFeedBack(Feedback feedback)throws FeedBackAlreadyExsistsException, FeedBackInvalidRatingException, LoginException;
	  Feedback updateFeedBack(Feedback feedback)throws FeedBackAlreadyExsistsException, FeedBackInvalidRatingException, LoginException;
		Optional<Feedback> viewFeedBack(int feedbackid)throws FeedBackNotFoundException, LoginException;
		List<Feedback> viewAllFeedBack() throws LoginException;

}
