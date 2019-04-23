package io.javasprings.springbootEval;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerTopic {
	
	@Autowired
	private RecommendCompaniesToUser RCTU;
	
	
	@RequestMapping("/company")
	public List<Recommended> getrecoCompanies() throws IOException
    {
    	return RCTU.RecommendedCompanyForUser();
    }
	//////////////////////////////////
	@Autowired
	private RecommendQuizsToUser RQTU; 
	
	@RequestMapping("/quiz")
	public List<RecommendedQ> getonlyone() throws IOException
	{				
		return RQTU.RecommendedQuizForUser();		
	}

}

