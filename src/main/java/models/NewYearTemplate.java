package models;

import java.time.LocalDateTime;

public class NewYearTemplate extends Template  {

	private String year;

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		
	   int y =	Integer.parseInt(year); 
	  int yeardiffer = y- LocalDateTime.now().getYear();
		if( yeardiffer ==0 | yeardiffer==1 )
			this.year = year;
	}
}
