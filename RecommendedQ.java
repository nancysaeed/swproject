package io.javasprings.springbootEval;

public class RecommendedQ {

	String Recommended_quiz_name;
	//String skill_name;
	String ID;
	
	public RecommendedQ () {}
	
	public RecommendedQ(String n, String id)
	{		
		Recommended_quiz_name= n;
		ID = id;
	}
	public void setREname(String na)
	{		
		Recommended_quiz_name=na;
	}
	public String getREname()
	{
		
		return Recommended_quiz_name;
	}
	public void setIDname(String na)
	{		
		ID=na;
	}
	public String getIDname()
	{
		
		return ID;
	}
}
