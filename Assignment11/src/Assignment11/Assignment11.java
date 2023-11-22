package Assignment11;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Assignment11 
{


	public static void main(String[] args) throws InterruptedException, IOException 
	{
		
        
	ChromeOptions CO = new ChromeOptions();

	CO.addArguments("--remote-allow-origins=*","ignore-certificate-errors");
	CO.addArguments("start-maximized");

	WebDriver driver = new ChromeDriver(CO);

	 // Navigate to the given URL
    driver.get("https://testpages.herokuapp.com/styled/tag/dynamic-table.html");

   
        Thread.sleep(2000);
    // Step 2: Click on the Table Data button
        WebElement tableDataButton = driver.findElement(By.xpath("//*[text()='Table Data']"));
        tableDataButton.click();

        
        Thread.sleep(2000);
        
        // Step 3: Insert the provided data into the input text box
        WebElement dataInput = driver.findElement(By.xpath("//*[@id='jsondata']"));
        dataInput.clear();
        String jsonData = "[{\"name\" : \"Bob\", \"age\" : 20, \"gender\": \"male\"}, {\"name\": \"George\", \"age\" : 42, \"gender\": \"male\"}, {\"name\":\r\n" + 
        		"\"Sara\", \"age\" : 42, \"gender\": \"female\"}, {\"name\": \"Conor\", \"age\" : 40, \"gender\": \"male\"}, {\"name\":\r\n" + 
        		"\"Jennifer\", \"age\" : 42, \"gender\": \"female\"}]";
       
        dataInput.sendKeys(jsonData);
 
        Thread.sleep(2000);       
        // Click on the Refresh Table button
        WebElement refreshButton = driver.findElement(By.xpath("//*[text()='Refresh Table']"));
        refreshButton.click();

      
        Thread.sleep(10000);

    
        // Close the browser
        driver.quit();
    }

}
