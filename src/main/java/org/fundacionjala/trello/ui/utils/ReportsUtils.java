package org.fundacionjala.trello.ui.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ReportsUtils {

    public static void takeScreenShot(final WebDriver driver, final String filePath) throws IOException {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
        File targetFile = new File(filePath);
        FileUtils.copyFile(srcFile, targetFile);

    }
}
