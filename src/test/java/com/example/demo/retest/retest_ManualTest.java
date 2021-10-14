package com.example.demo.retest;

import com.example.demo.PersonController;
import com.example.demo.retest.util.ChromeDriverSetup;
import de.retest.recheck.Recheck;
import de.retest.recheck.RecheckImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class retest_ManualTest {

    @LocalServerPort
    private int port;

    private WebDriver driver;
    private Recheck re;

    @Autowired
    private PersonController controller;

    @BeforeEach
    public void setup() {
        driver = ChromeDriverSetup.create();
        re = new RecheckImpl();
    }

    @Test
    public void contextLoads() {
        assertThat(controller).isNotNull();
    }

    /**
     * This test should find an error when combining a ReCheck Project with a Spring Project. The cause is
     * that spring still uses javax.xml.bind while ReCheck is already using jakarta.xml.bind.
     */
    @Test
    public void customTestOfLocalSpringApplication() {
        re.startTest();

        driver.get("http://localhost:" + port + "/");

        re.check(driver, "customGM");

        driver.findElement(By.id("firstname")).sendKeys("Hans");
        driver.findElement(By.id("lastname")).sendKeys("Wurst");

        re.capTest();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
        re.cap(); // Finishes recheck and persists the test report. Starting the review GUI is sensible
    }

}
