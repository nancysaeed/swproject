package io.javasprings.springbootEval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserData {

	int uId;
    String name;
    int Scores;
    List <String> interests = new ArrayList();
    
    public UserData(){}
    public UserData(int idd, String Name,List<String> Interests)
    {
    	
    	uId = idd;
    	name = Name;
    	interests = Interests;
    }
    
   
    
	public void setID(int id)
    {
        uId = id;
    }
    public int getID()
    {
        return uId;
    }
    public void setname(String Ln)
    {
        name = Ln;
    }
    public String getname()
    {
        return name;
    }
    public void setInterest(List<String> Interest)
    {
        interests = Interest;
    }
    public List<String> getInterest()
    {
        return interests;
    }
}
