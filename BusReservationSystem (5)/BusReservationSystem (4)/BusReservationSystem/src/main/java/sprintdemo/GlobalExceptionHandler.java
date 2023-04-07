package sprintdemo;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import sprintdemo.exception.AdminNotFoundException;
import sprintdemo.exception.BusAlreadyExistsException;
import sprintdemo.exception.BusNotFoundException;
import sprintdemo.exception.ErrorInfo;
import sprintdemo.exception.FeedBackAlreadyExsistsException;
import sprintdemo.exception.FeedBackInvalidRatingException;
import sprintdemo.exception.FeedBackNotFoundException;
import sprintdemo.exception.NoRouteIdFoundException;
import sprintdemo.exception.ReservationAlreadyExists;
import sprintdemo.exception.ReservationNotFound;
import sprintdemo.exception.RouteAlreadyexistException;
import sprintdemo.exception.UserAlreadyExistsException;
import sprintdemo.exception.UserNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
	// reservation exception
	@ExceptionHandler(ReservationAlreadyExists.class)
	public @ResponseBody ErrorInfo forReservationALreadyExists(ReservationAlreadyExists e,HttpServletRequest req){
		ErrorInfo E1=new ErrorInfo(LocalDateTime.now(),e.getMessage(),req.getRequestURI());
		return E1;
	}
	
	@ExceptionHandler(ReservationNotFound.class)
	public @ResponseBody ErrorInfo forReservationNotFound(ReservationNotFound e,HttpServletRequest req){
		ErrorInfo E1=new ErrorInfo(LocalDateTime.now(),e.getMessage(),req.getRequestURI());
		return E1;
	}
	
	//bus exception
	@ExceptionHandler(BusAlreadyExistsException.class)
	public @ResponseBody ErrorInfo checkBusAlreadyExistsExceptionInfo(BusAlreadyExistsException e,HttpServletRequest req) {
		 ErrorInfo erinfo = new ErrorInfo(LocalDateTime.now(),e.getMessage(),req.getRequestURI());
		 return erinfo;
	}
	
	@ExceptionHandler(BusNotFoundException.class)
	public @ResponseBody ErrorInfo checkNoSuchBusFoundExceptionInfo(BusNotFoundException e,HttpServletRequest req) {
		 ErrorInfo erinfo = new ErrorInfo(LocalDateTime.now(),e.getMessage(),req.getRequestURI());
		 return erinfo;
	}
	
	//user exception
	@ExceptionHandler(UserAlreadyExistsException.class)
	public @ResponseBody ErrorInfo checkUserAlreadyExistsExceptionInfo(UserAlreadyExistsException e, HttpServletRequest req) {
		ErrorInfo erinfo = new ErrorInfo(LocalDateTime.now(),e.getMessage(), req.getRequestURI());
		return erinfo;
	}
    
	
	@ExceptionHandler(UserNotFoundException.class)
	public @ResponseBody ErrorInfo checkUserNotFoundException(UserNotFoundException e, HttpServletRequest req) {
		ErrorInfo erinfo = new ErrorInfo(LocalDateTime.now(),e.getMessage(), req.getRequestURI());
		return erinfo;
	}
	
	//route exception
	@ExceptionHandler(RouteAlreadyexistException.class)
	public ResponseEntity<Object> checkRouteAlreadyexistException(RouteAlreadyexistException e, HttpServletRequest req) {
		 ErrorInfo erinfo = new ErrorInfo(LocalDateTime.now(),e.getMessage(),req.getRequestURI());
		 return new ResponseEntity<Object>(erinfo, HttpStatus.BAD_REQUEST) ;
	}

	
	@ExceptionHandler(NoRouteIdFoundException.class)
	public @ResponseBody ErrorInfo checkNoRouteFoundException(NoRouteIdFoundException e,HttpServletRequest req) {
		ErrorInfo erinfo = new ErrorInfo(LocalDateTime.now(),e.getMessage(),req.getRequestURI());
		 return erinfo;
	}
	
	
	
	
	// feedback exception
	@ExceptionHandler(FeedBackAlreadyExsistsException.class)
	public @ResponseBody ErrorInfo checkFeedBackAlreadyExistsExceptionInfo(FeedBackAlreadyExsistsException e,HttpServletRequest req) {
		 ErrorInfo erinfo = new ErrorInfo(LocalDateTime.now(),e.getMessage(),req.getRequestURI());
		 return erinfo;
	}
	
	
	
	
	@ExceptionHandler(FeedBackNotFoundException.class)
	public @ResponseBody ErrorInfo checkNoSuchFeedBackFoundExceptionInfo(FeedBackNotFoundException e,HttpServletRequest req) {
		 ErrorInfo erinfo = new ErrorInfo(LocalDateTime.now(),e.getMessage(),req.getRequestURI());
		 return erinfo;
	}
	@ExceptionHandler(FeedBackInvalidRatingException.class)
	public @ResponseBody ErrorInfo checkNoSuchFeedBackInvalidRatingExceptionInfo(FeedBackInvalidRatingException e,HttpServletRequest req) {
		 ErrorInfo erinfo = new ErrorInfo(LocalDateTime.now(),e.getMessage(),req.getRequestURI());
		 return erinfo;
	}
	
	//Admin Exception
	@ExceptionHandler(AdminNotFoundException.class)
	public @ResponseBody ErrorInfo checkNoSuchAdminNotFoundExceptionInfo(AdminNotFoundException e,HttpServletRequest req)
	{
	ErrorInfo erinfo = new ErrorInfo(LocalDateTime.now(),e.getMessage(),req.getRequestURI());
	return erinfo;
	}
	
	//for validation
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Object> checkValidation(MethodArgumentNotValidException e,HttpServletRequest req) {
		 ErrorInfo erinfo = new ErrorInfo(LocalDateTime.now(),e.getMessage(),req.getRequestURI(), e.getBindingResult().toString());
		 System.out.println(e.getBindingResult().toString());
		 return new ResponseEntity<Object>(erinfo,HttpStatus.BAD_REQUEST);
		 
	}
	
	

}
