package io.javasprings.springbootEval;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class RecommendQuizsToUser {

	
	GetInterests getinterests = new GetInterests();
	List<QuizData> QuizList = new ArrayList();
	public List<QuizData> ListOfQuizrecomnd = new ArrayList();
	UserData SpecificUser = new UserData();
	
	//***********************
		public List<RecommendedQ> RecommendedQuizForUser() throws IOException 
	    {
			List<RecommendedQ> recommended = new ArrayList();			
			QuizList = getinterests.OutQuizesGETRequest();
			SpecificUser = getinterests.OutUserGETRequest();
			String LQI ;
			List <String> LUI = new ArrayList();
			LUI = SpecificUser.getInterest();
			List <String> tempListUI = new ArrayList();
			
			for(int j=0 ; j<QuizList.size() ; j++)
	        {
				LQI = QuizList.get(j).getSkillType();
	            if(LUI.contains(LQI))
	            	ListOfQuizrecomnd.add(QuizList.get(j));	            
	        }
			//**********************
			for(int x=0 ; x<ListOfQuizrecomnd.size(); x++)
	        {
	        	 //System.out.println(ListOfQuizrecomnd.get(x).getTitle());
	        	RecommendedQ temp = new RecommendedQ();
	            temp.Recommended_quiz_name=ListOfQuizrecomnd.get(x).getTitle();
	            temp.ID=getinterests.OutUserGETRequest().getname();
	            recommended.add(temp);
	        }
	        return recommended;
	    }
}
