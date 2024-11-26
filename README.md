# Country Converter SOAP Service

## **Overview**
The Country Converter SOAP Service is a Java-based web application that uses SOAP web services to provide the following functionalities:
1. **Convert Country Name to ISO Code:** Retrieve the ISO code for a given country name.
2. **Convert ISO Code to Country Name:** Retrieve the country name for a given ISO code.
3. **Display Full Country Details:** Fetch detailed information about a country, including:
   - Capital City
   - Currency
   - Phone Code
   - Continent
   - URL to the country's flag.


## **Features**
- **SOAP API Integration:** Uses `CountryInfoService` SOAP API for accurate and real-time data.
- **Dynamic Response Formatting:** Formats country details into a human-readable string.
- **Web Interface:** Supports HTTP GET and POST methods for querying information.
- **Modular Design:** Encapsulates functionality in dedicated classes for easy maintenance and extensibility.

## **Technology Stack**
- **Programming Language:** Java
- **Web Service Protocol:** SOAP
- **Web Server:** Apache Tomcat
- **Build Tool:** Maven
- **Dependencies:**
  - `javax.servlet-api` (3.1.0)
  - `jaxws-ri` (2.3.1)

## **Setup and Deployment**
1. Clone this repository:
   ```bash
   git clone https://github.com/yourusername/CountryConverterSOAP.git
   cd CountryConverterSOAP
