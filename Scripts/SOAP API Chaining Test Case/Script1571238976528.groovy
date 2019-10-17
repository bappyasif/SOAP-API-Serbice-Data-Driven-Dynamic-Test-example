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

//countriesListByName = WS.sendRequest(findTestObject('Country Info SOAP Service/Get Capital City SOAP Request', [('countryISO') : 'BD']))
countriesListByName = WS.sendRequest(findTestObject('Country Info SOAP Service/Countries List SOAP Request'))

// Rain Check
println('Code Extracted : ' + GlobalVariable.CountryISOCode)

// String Conteents Of Countries List Form API Request
String xmlResponseForCountryName = countriesListByName.responseBodyContent

// Parsing Text For Intended Data
def countries_list = new XmlSlurper().parseText(xmlResponseForCountryName)

// Passing On Country Code Extracted
def country_code = countries_list.ListOfCountryNamesByNameResult.tCountryCodeAndName[0].sISOCode.text()

// Rain Check
println('Code Extracted : ' + country_code)

// Global Varible Value Updated
GlobalVariable.CountryISOCode = country_code

// Rain Check
println('Code Extracted : ' + GlobalVariable.CountryISOCode)

countriesCapital = WS.sendRequest(findTestObject('Country Info SOAP Service/Get Capital City SOAP Request', [('countryISO') : GlobalVariable.CountryISOCode]))

// Extracting Text
String xmlResponseForCapital = countriesCapital.responseBodyContent

// Parsing xmlResponse
def country_capital = new XmlSlurper().parseText(xmlResponseForCapital)

// Rain Check
println ("Capital Name : "+country_capital)

