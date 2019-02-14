package com.cukeserp.step_definitions;

import com.cukeserp.pages.CalendarPage;
import com.cukeserp.utilities.Driver;
import com.cukeserp.utilities.Pages;
import cucumber.api.java.en.Given;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import static com.cukeserp.utilities.ApplicationConstants.CALENDAR_PAGE_TITLE;

public class CalendarSteps {
    Pages pages = new Pages();
    WebDriver driver;
    CalendarPage calendarPage;




    @Given ("user is on the Calendar page")
    public void user_is_on_the_Calendar_page() {
        Assert.assertEquals ( Driver.getDriver ( ).getTitle ().trim (), CALENDAR_PAGE_TITLE);
    }

}
