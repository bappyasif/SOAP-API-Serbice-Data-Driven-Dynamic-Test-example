<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description>Get Currency Name Using SOAP API Request</description>
   <name>Currency Name SOAP Request</name>
   <tag></tag>
   <elementGuidId>b40d569e-6de7-4891-a91a-61ce239da50d</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent></httpBodyContent>
   <httpBodyType></httpBodyType>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Authorization</name>
      <type>Main</type>
      <value>${authorization}</value>
   </httpHeaderProperties>
   <restRequestMethod></restRequestMethod>
   <restUrl></restUrl>
   <serviceType>SOAP</serviceType>
   <soapBody>&lt;Envelope xmlns=&quot;http://schemas.xmlsoap.org/soap/envelope/&quot;>
    &lt;Body>
        &lt;CountryCurrency xmlns=&quot;http://www.oorsprong.org/websamples.countryinfo&quot;>
            &lt;sCountryISOCode>${countryISOCode}&lt;/sCountryISOCode>
        &lt;/CountryCurrency>
    &lt;/Body>
&lt;/Envelope></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod>SOAP</soapRequestMethod>
   <soapServiceFunction>CountryCurrency</soapServiceFunction>
   <variables>
      <defaultValue>GlobalVariable.CountryISOCode</defaultValue>
      <description></description>
      <id>9c3f418b-737b-4c8c-8742-ed58399d4bd3</id>
      <masked>false</masked>
      <name>countryISOCode</name>
   </variables>
   <variables>
      <defaultValue>'Basic dXNlcjpwYXNzd29yZA=='</defaultValue>
      <description></description>
      <id>f24c58aa-ce77-45a8-9108-33bcc333a84d</id>
      <masked>false</masked>
      <name>authorization</name>
   </variables>
   <verificationScript>import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable

RequestObject request = WSResponseManager.getInstance().getCurrentRequest()

ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()

WS.verifyElementText(response, 'CountryCurrencyResponse.CountryCurrencyResult.sISOCode', 'USD')
WS.verifyElementText(response, 'CountryCurrencyResponse.CountryCurrencyResult.sName', 'Dollars')</verificationScript>
   <wsdlAddress>http://webservices.oorsprong.org/websamples.countryinfo/CountryInfoService.wso?WSDL</wsdlAddress>
</WebServiceRequestEntity>
