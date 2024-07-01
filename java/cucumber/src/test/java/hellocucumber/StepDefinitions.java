package hellocucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class StepDefinitions {

    @Given("the user is on the Google search page")
    public void theUserIsOnTheGoogleSearchPage() {
        RunCucumberTest.getDriver().get("https://www.google.com");
    }

    @When("the user searches for {string}")
    public void theUserSearchesFor(String searchTerm) {
        WebElement searchBox = RunCucumberTest.getDriver().findElement(By.name("q"));
        searchBox.sendKeys(searchTerm);
        searchBox.submit();
    }

    @Then("the search results page should contain {string}")
    public void theSearchResultsPageShouldContain(String expectedResult) {
        assertTrue(RunCucumberTest.getDriver().getPageSource().contains(expectedResult));
    }
}
