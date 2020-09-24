package com.trivago.testcases;

import org.testng.annotations.Test;

import com.trivago.pageobjects.ListofHotelsPage;
import com.trivago.pageobjects.TrivagoSearchPage;

public class TC_SelectfromHotelList_002 extends BaseClass {
	
	@Test
	public void sortHotels() throws InterruptedException{
		TrivagoSearchPage tsp= new TrivagoSearchPage(driver);
		tsp.setSearchText(cityName);
		logger.info("Entered the city");
		
		tsp.chkInBtn();
		logger.info("Selected checkin date");
		tsp.chkOutBtn();
		logger.info("Selected checkout date");
		tsp.selectGuests();
		logger.info("Inside guestselector");
		
		tsp.SearchBtn();
		logger.info("Clicked on search button");
		
		ListofHotelsPage lhp=new ListofHotelsPage(driver);
		lhp.selectdropdownoptions();
		logger.info("Hotels are sorted based on the rating");
	}

}
