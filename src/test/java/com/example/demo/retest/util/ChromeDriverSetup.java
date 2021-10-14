package com.example.demo.retest.util;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public final class ChromeDriverSetup {

    public static ChromeDriver create() {
        final ChromeOptions opts = new ChromeOptions();
        opts.addArguments(
                // Enable headless mode for faster execution.
                "--headless",
                // Use Chrome in container-based environments.
                "--no-sandbox", "--disable-dev-shm-usage",
                // Fix window size for stable results.
                "--window-size=1200,800" );
        return new ChromeDriver( opts );
    }

}
