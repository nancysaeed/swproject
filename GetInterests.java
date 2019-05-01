package io.javasprings.springbootEval;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.stream.DoubleStream.builder;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import static org.json.JSONPointer.builder;

@Service
public class GetInterests {

	StringBuffer response = new StringBuffer();
    String responseInString = new String();
    JSONObject jsonResult;
    BufferedReader in;
    String readLine = null;
    List<String> intersts = new ArrayList();
    UserData user = new UserData();
    CompanyData comp = new CompanyData();
    ArrayList<CompanyData> ListOfcompany = new ArrayList();
    ArrayList<UserData> ListOfAllUsers = new ArrayList();
	
    List<CompanyData> FinalCom = new ArrayList();
    List<String> ListCI = new ArrayList();
    UserData Finaluser = new UserData();
    List<QuizData> AllQuizs = new ArrayList();
    Interests_Scores interest_score = new Interests_Scores();
    
	public void UserGETRequest(String s1) throws IOException {

        URL urlForGetRequest = new URL(s1);
        HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
        conection.setRequestMethod("GET");
        conection.setRequestProperty("userId", "a1bcdef"); // set userId its a sample here
        int responseCode = conection.getResponseCode();
        
        if (responseCode == HttpURLConnection.HTTP_OK) {
            in = new BufferedReader(new InputStreamReader(conection.getInputStream()));
            String line = "";
            while ((line = in.readLine()) != null) 
            {
                responseInString += line;
            }           
        }
        else 
        {
            System.out.println("GET NOT WORKED");
        }                                                 
	}
	
	//**************Get one User interests from API***************
	String readAll(Reader rd) throws IOException {
		   
	    StringBuilder sb = new StringBuilder();
	    int cp;
	    while ((cp = rd.read()) != -1) {
	      sb.append((char) cp);
	    }
	    return sb.toString();
	  }
	public UserData OutUserGETRequest() throws IOException {
		
		InputStream is = new URL("http://www.mocky.io/v2/5cc6fc5f3200008734b95000").openStream();
	    
	      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
	      String jsonText = readAll(rd);
	      JSONObject json = new JSONObject(jsonText);
	      JSONArray JArray = json.getJSONArray("user");
	        
	      jsonResult = (JSONObject)JArray.getJSONObject(0);
	    
		String n = jsonResult.getString("username");
      user.setname(n);
      JSONArray InterestsInString = jsonResult.getJSONArray("Interests");      
      String[] arr=new String[InterestsInString.length()];
      for(int i=0; i<arr.length; i++) {
          arr[i]=InterestsInString.optString(i);
      } 
      
      List<String> list = new ArrayList();
      for (String str : arr) 
      {
      	list.add(str.toUpperCase());
      }
      user.setInterest(list);
      return user;
      
	}
	//**************Get one company********************
	public Interests_Scores OutonecompanyGETRequest() throws IOException {
		
		InputStream is = new URL("http://www.mocky.io/v2/5cc6d38f3200008219b94e84").openStream();
	    
	      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
	      String jsonText = readAll(rd);
	      JSONObject json = new JSONObject(jsonText);
	      JSONArray JArray = json.getJSONArray("company");
	        
	      jsonResult = (JSONObject)JArray.getJSONObject(0);
	    
	      String n = jsonResult.getString("username");
	      interest_score.setname(n);
	      JSONArray InterestsInString = jsonResult.getJSONArray("Interests");  
	      String[] arr=new String[InterestsInString.length()];
	      for(int i=0; i<arr.length; i++) 
	      {
	    	  arr[i]=InterestsInString.optString(i);          
	      } 
	  
	      List<String> list = new ArrayList();
	      for (String str : arr) 
	      {
	    	  list.add(str.toUpperCase());
	      }
	      interest_score.setInterests((ArrayList)list);
	      JSONArray ScoresInString = jsonResult.getJSONArray("requiredScore");
	      ArrayList<Integer>scores =new ArrayList();
	      for(int i=0; i<arr.length; i++) 
	      {
	    	  scores.add(ScoresInString.optInt(i));          
	      } 
	      interest_score.setScore(scores);
	      return interest_score;
	    
	}
	
	//**************Get companies interests from API***************
	public List<CompanyData> OutCompanyGETRequest() throws IOException {
		
		
		UserGETRequest("http://www.mocky.io/v2/5cbd0b912f00005f0116cb8a");
		//"Front_End_Development","Machine_earning"
		JSONObject json = new JSONObject(responseInString);
	    JSONArray JArray = json.getJSONArray("company");
	    String cname = "";
        for(int i=0 ; i<JArray.length() &&  JArray != null ; i++)
        {
            JSONObject  Jobject = (JSONObject) JArray.getJSONObject(i);
            
            CompanyData company = new CompanyData();
            cname = (String) Jobject.get("username");
            company.setCompName(cname);
            JSONArray InterestsInString = Jobject.getJSONArray("Interests");      
            String[] arr=new String[InterestsInString.length()];
            for(int j=0; j<arr.length; j++) {
                arr[j]=InterestsInString.optString(j);
            } 
          //to convert company lists of interests into uppercase 
            
            List<String> list = new ArrayList();
            for (String str : arr) 
            {
            	list.add(str.toUpperCase());
            }
            	company.setInterest(list);
            	ListOfcompany.add(company);
        }
      
        return ListOfcompany;
	}
	//**************Get All Users Data*******************
	public List<UserData> OutAllUsersGETRequest() throws IOException {
		
		
		UserGETRequest("http://www.mocky.io/v2/5cc6efbe320000661ab94fa8");
		//"Front_End_Development","Machine_earning"
		JSONObject json = new JSONObject(responseInString);
	    JSONArray JArray = json.getJSONArray("user");
	    
	    for(int i=0 ; i<JArray.length() && JArray != null ; i++)
        {
            JSONObject  Jobject = (JSONObject) JArray.getJSONObject(i);
            
            UserData user = new UserData();
            String name = (String) Jobject.get("username");
            user.setname(name);
            JSONArray InterestsInString = Jobject.getJSONArray("Interests");      
            String[] arr=new String[InterestsInString.length()];
            for(int j=0; j<arr.length; j++) {
                arr[j]=InterestsInString.optString(j);
            } 
          //to convert company lists of interests into uppercase 
            
            List<String> list = new ArrayList();
            for (String str : arr) 
            {
            	list.add(str.toUpperCase());
            }
            	user.setInterest(list);
            	ListOfAllUsers.add(user);
        }
	    
	    return ListOfAllUsers;
	}
	
		//AllQuizData
	
	//**************Get All Quizes from API***************
		public List<QuizData> OutQuizesGETRequest() throws IOException {
			
			UserGETRequest("http://www.mocky.io/v2/5cc6fb543200008734b94ff2");
			
			JSONArray JArray =new JSONArray(responseInString);
	        
	        for(int i=0 ; i<JArray.length() &&  JArray != null ; i++)
	        {
	            JSONObject  Jobject = (JSONObject) JArray.getJSONObject(i);
	            
	            QuizData Quiz = new QuizData();
	            String QuizTitle = (String) Jobject.get("Title");
	            Quiz.setTitle(QuizTitle);
	            String quizSkillType = (String) Jobject.get("SkillType");
	            Quiz.setSkillType(quizSkillType.toUpperCase());
	            AllQuizs.add(Quiz);
	        }
	      
	        return AllQuizs;
		}
		//**************Get Data of users who take Quizes from API***************
		List<AllQuizData> all  = new ArrayList();
		public List<AllQuizData> OutinfoQuizGETRequest() throws IOException {
			
			UserGETRequest("http://www.mocky.io/v2/5cc83b763000006500056067");
			JSONArray JArray =new JSONArray(responseInString);
	        
	        for(int i=0 ; i<JArray.length() &&  JArray != null ; i++)
	        {
	            JSONObject  Jobject = (JSONObject) JArray.getJSONObject(i);
	            AllQuizData Quiz = new AllQuizData();
	            String QuizTitle = (String) Jobject.get("Title");
	            Quiz.setTitle(QuizTitle);
	            String quizSkillType = (String) Jobject.get("SkillType");
	            Quiz.setSkillType(quizSkillType.toUpperCase());
	            String un = (String) Jobject.get("ID");
	            Quiz.setuname(un);
	            int sc = (int) Jobject.get("Score");
	            Quiz.setScore(sc);
	            all.add(Quiz);
	        }
	        
	        return all;
				
		}
				
}
