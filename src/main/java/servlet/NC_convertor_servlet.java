package servlet;

import clientWS_NC.CountryConvertor;
import clientWS_NC.NumberConvertor;
import com.soap.ws.client.TCountryInfo;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NC_convertor_servlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private CountryConvertor countryConvertor = new CountryConvertor();
    private NumberConvertor numberConvertor = new NumberConvertor();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String value = request.getParameter("value");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            switch (action) {
                case "getCountryCode":
                    String isoCode = countryConvertor.getISOCodeByCountryName(value);
                    out.write(isoCode);
                    break;
                case "getCountryName":
                    String countryName = countryConvertor.getCountryNameByISOCode(value);
                    out.write(countryName);
                    break;
                case "getCountryDetails":
                    TCountryInfo countryInfo = countryConvertor.getCountryDetails(value);
                    String details = countryConvertor.formatCountryDetails(countryInfo);
                    out.write(details);
                    break;
                case "convertNumber":
                    String numberInWords = numberConvertor.convertNumberToWords(value);
                    out.write(numberInWords);
                    break;
                default:
                    out.write("Invalid action");
            }
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("An error occurred while processing the request: " + e.getMessage());
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);  // Handle GET requests as POST
    }
}
