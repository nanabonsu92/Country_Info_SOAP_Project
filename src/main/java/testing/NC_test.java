package testing;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import com.soap.ws.client.NumberConversion;
import com.soap.ws.client.NumberConversionSoapType;

import com.soap.ws.client.TCountryCodeAndName;
import com.soap.ws.client.CountryInfoService;
import com.soap.ws.client.CountryInfoServiceSoapType;
import com.soap.ws.client.ArrayOftCountryCodeAndName;
public class NC_test {

	
	public static String convert2word(String inputStr) {
		BigInteger input_N = new BigInteger(inputStr);
		NumberConversion NC_service = new NumberConversion(); //created service object
		NumberConversionSoapType NC_serviceSOAP = NC_service.getNumberConversionSoap(); //create SOAP object (a port of the service)
        String result = NC_serviceSOAP.numberToWords(input_N);  
        return result;
	}
    
	public static String convert2dollars(String inputStr) {
		BigDecimal input_D = new BigDecimal(inputStr);
		NumberConversion NC_service = new NumberConversion(); //created service object
        NumberConversionSoapType NC_serviceSOAP = NC_service.getNumberConversionSoap(); //create SOAP object (a port of the service)
        String result = NC_serviceSOAP.numberToDollars(input_D);  
        return result;
	}
	public static String getCountrynamebyISOCode(String code) {
		String res_name ="";
		CountryInfoService c_service = new CountryInfoService();
		CountryInfoServiceSoapType c_serviceSOPA = c_service.getCountryInfoServiceSoap();
		ArrayOftCountryCodeAndName a = c_serviceSOPA.listOfCountryNamesByName();
		List<TCountryCodeAndName> countryNames = a.getTCountryCodeAndName();
		for (TCountryCodeAndName countryName : countryNames) {
			if(countryName.getSISOCode().equals(code)) {
				res_name = countryName.getSName();
				break;
			}
        }
		return res_name;
	}
	public static String getISOCodeByCountryName(String countryName) {
		String res_code ="";
		CountryInfoService c_service = new CountryInfoService();
		CountryInfoServiceSoapType c_serviceSOPA = c_service.getCountryInfoServiceSoap();
		ArrayOftCountryCodeAndName a = c_serviceSOPA.listOfCountryNamesByName();
		List<TCountryCodeAndName> countryNames = a.getTCountryCodeAndName();
		for (TCountryCodeAndName cn : countryNames) {
			if(cn.getSName().equals(countryName)) {
				res_code = cn.getSISOCode();
				break;
			}
        }
		return  res_code;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
//		CountryInfoService c_service = new CountryInfoService();
//		CountryInfoServiceSoapType c_serviceSOPA = c_service.getCountryInfoServiceSoap();
//		ArrayOftCountryCodeAndName a = c_serviceSOPA.listOfCountryNamesByName();
//		List<TCountryCodeAndName> countryNames = a.getTCountryCodeAndName();
//		for (TCountryCodeAndName countryName : countryNames) {
//            System.out.println("Country: " + countryName.getSName());
//            System.out.println("Country: " + countryName.getSISOCode());
//        }
		System.out.println("CountryName: " + getCountrynamebyISOCode("BB"));
		System.out.println("CountryName: " + getISOCodeByCountryName(getCountrynamebyISOCode("BB")));
	}

}
