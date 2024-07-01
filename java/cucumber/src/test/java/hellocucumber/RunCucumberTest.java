package hellocucumber;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Suite
@IncludeEngines("cucumber")
@SelectPackages("hellocucumber")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty")
public class RunCucumberTest {

    private static final Map<String, WebDriver> driverMap = new ConcurrentHashMap<>();

    private static final ThreadLocal<String> currentBrowserTag = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return driverMap.get(currentBrowserTag.get());
    }

    @Before
    public void setup(Scenario scenario) throws MalformedURLException {
        String browserTag = getBrowserTag(scenario);

        // If the browser is already open, reuse it
        if (driverMap.containsKey(browserTag)) {
            currentBrowserTag.set(browserTag);
            return;
        }

        Capabilities capabilities = new DesiredCapabilities();

        switch (browserTag) {
            case "@chrome":
                capabilities = new ChromeOptions()
                        .setBrowserVersion("102.0")
                        .addArguments("--headless", "--disable-gpu");
                break;
            case "@edge":
                capabilities = new EdgeOptions()
                        .setBrowserVersion("101.0")
                        .addArguments("--headless", "--disable-gpu");
                break;
        }

        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444"), capabilities);
        driverMap.put(browserTag, driver);
        currentBrowserTag.set(browserTag);
    }

    @After
    public void tearDown(Scenario scenario) {
        String browserTag = getBrowserTag(scenario);
        WebDriver driver = driverMap.get(browserTag);
        if (driver != null) {
            driver.quit();
            driverMap.remove(browserTag);
        }
    }

    private static String getBrowserTag(Scenario scenario) {
        return scenario.getSourceTagNames().stream()
                .filter(tag -> tag.startsWith("@"))
                .findFirst()
                .orElse("@chrome");
    }
}
