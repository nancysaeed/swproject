package io.javasprings.springbootEval;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import static java.util.stream.DoubleStream.builder;

@Service
public class RecommendCompaniesToUser {

	public RecommendCompaniesToUser(){}
	GetInterests getinterests = new GetInterests();
	public List<CompanyData> companyList = new ArrayList();
	UserData SpecificUser = new UserData();
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
	public List<Recommended> RecommendedCompanyForUser() throws IOException 
    {
		List<Recommended> recommended = new ArrayList();
		companyList = getinterests.OutCompanyGETRequest();
		SpecificUser = getinterests.OutUserGETRequest();
		List <String> LCI = new ArrayList();
		List <String> LUI = new ArrayList();
		LUI = SpecificUser.getInterest();
		List <String> tempListUI = new ArrayList();
		
		for(int j=0 ; j<companyList.size() ; j++)
        {
			LCI = companyList.get(j).getInterest();
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
            temp.setREname(companyList.get(fortest.get(k)).getCompName());
            recommended.add(temp);
        }
        /*for(int k=0;k<recommended.size();k++)
        {
        	System.out.println(recommended.get(k).getREname());
        }*/
        return recommended;            
    }
}
