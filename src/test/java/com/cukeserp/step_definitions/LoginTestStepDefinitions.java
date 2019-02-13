package com.cukeserp.step_definitions;

import com.cukeserp.utilities.ConfigurationReader;
import com.cukeserp.utilities.Driver;
import com.cukeserp.utilities.Pages;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.cukeserp.utilities.ApplicationConstants.*;
import static com.cukeserp.utilities.BrowserUtils.waitForClickablility;
import static com.cukeserp.utilities.BrowserUtils.waitUntilTitleEquals;

public class LoginTestStepDefinitions {

    @Given ("user is on the login page")
    public void user_is_on_the_login_page() {
        String url = ConfigurationReader.getProperties ( "url" );
        Driver.getDriver ().get ( url );
    }

    @When ("user logs in as manager")
    public void user_logs_in_as_manager() {
        Pages pages = new Pages();
        waitForClickablility ( pages.getLandingPage ().BriteErpDemo_button, 15 );
        pages.getLandingPage ().BriteErpDemo_button.click ();
        pages.getLoginPage ().managerLogin ();
    }

    @Then ("breadcrumb is displayed")
    public void breadcrumb_is_displayed() {
        Pages pages = new Pages();
        waitForVisibility ( pages.getInboxPage ().inboxBreadCrumb, 10 );
        Assert.assertEquals ( pages.getInboxPage ().inboxBreadCrumb.getAttribute ( "innerText").trim (), INBOX_BREADCRUMB );
    }

    @Then ("the title should be correct")
    public void the_title_should_be_correct() {
        waitUntilTitleEquals(15,DISCUSS_PAGE_TITLE);
        Assert.assertEquals (Driver.getDriver ().getTitle ().trim (),  DISCUSS_PAGE_TITLE );
    }

    @When("user logs in as general user")
    public void user_logs_in_as_general_user() {
        Pages pages = new Pages();
        waitForClickablility ( pages.getLandingPage ().BriteErpDemo_button, 15 );
        pages.getLandingPage ().BriteErpDemo_button.click ();
        pages.getLoginPage ().userLogin ();
    }

    @Then("the user is logged in")
    public void the_user_is_logged_in() {
        Pages pages = new Pages();
        pages.getHeaderPage ().calendar_button.click ();
        waitUntilTitleEquals(15, CALENDAR_PAGE_TITLE);
        Assert.assertEquals(Driver.getDriver ().getTitle ().trim(), CALENDAR_PAGE_TITLE );
    }


    public static WebElement waitForVisibility( WebElement element, int timeToWaitInSec) {
        WebDriverWait wait = new WebDriverWait( Driver.getDriver(), timeToWaitInSec);
        return wait.until( ExpectedConditions.visibilityOf( element));
    }
}
