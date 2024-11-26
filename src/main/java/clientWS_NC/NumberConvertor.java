package clientWS_NC;

import com.soap.ws.client.NumberConversion;
import com.soap.ws.client.NumberConversionSoapType;

import java.math.BigInteger;

public class NumberConvertor {

    public String convertNumberToWords(String number) {
        NumberConversion numberConversionService = new NumberConversion();
        NumberConversionSoapType numberConversionSoap = numberConversionService.getNumberConversionSoap();
        BigInteger num = new BigInteger(number);
        return numberConversionSoap.numberToWords(num);  // SOAP call for converting number to words
    }
}