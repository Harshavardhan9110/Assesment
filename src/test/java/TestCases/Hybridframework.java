package TestCases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.mindtree.manager.PageObjectManager;
import com.mindtree.reusable.BaseTest;

import pageobject.AboutUsPage;
import pageobject.AirportPage;
import pageobject.ContactUsPage;
import pageobject.CorporateCarRentalPage;
import pageobject.Homepage;
import pageobject.LocalPage;
import pageobject.OneWayPage;
import pageobject.OutstationPage;
import utility.ExcelSheetRead;
import utility.ExtentReporterNG;
import utility.Logs;


public class Hybridframework extends BaseTest {
	static PageObjectManager pageManager;
	static Homepage homepage;
	static ContactUsPage contactpage;
	static AboutUsPage aboutpage;
	static CorporateCarRentalPage corporatepage;
	static OneWayPage onewaypage;
	static AirportPage airportpage;
	static OutstationPage outstationpage;
	static LocalPage localpage;
	static Logs loggerUtil;
	static Logger log;
	static ExcelSheetRead ex;
	static ExtentReports extent = ExtentReporterNG.extentReportGenerator();
	static String screenshotPath = null;

	@BeforeMethod
	public void Before() throws IOException {
		startUp();
		ex = new ExcelSheetRead(); 
	}

	@Test(priority = 1)
	public static void TestCase1() throws IOException, InterruptedException {
		try {
			test = extent.createTest("test1");
			test.log(Status.PASS, "TestCase Execution Started");
			loggerUtil = new Logs();
			loggerUtil = new Logs();
			log = loggerUtil.createLog("Test1");
			pageManager = new PageObjectManager();
			homepage = pageManager.getHomePage();
			String ExpectedTitle = ex.read("HomepageTitle");
			homepage.ValidateTitle(ExpectedTitle);
			test.log(Status.PASS, "TestCase1 Successful");
			screenshotPath = getscreenshotpath("test1");
			
		} catch (Exception e) {
			screenshotPath = getscreenshotpath("test1");
			test.fail("test1 test failed",MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			test.log(Status.FAIL, "TestCase2 UnSuccessful");
		}
	}

	@Test(priority = 2)
	public static void TestCase2() throws IOException, InterruptedException {
		try {
			test = extent.createTest("test2");
			test.log(Status.PASS, "TestCase Execution Started");
			loggerUtil = new Logs();
			log = loggerUtil.createLog("Test 2");
			pageManager = new PageObjectManager();
			String Name = ex.read("Name");
			String Phone = ex.read("Phone");
			String Email = ex.read("Email");
			String Password = ex.read("Password");
			String RePassword = ex.read("RePassword");
			homepage.SignUp(Name, Phone, Email, Password, RePassword);
			test.log(Status.PASS, "TestCase2 Successful");
		
			screenshotPath = getscreenshotpath("test2");
			
		} catch (Exception e) {
			screenshotPath = getscreenshotpath("test2");
			test.fail("test2 test failed",MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());//df
			test.log(Status.FAIL, "TestCase2 UnSuccessful");
		}
	}

	@Test(priority = 3)
	public static void TestCase3() throws IOException, InterruptedException {
		try {
			
			test = extent.createTest("test3");
			test.log(Status.PASS, "TestCase Execution Started");
			
			loggerUtil = new Logs();
			log = loggerUtil.createLog("Test3");
			pageManager = new PageObjectManager();
			String Email = ex.read("Email");
			String Password = ex.read("Password");
			homepage.Login(Email, Password);
			test.log(Status.PASS, "TestCase3 Successful");
		
			screenshotPath = getscreenshotpath("test3");

			
		} catch (Exception e) {
			screenshotPath = getscreenshotpath("test3");
			test.fail("test3 test failed",MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());//df
			test.log(Status.FAIL, "TestCase3 UnSuccessful");
		}
	}

	@Test(priority = 4)
	public static void TestCase4() throws IOException, InterruptedException {
		try {
			test = extent.createTest("test4");
			test.log(Status.PASS, "TestCase Execution Started");
		
			loggerUtil = new Logs();
			log = loggerUtil.createLog("Test4");
			pageManager = new PageObjectManager();
			aboutpage = pageManager.getAboutUsPage();
			aboutpage.ClickOnAbout();
			aboutpage.Switchtab(1);
			String Expected = ex.read("CEO");
			aboutpage.Validate(Expected);
			test.log(Status.PASS, "TestCase4 Successful");
			extent.flush();
			screenshotPath = getscreenshotpath("test4");
		} catch (Exception e) {
			screenshotPath = getscreenshotpath("test4");
			test.fail("test4 test failed",MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());//df
			test.log(Status.FAIL, "TestCase4 UnSuccessful");
		}
	}

	@Test(priority = 5)
	public static void TestCase5() throws IOException, InterruptedException {
		try {
			test = extent.createTest("test5");
			test.log(Status.PASS, "TestCase Execution Started");
			
			loggerUtil = new Logs();
			log = loggerUtil.createLog("Test5");
			pageManager = new PageObjectManager();
			contactpage = pageManager.getContactUsPage();
			contactpage.ClickOnContactUs();
			contactpage.Switchtab(1);
			String Contact = ex.read("Contact");
			contactpage.Validate(Contact);
			test.log(Status.PASS, "TestCase5 Successful");
			
			screenshotPath = getscreenshotpath("test5");
			
		} catch (Exception e) {
			screenshotPath = getscreenshotpath("test5");
			test.fail("test6 test failed",MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());//df
			test.log(Status.FAIL, "TestCase5 UnSuccessful");
		}

	}

	@Test(priority = 6)
	public static void Testcase6() throws IOException, InterruptedException {
		try {
			test = extent.createTest("test6");
			test.log(Status.PASS, "TestCase Execution Started");
			
			loggerUtil = new Logs();
			log = loggerUtil.createLog("Test6");
			pageManager = new PageObjectManager();
			onewaypage = pageManager.getOneWayPage();
			onewaypage.ClickOnOneWay();
			onewaypage.Switchtab(1);
			onewaypage.SelectAgra();
			onewaypage.SelectPlace();
			onewaypage.Switchtab(2);
			String Expected = ex.read("OneWay");
			onewaypage.ValidatePage(Expected);
			test.log(Status.PASS, "TestCase6 Successful");
			
			screenshotPath = getscreenshotpath("test6");
			
		} catch (Exception e) {
			screenshotPath = getscreenshotpath("test6");
			test.fail("test6 test failed",MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			test.log(Status.FAIL, "TestCase6 UnSuccessful");
		}
	}

	@Test(priority = 7)
	public static void test7() throws IOException, InterruptedException {
		try {
			test = extent.createTest("test7");
			test.log(Status.PASS, "TestCase Execution Started");
			
			loggerUtil = new Logs();
			log = loggerUtil.createLog("Test7");
			pageManager = new PageObjectManager();
			localpage = pageManager.getLocalPage();

			localpage.ClickOnLocal();
			localpage.Switchtab(1);

			String Source = ex.read("Source");
			String Month = ex.read("Month");
			String Date = ex.read("Date").replace(".0", "");
			String Time = ex.read("Time");
			String CarType = ex.read("CarType");

			localpage.SelectSrc(Source);
			localpage.SelectDate(Month, Date);
			localpage.SelectPickuptime(Time);
			localpage.ClickOnSearchCar();
			localpage.SelectFirstCar();
			localpage.ValidateCarDetails(CarType);
			test.log(Status.PASS, "TestCase7 Successful");
		
			screenshotPath = getscreenshotpath("test7");
			
		} catch (Exception e) {
			screenshotPath = getscreenshotpath("test7");
			test.fail("test7 test failed",MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());//df
			test.log(Status.FAIL, "TestCase7 UnSuccessful");	
		}
	}

	@Test(priority = 8)
	public static void test8() throws IOException, InterruptedException {
		try {
			test = extent.createTest("test8");
			test.log(Status.PASS, "TestCase Execution Started");
			
			loggerUtil = new Logs();
			log = loggerUtil.createLog("Test8");
			pageManager = new PageObjectManager();
			String Source = ex.read("Source");
			String Destination = ex.read("Destination");
			String Month = ex.read("Month");
			String Date = ex.read("Date").replace(".0", "");
			String Time = ex.read("Time");
			String Outprice = ex.read("Outprice");

			outstationpage = pageManager.getOutstationPage();
			outstationpage.SelectSrc(Source);
			outstationpage.SelectDest(Destination);
			outstationpage.SelectDate(Month, Date);
			outstationpage.SelectPickuptime(Time);
			outstationpage.ClickOnSearchCar();
			outstationpage.SelectFirstCar();
			outstationpage.ValidateCarDetails(Outprice);
			
			test.log(Status.PASS, "TestCase8 Successful");
			
			screenshotPath = getscreenshotpath("test8");
			
			} catch (Exception e) {
				screenshotPath = getscreenshotpath("test8");
				test.fail("test8 test failed",MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());//df
				test.log(Status.FAIL, "TestCase8 UnSuccessful");	
		}

	}

	@Test(priority = 9)
	public static void test9() throws IOException, InterruptedException {
		try {
			test = extent.createTest("test9");
			test.log(Status.PASS, "TestCase Execution Started");
			
			loggerUtil = new Logs();
			log = loggerUtil.createLog("Test9");
			pageManager = new PageObjectManager();

			String Source = ex.read("Source");
			String AirportDest = ex.read("AirportDest");
			String Month = ex.read("Month");
			String Date = ex.read("Date").replace(".0", "");
			String Time = ex.read("Time");
			String Outprice = ex.read("Outprice");

			airportpage = pageManager.getAirportPage();
			airportpage.ClickOnAirport();
			airportpage.Switchtab(1);
			airportpage.SelectSrc(Source);
			airportpage.SelectTripType();
			airportpage.SelectDest(AirportDest);
			airportpage.SelectDate(Month, Date);
			airportpage.SelectPickuptime(Time);
			airportpage.ClickOnSearchCar();
			airportpage.SelectFirstCar();
			airportpage.ValidateCarDetails(Outprice);
			test.log(Status.PASS, "TestCase9 Successful");
		
			screenshotPath = getscreenshotpath("test9");
			
		} catch (Exception e) {
			screenshotPath = getscreenshotpath("test9");
			test.fail("test9 test failed",MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());//df
			test.log(Status.FAIL, "TestCase9 UnSuccessful");
		}

	}

	@Test(priority = 10)
	public static void test10() throws IOException, InterruptedException {
		try {
			test = extent.createTest("test10");
			test.log(Status.PASS, "TestCase Execution Started");
			
			loggerUtil = new Logs();
			log = loggerUtil.createLog("Test10");
			pageManager = new PageObjectManager();

			String Name = ex.read("Name");
			String Phone = ex.read("Phone");
			String Email = ex.read("Email");
			String Company = ex.read("Company");
			String Req = ex.read("Req");

			corporatepage = pageManager.getCorporateCarRentalPage();
			corporatepage.ClickOnCorporateCarRental();
			corporatepage.Switchtab(1);
			corporatepage.EnterName(Name);
			corporatepage.EnterCompany(Company);
			corporatepage.EnterEmail(Email);
			corporatepage.EnterPhoneNo(Phone);
			corporatepage.SelectRentalReq(Req);
			corporatepage.ClickSubmit();
			corporatepage.ValidateMSG();
			test.log(Status.PASS, "TestCase10 Successful");
		
			screenshotPath = getscreenshotpath("test10");
			
		} catch (Exception e) {
			screenshotPath = getscreenshotpath("test10");
			test.fail("test10 test failed",MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());//df
			test.log(Status.FAIL, "TestCase10 UnSuccessful");	
		}
	}

	@AfterMethod
	public void After() {
		tearDown();
	}
	@AfterTest()
	public void flush() {
		extent.flush();
	}
	

}
