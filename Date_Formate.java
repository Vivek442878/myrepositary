package com.velociters.chapter4;

public class Date_Formate 
{

	public static void main(String[] args)
	{
		    String dates[]=new String[12];  //for storing 10 dates value
			String	monthName []= {"January","February","March","Aprail","May","June","July","August","September","october","November","December"};
			int daysInMonth[]={31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
			    
			    String separator="/";
			   // int day = 0;
			    int month = 0;       //initial value of month is 0
			    int year = 0;
			    int daysIncrement=0;
			    int monthArr[]=new int[monthName.length];// for storing random value of month 
			    
			    for(int i = 0 ; i < dates.length ; i++)
			    	
			        {
			               year = (int)(100.0*Math.random());           //Random year value                  
			               month = (int)(12.0*Math.random())+1;         //Random month value
			               monthArr[i]=month;                           //it store all the value of the month from user
			               
			               //if year is leap year then we have to increment 1 in feb month
			               daysIncrement = (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) && (month == 2) ? 1 : 0 ;
			        
			               day = (int)(Math.random()*(daysInMonth[month-1] + daysIncrement))+1 ;
			        
			               dates[i] = "" + month + separator + day + separator + (year<10 ? "0" :"") + year;
			                System.out.println("Day is " + dates[i]);
			        }  
			    
			       int start = 0;                                                     // Word start index
			       int end = 0;                                                       // Word end index
			    
			       String dayStr="";
			       String monthStr="";
			       String yearStr="";
			       String ending="th";
			       int index=0;
			       System.out.println();
			       
			       for(String date : dates)
			       {
			         // Extract the day, month and year strings using the familiar method.
			    	  
			         start = 0;
			         end = date.indexOf(separator,start);
			         monthStr = date.substring(start, end);
			         start = end + 1;
			         end = date.indexOf(separator,start);
			         dayStr = date.substring(start, end);
			         start = end + 1;
			         yearStr = date.substring(start);
			         
			         if(dayStr.length() == 1)           //if length of day is 1 then we have to select these option and
			                                        	//then append single space for alignment
			        	 
			             switch(dayStr.charAt(0))       //then append single space for alignment
			             {
			               case '1':
			                 ending = "st ";           
			                 break;
			               case '2':
			                 ending = "nd ";
			                 break;
			               case '3':
			                 ending = "rd ";
			                 break;
			               default:
			                 ending = "th ";            //if dayStr is greater than 3 then we have to append th and single space
			             }
			         
			         else if(dayStr.charAt(0) == '1')   
			             ending = "th";                 //if the length of dayStr is more than 1 and the first digit is 1 then append th ex. 11th 12th etc
			           else
			             switch(dayStr.charAt(1))      //if the length of daystr is more than 1 but first digit is not 1 then append th after 23rd ex 21st 22nd ,23rd,24th,25th etc
			             {                             //same of 
			               case '1':
			                 ending = "st";
			                 break;
			               case '2':
			                 ending = "nd";
			                 break;
			               case '3':
			                 ending = "rd";
			                 break;
			               default:
			                 ending = "th";
			             }
     
			               
			               
			        	   StringBuilder sb= new StringBuilder();
			        	   
			        	   int maxLength=(monthName[8].length())+7;       //It gives the maximum length of month is september
			        	   
			        	   int lengthOfMonth=(monthName[monthArr[index]-1]).length();
			        
			        	   int total=5+lengthOfMonth;  //add 5 in each length of month for 3rd-- or 10th- Dates
			        	
			        	   
			        	   int space=maxLength-total;            //subtract the maxLength and total that will give how many extra space we have to print
			        			   
					
							
					
							for(int k=1;k<space;k++)
							{
								sb.append(" ");
							}
							index=index+1;
			           
			        
					//		monthStr.length() == 1 ? monthStr.charAt(0) - '1': 9 + monthStr.charAt(1) - '0'  t
					//		it is ternary condition if monthStr.length() is 1 then subtract with '1' with ascii value ex '1'-'1' ,48-48=0;
					//		if monthStr.charAt.length() !=1 then add  9 in monthStr.charAt(0) with ascii and subtract ascii of 0 ex. 11 charAt(0)=1; add 9+49-48=10
			    
			              System.out.println(dayStr + ending + " " +
			              monthName[monthStr.length() == 1 ? monthStr.charAt(0) - '1': 9 + monthStr.charAt(1) - '0'] +
			              sb+"19" + yearStr);
			       
			       }
		}
		
}




