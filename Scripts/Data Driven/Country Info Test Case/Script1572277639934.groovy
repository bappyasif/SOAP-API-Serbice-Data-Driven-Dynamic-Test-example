import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable


println("Country Code : "+country_code)

println("Capital City : "+capital_city)

println("Currency Name : "+currency_name)

capitalCity = WS.sendRequest(findTestObject('Country Info SOAP Service/Get Capital City SOAP Request', [('countryISO') : country_code]))

WS.verifyElementText(capitalCity, 'CapitalCityResponse.CapitalCityResult', capital_city)

currencyName = WS.sendRequest(findTestObject('Country Info SOAP Service/Get Currency Name Request', [('countryISOCode') : country_code]))

WS.verifyElementText(currencyName, 'CountryCurrencyResponse.CountryCurrencyResult.sName', currency_name)

