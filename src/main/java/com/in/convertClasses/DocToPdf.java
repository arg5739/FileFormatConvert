package com.in.convertClasses;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.ws.rs.core.Response;

import org.docx4j.Docx4J;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;

public class DocToPdf extends ConvertorAbstact {

	@Override
	public Response convertFile(InputStream fileName, String outputFileName) {
		// TODO Auto-generated method stub
		// String inputLocation = super.directoryLocation + fileName;

		// String[] outputFileName = fileName.split("\\.");
		// File inputFile = new File(inputLocation);
		WordprocessingMLPackage wmlPackage;
		OutputStream os = null;
		try {
			wmlPackage = WordprocessingMLPackage.load(fileName);
			os = new FileOutputStream(super.directoryLocation + outputFileName
					+ ".pdf");
			Docx4J.toPDF(wmlPackage, os);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (Docx4JException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		File output = new File(super.directoryLocation + outputFileName
				+ ".pdf");

		return Response
				.ok(output)
				.header("Content-Disposition",
						"attachment; filename= " + output.getName()).build();

	}

}
