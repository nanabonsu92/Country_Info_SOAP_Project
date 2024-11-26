package clientWS_NC;

import com.soap.ws.client.TCountryInfo;
import com.soap.ws.client.CountryInfoService;
import com.soap.ws.client.CountryInfoServiceSoapType;

public class CountryConvertor {

    // Method to get the country name based on ISO code
    public String getCountryNameByISOCode(String code) {
        CountryInfoService c_service = new CountryInfoService();
        CountryInfoServiceSoapType c_serviceSOAP = c_service.getCountryInfoServiceSoap();
        return c_serviceSOAP.countryName(code);  // SOAP call to fetch country name by ISO code
    }

    // Method to get the ISO code of a country based on the country name
    public String getISOCodeByCountryName(String countryName) {
        CountryInfoService c_service = new CountryInfoService();
        CountryInfoServiceSoapType c_serviceSOAP = c_service.getCountryInfoServiceSoap();
        return c_serviceSOAP.countryISOCode(countryName);  // SOAP call to fetch ISO code by country name
    }

    // Method to get full country details based on the ISO code
    public TCountryInfo getCountryDetails(String code) {
        CountryInfoService c_service = new CountryInfoService();
        CountryInfoServiceSoapType c_serviceSOAP = c_service.getCountryInfoServiceSoap();
        return c_serviceSOAP.fullCountryInfo(code);  // SOAP call for full country info
    }
    
    // Formats the details of a country into a readable string
    public String formatCountryDetails(TCountryInfo countryInfo) {
        String capitalCity = countryInfo.getSCapitalCity();
        String currency = countryInfo.getSCurrencyISOCode();
        String phoneCode = countryInfo.getSPhoneCode();
        String continentCode = countryInfo.getSContinentCode();
        String countryFlag = countryInfo.getSCountryFlag();
        
        return String.format("Capital: %s, Currency: %s, Phone Code: %s, Continent: %s, Flag URL: %s", 
                              capitalCity, currency, phoneCode, continentCode, countryFlag);
    }
}

//SOAP-Based