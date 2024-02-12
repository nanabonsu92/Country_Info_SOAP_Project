package clientWS_NC;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import com.soap.ws.client.TCountryCodeAndName;
import com.soap.ws.client.CountryInfoService;
import com.soap.ws.client.CountryInfoServiceSoapType;
import com.soap.ws.client.ArrayOftCountryCodeAndName;

public class CountryConvertor {
//	List<TCountryCodeAndName> countryNames;
	public CountryConvertor() {
//		CountryInfoService c_service = new CountryInfoService();
//		CountryInfoServiceSoapType c_serviceSOPA = c_service.getCountryInfoServiceSoap();
//		ArrayOftCountryCodeAndName a = c_serviceSOPA.listOfCountryNamesByName();
//		countryNames = a.getTCountryCodeAndName();
	}
	
	public String getCountrynamebyISOCode(String code) {
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
	public String getISOCodeByCountryName(String countryName) {
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

}
