FileFormatConvertWS
===================

Convert the file format. 
It is an API that accepts file in one format, and outputs the data in a different format. 

Currently API take convert the doc to pdf and Csv to xml. But it is easy to add new formats with minimal changes to the code 

Following files need to be change in order to incorporate the new file format converters
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

Application-context.xml
this is the bean file. 
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
