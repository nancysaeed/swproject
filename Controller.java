package io.javasprings.springbootEval;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerTopic {
	
	@Autowired
	private RecommendQuizsToUser RQTU; 
	
	@RequestMapping("/quiz")
	public List<RecommendedQ> getonlyone() throws IOException
	{				
		return RQTU.RecommendedQuizForUser();		
	}
	
	@Autowired
	private RecommendCompaniesToUser RCTU;
	
	
	@RequestMapping("/company")
	public List<Recommended> getrecoCompanies() throws IOException
    {
    	return RCTU.RecommendedCompanyForUser();
	}
	
	@Autowired
	private RecommendCandidatesToComp RCTC;
	
	
	@RequestMapping("/users")
	public List<Recommended> getrecousers() throws IOException
    {
    	return RCTC.RecommendedUsersForCompany();
	}
	@Autowired
	private RecommendCandidatesToComp C;
	
	
	@RequestMapping("/sortedcandidates")
	public List<Recommended> getAllsorted() throws IOException
    {
    	return C.SortCandidates();
	}
	
}
