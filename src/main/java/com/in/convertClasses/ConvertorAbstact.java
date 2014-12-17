package com.in.convertClasses;

import java.io.File;
import java.io.InputStream;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;

public abstract class ConvertorAbstact {

	public abstract Response  convertFile(InputStream fileName,String outputFileName);
	
	
	
	public String directoryLocation = "C:/Users/gawam01/workspaceEE/FileFormatConverterWS/src/main/resources/StoreFiles/";

	

}
