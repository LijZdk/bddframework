package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.testng.Assert;

import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

public class GovLandingStepDefs {

    public WebDriver driver;

    public GovLandingStepDefs(){

        driver = Hooks.driver;
    }

    @Given("^I am on the \"([^\"]*)\" page on Url \"([^\"]*)\"$")
    public void iAmOnThePageOnUrl(String arg0, String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.get("https://www.gov.uk/get-vehicle-information-from-dvla");
    }


    @And("^I see the \"([^\"]*)\" landing page$")
    public void ISeeTheLandingPage(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
       driver.getTitle().equals("Get vehicle information from DVLA - GOV.UK");
    }

    @Given("^I select \"([^\"]*)\" to proceed to next page$")
    public void iSelectToProceedToNextPage(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.xpath("//*[@id=\"get-started\"]/a")).click();
}


    @Then("^I see the \"([^\"]*)\" text box$")
    public void iSeeTheTextBox(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"Vrm\"]")).click();
    }

    @And("^I read from a excel spreadsheet to provide a registration number$")
    public void iReadFromAExcelSpreadsheetToProvideARegistrationNumber() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        FileInputStream file = new FileInputStream(new File("/Users/Elijah/Documents/bddframework/VehicleReg.xlsx"));
        XSSFWorkbook wb = new XSSFWorkbook(file);
        XSSFSheet sheet = wb.getSheetAt(0);
        String text = sheet.getRow(1).getCell(0).getStringCellValue();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"Vrm\"]")).clear();
        driver.findElement(By.xpath("//*[@id=\"Vrm\"]")).sendKeys(text);
        driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/div[2]/fieldset/button")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Assert.assertTrue(driver.getPageSource().contains("MERCEDES"));
        Assert.assertTrue(driver.getPageSource().contains("SILVER"));
    }

    @Then("^I take a screenshot$")
    public void iTakeAScreenshot() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        File scrFile = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File(
                "img.jpg"));
    }

    @And("^Go back to enter another registration number$")
    public void goBackToEnterAnotherRegistrationNumber() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.id("Correct_False")).click();
        driver.findElement(By.xpath("//*[@id=\"pr3\"]/div/button")).click();
    }

    @Then("^I read from a excel spreadsheet to provide a another registration number$")
    public void iReadFromAExcelSpreadsheetToProvideAAnotherRegistrationNumber() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        FileInputStream file = new FileInputStream(new File("/Users/Elijah/Documents/bddframework/VehicleReg.xlsx"));
        XSSFWorkbook wb = new XSSFWorkbook(file);
        XSSFSheet sheet = wb.getSheetAt(0);
        String text = sheet.getRow(2).getCell(0).getStringCellValue();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"Vrm\"]")).clear();
        driver.findElement(By.xpath("//*[@id=\"Vrm\"]")).sendKeys(text);
        driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/div[2]/fieldset/button")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Assert.assertTrue(driver.getPageSource().contains("VOLKSWAGEN"));
        Assert.assertTrue(driver.getPageSource().contains("SILVER"));
    }

    @Then("^I take another screenshot$")
    public void iTakeAnotherScreenshot() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        File scrFile = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File(
                "img2.jpg"));
    }
}
