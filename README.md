 ** Currently API take convert the doc to pdf and Csv to xml. But it is easy to add new formats with minimal changes to the code 
**


File Format Converter
=======================================
It is an API that accepts file in one format, and outputs the data in a different format. 




Folder Contents
---------------

* `com/in/convertClasses/` - All of the converter code
* `com/in/webservices` - All web services  


Usage
---------------
Run on Tomcat server.
It will run index.jsp 
You can select the input and output file format and upload the file. It will download the converted file. 


Where to Get Help
---------------

 Email: arg5739@rit.edu

Supported Formats
---------------
DOC to PDF
Csv to XML
 

Format Wish List
---------------
PDF to DOC
Text to PDF
Pdf to audio <Working on right now>
  

The Concept
---------------
This is basically an API where you can hook up the converter of your choice and make it available for others with minimum code changes. For adding new converter add class in appropriate directory and update two xml files. Namely List.xml and application-context.xml
List.xml 
<?xml version="1.0"?>
<list>
	
	<from id="doc">
		<to>pdf</to>
		
	</from>
	<!-- <from id="pdf">
		<to>pdf</to>
		<to>doc</to>
		<to>docx</to>
		<to>docasd</to>
	</from> -->
	<from id="csv">
		<to>xml</to>
		
	</from>
	
</list>

Application-context xml 
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:context="http://www.springframework.org/schema/context"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:jaxrs="http://cxf.apache.org/jaxrs"
	xmlns:http-conf="http://cxf.apache.org/transports/http/configuration"
	xsi:schemaLocation="
		http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
		http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-3.0.xsd
		http://cxf.apache.org/jaxrs http://cxf.apache.org/schemas/jaxrs.xsd 
		http://cxf.apache.org/transports/http/configuration http://cxf.apache.org/schemas/configuration/http-conf.xsd"
	default-lazy-init="false">

	<context:annotation-config />
	<!-- <bean id="applicationContextImpl" class="com.main.imp.ApplicationContextImpl"></bean> -->

	

	<bean id="doctopdf" class="com.in.convertClasses.DocToPdf"></bean>
	<bean id="csvtoxml" class="com.in.convertClasses.CsvToXml"></bean>


</beans>
It is bean file that calls the class dynamically according to input and output format. NOTE: Plase make sure in bean id will be always in the form of <inputFileFormat_lowerCase +”to”+OutputFileFormat_lowerCase>


