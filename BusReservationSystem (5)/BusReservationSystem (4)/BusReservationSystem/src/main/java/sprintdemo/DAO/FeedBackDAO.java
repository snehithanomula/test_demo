package sprintdemo.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sprintdemo.exception.FeedBackAlreadyExsistsException;
import sprintdemo.exception.FeedBackInvalidRatingException;
import sprintdemo.exception.FeedBackNotFoundException;
import sprintdemo.exception.LoginException;
import sprintdemo.model.Feedback;
import sprintdemo.repository.IFeedBackRepository;
import sprintdemo.service.IFeedBackService;
@Service
public class FeedBackDAO implements IFeedBackService{
	@Autowired
	private IFeedBackRepository repository;
	@Autowired
	UserDAO lid;
	@Override
	public Feedback addFeedBack(Feedback feedback) throws FeedBackAlreadyExsistsException, FeedBackInvalidRatingException, LoginException {
		if(lid.level==1||lid.level==2) {
		if(!repository.existsById(feedback.getFeedBackId()))
			
		    	{
			    if(checkRating(feedback.getDriverRating()))
		     	{
			    if(checkRating(feedback.getServiceRating()))
			    {
			    if(checkRating(feedback.getOverallRating()))
			     {
				return repository.save(feedback);
			}
			    else
			    {
			    	throw new FeedBackInvalidRatingException("Exceeds OverallRating");
			    }
			    }
			    else
			    {
			    	throw new FeedBackInvalidRatingException("Exceeds ServiceRating");
			    }
		     	}
			    else
			    {
			    throw new FeedBackInvalidRatingException("Exceeds DriverRating");
		    	}
	}
	           else
	{
	        	   throw new FeedBackAlreadyExsistsException("FeedBack Already exsists");
	}
		}
		else {
throw new LoginException("You need to login!");
		
	}
		    		
	}
		
		@Override

	  public Feedback updateFeedBack(Feedback feedback) throws FeedBackInvalidRatingException, FeedBackAlreadyExsistsException, LoginException  {
			if(lid.level==1||lid.level==2) {
			if(repository.existsById(feedback.getFeedBackId()))
				
	    	{
		    if(checkRating(feedback.getDriverRating()))
	     	{
		    if(checkRating(feedback.getServiceRating()))
		    {
		    if(checkRating(feedback.getOverallRating()))
		     {
		Feedback f1=repository.getById(feedback.getFeedBackId());
		f1.setDriverRating(feedback.getDriverRating());
		f1.setComments(feedback.getComments());
		f1.setServiceRating(feedback.getServiceRating());
		f1.setOverallRating(feedback.getOverallRating());
		f1.setFeedBackId(feedback.getFeedBackId());
		f1.setFeedbackdate(feedback.getFeedbackdate());
		return repository.save(f1);
		     }
		else
	    {
	    	throw new FeedBackInvalidRatingException("Exceeds OverallRating");
	    }
	    }
	    else
	    {
	    	throw new FeedBackInvalidRatingException("Exceeds ServiceRating");
	    }
	 	}
	    else
	    {
	    throw new FeedBackInvalidRatingException("Exceeds DriverRating");
		}
	     	}
		    else
		    {
	  
	throw new FeedBackAlreadyExsistsException("FeedBack Already exsists");
	}
			}
			else {
				throw new LoginException("You need to login!");
						
					}
			
	}
	   


		

	@Override
	public Optional<Feedback> viewFeedBack(int feedbackid) throws FeedBackNotFoundException, LoginException {
		if(lid.level==1||lid.level==2) {
		if(repository.existsById(feedbackid))
		{
			return repository.findById(feedbackid);			
			}
			
		
		else
		{
			throw new FeedBackNotFoundException("FeedBack Id Not Found");
		}
		//
	}
	else {
		throw new LoginException("You need to login!");
				
			}
		
	}

	@Override
	   public List<Feedback> viewAllFeedBack() throws LoginException {
		if(lid.level==1||lid.level==2) {
		List<Feedback> list=repository.findAll();
		return list;
		}
		else {
			throw new LoginException("You need to login!");
					
				}
		
	}

	public boolean checkRating(int rating) throws LoginException {
		if(lid.level==1||lid.level==2) {
	if (rating<=10) {
	return true;
	}
	else {
	return false;
	}
	}
	else {
		throw new LoginException("You need to login!");
				
			}
	}

}
