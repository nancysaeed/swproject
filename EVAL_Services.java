package io.javasprings.springbootEval;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class EVAL_Services {
	
	private List<UserData> ud =Arrays.asList(new UserData(123,"AyaAhmedEliwa",Arrays.asList("java","XML")), 
			new UserData(456,"YOuoAnwarHassan",Arrays.asList("spring boot","C++"))); 

	public List<UserData> getusers()
	{
		return ud;
	}
	
	public UserData getone(String iddd)
	{
		
		return ud.stream().filter(t ->t.getname().equals(iddd)).findFirst().get();
	}
}
