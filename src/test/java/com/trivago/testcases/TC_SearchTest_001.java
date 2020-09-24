package com.trivago.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.trivago.pageobjects.TrivagoSearchPage;

public class TC_SearchTest_001 extends BaseClass {
	
	@Test
	public void searchHotels() throws IOException, InterruptedException{
		logger.info("Navigated to the url");
		if(driver.getTitle().equals("trivago.in - Compare hotel prices worldwide")){

			Assert.assertTrue(true);
			logger.info("Login successfull");
		}
		else
		{
			captureScreen(driver,"SearchHotelsTest");
			Assert.assertTrue(false);
			logger.info("Search failed");
		}
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
		
		
		
		
		
	}

}
