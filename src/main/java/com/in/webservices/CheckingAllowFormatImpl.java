package com.in.webservices;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Random;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.in.convertClasses.ConvertorAbstact;

public class CheckingAllowFormatImpl extends CheckingAllowFomatAbstact {
	@Autowired
	ApplicationContext appContext = new ClassPathXmlApplicationContext(
			new String[] { "META-INF/application-context.xml" });

	public CheckingAllowFormatImpl() {

	}

	public Response convertFile(String input, String output, InputStream file)
			throws Exception {

		if (super.validCheck(input, output)) {

			// Strore file
			//String storedFileName = storeFile(file, input);
			String beanLookup = input + "to" + output;

			// CheckingAllowFormatImpl atd = new CheckingAllowFormatImpl();
			ConvertorAbstact cs = (ConvertorAbstact) appContext
					.getBean(beanLookup);

			Random rn = new Random();
			int answer = rn.nextInt(50000) + 1;
				return cs.convertFile(file,Integer.toString(answer));
			
		} else {
			return null;
		}

	}

	private String storeFile(InputStream uploadedInputStream, String input)
			throws Exception {
		Random rn = new Random();
		int answer = rn.nextInt(50000) + 1;
		// System.out.println(System.getProperty("user.dir"));
		String filename = Integer.toString(answer);
		String location = "C:/Users/gawam01/workspaceEE/FileFormatConverterWS/src/main/resources/StoreFiles/"
				+ filename + "." + input;
		OutputStream os = new FileOutputStream(location);

		byte[] b = new byte[2048];
		int length;

		while ((length = uploadedInputStream.read(b)) != -1) {
			os.write(b, 0, length);
		}

		uploadedInputStream.close();
		os.close();
		return filename + "." + input;

	}
}
