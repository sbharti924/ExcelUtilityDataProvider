package utils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelDataProvider {

	WebDriver driver = null;
	@BeforeTest
	public void setUpTest(){
		System.setProperty("webdriver.chrome.driver",
				"D:\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}


	@Test(dataProvider ="test1Data")
	public void test1(String username,String password) throws InterruptedException{

		System.out.println(username+" | "+password);

		driver.get("https://opensource-demo.orangehrmlive.com/");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


		driver.findElement(By.id("txtUsername")).sendKeys(username);

		driver.findElement(By.id("txtPassword")).sendKeys(password);
		Thread.sleep(2000);

	} 
	
	@DataProvider(name = "test1Data")
	public Object[][] getData() throws IOException{
		String excelpath = "D:\\JavaProjects\\ExcelutilityDataProvider\\data\\TestData.xlsx";
		Object[][] data= testdata(excelpath,"sheet1");
		return data;
	}

	public Object[][] testdata(String excelpath ,String sheetname) throws IOException{

		excelutils1  excel = new excelutils1(excelpath,sheetname);
		int rowcount =excel.getRowCount();
		int colcount =excel.getColCount();

		Object data[][] = new Object[rowcount-1][colcount];	

		for(int i=1; i<rowcount; i++ ){
			for(int j=0;j< colcount;j++){

				String celldata  =excel.getCellData(i,j);
				System.out.println(celldata);
				data[i-1][j]=celldata;

			}
		}

		return data;

	}

}
