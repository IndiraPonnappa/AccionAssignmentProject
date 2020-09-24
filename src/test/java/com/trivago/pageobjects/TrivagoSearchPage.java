package com.trivago.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrivagoSearchPage {
	WebDriver ldriver;

	public TrivagoSearchPage (WebDriver rdriver){

		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id="querytext")
	WebElement Searchtxtbox;

	@FindBy(xpath="/html/body/div[3]/div[2]/div[4]/div/div[1]/form/div/button[2]")
	WebElement SearchButton;

	@FindBy(xpath="//button[@class='dealform-button js-dealform-button-calendar dealform-button--checkin']")
	WebElement CheckinButton;

	@FindBy(id="cal-heading-month")
	WebElement ChkincalendarMonth;

	@FindBy(xpath="//span[@class='icon-ic cal-btn-ic icon-rtl']")
	WebElement calendarChckinArrow;

	@FindBy(id="cal-heading-month")
	WebElement ChkoutcalendarMonth;


	@FindBy(xpath="//button[@class='cal-btn-next']")
	WebElement calendarChckoutArrow;


	@FindBy(xpath="/html[1]/body[1]/div[3]/div[2]/div[4]/div[1]/div[1]/form[1]/div[1]/div[3]/button[3]")
	WebElement CheckOutButton;

	@FindBy(xpath="/html/body/div[3]/div[2]/div[4]/div/div[1]/form/div/button[1]")
	WebElement GuestSelector;


	public void setSearchText(String cityName){
		Searchtxtbox.sendKeys(cityName);

	}
	public void SearchBtn(){
		SearchButton.click();

	}

	public void chkInBtn() throws InterruptedException{
		String chkinmonth="December 2020";
		String inDate="5";

		CheckinButton.click();
		Thread.sleep(2000);

		while(true){

			String text=ChkincalendarMonth.getText();
			if(text.equals(chkinmonth)){
				break;
			}
			else{
				calendarChckinArrow.click();
			}

		}

		List<WebElement> allDates=ldriver.findElements(By.xpath("/html[1]/body[1]/div[3]/div[2]/div[4]/div[1]/div[1]/form[1]/div[1]/div[4]/div[2]/div[1]/table[1]/tbody[1]/tr/td/time[1]"));
		for(WebElement chkindate:allDates){

			String dateofchkin=chkindate.getText();

			if(dateofchkin.equals(inDate)){
				chkindate.click();
				break;
			}
		}


	}
	public void chkOutBtn() throws InterruptedException{
		String Chkoutmonth="December 2020";
		String outDate="25";

		CheckOutButton.click();
		Thread.sleep(2000);

		/*while(true){

			String text=ChkoutcalendarMonth.getText();
			if(text.equals(Chkoutmonth)){
				break;
			}
			else{
				calendarChckoutArrow.click();
			}

		}

		List<WebElement> allDates=ldriver.findElements(By.xpath("/html[1]/body[1]/div[3]/div[2]/div[4]/div[1]/div[1]/form[1]/div[1]/div[4]/div[2]/div[1]/table[1]/tbody[1]/tr/td/time[1]"));
		for(WebElement chkoutdate:allDates){

			String dateofchkOut=chkoutdate.getText();

			if(dateofchkOut.equals(outDate)){
				chkoutdate.click();
				break;
			}
		}*/

	}
	public void selectGuests() throws InterruptedException{
		GuestSelector.click();
		Thread.sleep(2000);

		List<WebElement> allguestType=ldriver.findElements(By.xpath("/html/body/div[3]/div[2]/div[4]/div/div[1]/form/div/div[4]/fieldset/div"));
		for(WebElement guestType:allguestType){
			String TypeofGuest=guestType.getText();
			
			if(TypeofGuest.contains("Adult")){
				WebElement Adultbutton=ldriver.findElement(By.xpath("//body//div[@id='js-fullscreen-hero']//div//div//div//div//div[1]//div[1]"));	
				Adultbutton.click();
				WebElement Adult_input=ldriver.findElement(By.id("adults-input"));
				if(Adult_input.equals(2)){
					WebElement Applybutton=ldriver.findElement(By.xpath("//div[@id='js-fullscreen-hero']//div//form//div//div//button[contains(text(),'Apply')]"));
					Applybutton.click();
					break;
				}
				else{
					
					if(Adult_input.equals(0)){
						WebElement plusbutton=ldriver.findElement(By.xpath("//body//div[@id='js-fullscreen-hero']//div//div//div//div//div[1]//div[1]//button[2]"));
						plusbutton.click();
					}
				}
					
				
			}

		}
	}
}


