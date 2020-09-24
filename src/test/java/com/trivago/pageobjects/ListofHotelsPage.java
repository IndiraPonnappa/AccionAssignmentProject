package com.trivago.pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ListofHotelsPage {
	WebDriver ldriver;

	public ListofHotelsPage(WebDriver rdriver){
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath="//select[@id='mf-select-sortby']")
	WebElement sortByDropdown;



	public void selectdropdownoptions() throws InterruptedException{
		Select dropdown=new Select(sortByDropdown);
		dropdown.selectByVisibleText("Rating only");
		Thread.sleep(2000);
		System.out.println("Hotels based on rating is listed" );


		List<WebElement> HotelsAfterSorting=ldriver.findElements(By.id("js_item_list_section"));

		for(WebElement hotel:HotelsAfterSorting){

			String hotelList=hotel.getText();
			System.out.println(hotelList);
		}

	}

}

