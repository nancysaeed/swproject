package io.javasprings.springbootEval;

public class AllQuizData {
	
	String Title;
    String SkillType;
    String username;
    int score;
    
 public AllQuizData(){}
 
 public void setTitle(String cn)
 {
     Title = cn;
 }
 public String getTitle()
 {
     return Title;
 }
 public void setuname(String cn)
 {
	 username = cn;
 }
 public String getuname()
 {
     return username;
 }
 
 public void setSkillType(String Skill)
 {
     SkillType  = Skill;
 }
 public String getSkillType()
 {
     return SkillType ;
 }
 public void setScore(int s)
 {
	 score = s;
 }
 public int getscore()
 {
	 return score;
 }

}
