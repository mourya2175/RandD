package util;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import experiment.Facebook;

public class MyListener implements WebDriverEventListener{

	public void afterChangeValueOf(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterClickOn(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	
	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	
	public void afterNavigateBack(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	
	public void afterNavigateForward(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	
	public void afterNavigateTo(String url, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	
	public void afterScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	
	public void beforeChangeValueOf(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	
	public void beforeClickOn(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	
	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		
		UUID sc = UUID.randomUUID();
		
		if(Facebook.highlight)
		{
		WebElement elem = driver.findElement(by);
		// draw a border around the found element
		if (driver instanceof JavascriptExecutor) {
		   ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='2px solid red'", elem);
		   //((JavascriptExecutor)driver).executeScript("arguments[0].setAttribute('style', arguments[1]);", elem, "color: yellow; border: 2px solid yellow;"); 
		}
		}
		//Capture screenshot
		if(Facebook.screenshot)
		{
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		// Now you can do whatever you need to do with it, for example copy somewhere
		try {
			 
			FileUtils.copyFile(scrFile, new File("Screenshots\\"+Facebook.screenshotFolder+"\\"+sc+".jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
		
	

	
	public void beforeNavigateBack(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	
	public void beforeNavigateForward(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	
	public void beforeNavigateTo(String url, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	
	public void beforeScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void onException(Throwable throwable, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	

}