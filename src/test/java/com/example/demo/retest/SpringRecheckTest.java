package com.example.demo.retest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import com.example.demo.retest.util.ChromeDriverSetup;

import de.retest.web.selenium.RecheckDriver;

@SpringBootTest( webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT )
public class SpringRecheckTest {

	@LocalServerPort
	private int port;

	private WebDriver driver;

	@BeforeEach
	public void setup() {
		driver = new RecheckDriver( ChromeDriverSetup.create() );
	}

	/**
	 * This test should find an error when combining a ReCheck Project with a Spring Project. The cause is that spring
	 * still uses javax.xml.bind while ReCheck is already using jakarta.xml.bind.
	 */
	@Test
	public void customTestOfLocalSpringApplication() {
		driver.get( "http://localhost:" + port + "/" );
		// RecheckDriver automatically call recheck after each driver interaction

		driver.findElement( By.id( "firstname" ) ).sendKeys( "Hans" );
		driver.findElement( By.id( "lastname" ) ).sendKeys( "Wurst" );
	}

	@AfterEach
	public void tearDown() {
		driver.quit();
	}

}
