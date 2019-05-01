package io.javasprings.springbootEval;

import static java.util.Comparator.comparing;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class RecommendCandidatesToComp {
	
	
	GetInterests getinterests = new GetInterests();
	Interests_Scores SpecificCompany = new Interests_Scores();
	List <UserData> AllUser = new ArrayList();
	List<Integer> sumInterests = new ArrayList();
	
	//***********************
		<String>List<String> intersection(List<String> list1, List<String> list2) 
	    {
	        List<String> list = new ArrayList<String>();

	        for (String t: list1) {
	            if(list2.contains(t)) {
	                list.add(t);
	            }
	        }

	        return list;
	    }
	//****************************
		List<Recommended> recommended = new ArrayList();
		
	public List<Recommended> RecommendedUsersForCompany() throws IOException 
    {
		
		SpecificCompany = getinterests.OutonecompanyGETRequest();
		AllUser = getinterests.OutAllUsersGETRequest();
		
		List <String> LCI = new ArrayList();
		List <String> LUI = new ArrayList();
		LCI = SpecificCompany.getInterests();
		List <String> tempListUI = new ArrayList();
		for(int j=0 ; j<AllUser.size() ; j++)
        {
			LUI = AllUser.get(j).getInterest();
            tempListUI = intersection(LUI , LCI);
            int n = tempListUI.size();
            sumInterests.add(n);   
            //System.out.println(tempListUI);
        }
		//**********************
				List <Integer>fortest = new ArrayList();
		        int maxvalue = Collections.max(sumInterests);
		        
		        int maxindex =0 ;
		        for(int x=0 ; x<sumInterests.size(); x++)
		        {
		            if(maxvalue == sumInterests.get(x) )
		            {
		                fortest.add(x);
		            }                                      
		        }
		        for(int k=0;k<fortest.size();k++)
		        {
		            Recommended temp = new Recommended();
		            temp.setREname(AllUser.get(fortest.get(k)).getname());
		            recommended.add(temp);
		        }
		        for(int k=0;k<recommended.size();k++)
		        {
		        	System.out.println(recommended.get(k).getREname());
		        }
		
		return recommended;
    }
	List<Recommended> SortedCandidates = new ArrayList();
	List<AllQuizData> Candidates_Quiz = new ArrayList();
	List<sumscores> unsortList = new ArrayList();
	List<sumscores> sortList = new ArrayList();
	sumscores collect = new sumscores();
	public List<Recommended> SortCandidates() throws IOException
	{
		RecommendedUsersForCompany();
		SpecificCompany = getinterests.OutonecompanyGETRequest();
		Candidates_Quiz = getinterests.OutinfoQuizGETRequest();
		for(int i=0 ; i< recommended.size();i++)
		{
			int sumScores = 0;
			for(int x=0 ; x<Candidates_Quiz.size(); x++)
			{
				if(recommended.get(i).getREname() == Candidates_Quiz.get(x).getuname())
				{
					for(int z=0 ; z<SpecificCompany.getInterests().size();z++)
					{
						if(SpecificCompany.getInterests().get(z)== Candidates_Quiz.get(x).getSkillType())
						{
							sumScores= (sumScores+ Candidates_Quiz.get(x).getscore());
						}
					}					
				}
			}
			collect.setsum(sumScores);
			collect.setindex(i);
			unsortList.add(collect);
		}
		unsortList.sort(comparing(sumscores::getsum));
		
		Collections.reverse(unsortList);
		/*for(int v=0 ; v<unsortList.size(); v++)
		{
			SortedCandidates.add(recommended.get(unsortList.get(v).getindex()));
		}*/
		
		//for(int v=0;v<SortedCandidates.size();v++)
			//System.out.println(SortedCandidates.get(v).getREname());
		
		return recommended;
	}

}
