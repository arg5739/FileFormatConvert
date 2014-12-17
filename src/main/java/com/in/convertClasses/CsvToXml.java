package com.in.convertClasses;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

import com.thoughtworks.xstream.XStream;

import au.com.bytecode.opencsv.CSVReader;

public class CsvToXml extends ConvertorAbstact{

	@Override
	public Response convertFile(InputStream fileName, String outputFileName) {
		// TODO Auto-generated method stub
		
		InputStreamReader in = new InputStreamReader(fileName);
		CSVReader reader = new CSVReader(in);
		OutputStream os = null;
		try {
			os = new FileOutputStream(super.directoryLocation + outputFileName+ ".xml");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
            
            String[] line = null;

            String[] header = reader.readNext();

            List out = new ArrayList();

            while((line = reader.readNext())!=null){
                List<String[]> item = new ArrayList<String[]>();
                    for (int i = 0; i < header.length; i++) {
                    String[] keyVal = new String[2];
                    String string = header[i];
                    String val = line[i];
                    keyVal[0] = string;
                    keyVal[1] = val;
                    item.add(keyVal);
                }
                out.add(item);
            }

            XStream xstream = new XStream();
            xstream.toXML(out, os);
            

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		File output = new File(super.directoryLocation + outputFileName
				+ ".xml");

		return Response
				.ok(output)
				.header("Content-Disposition",
						"attachment; filename= " + output.getName()).build();
	}

}
