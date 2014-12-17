package com.in.webservices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.springframework.stereotype.Service;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@Service
@Path("/options")
public class CheckAvailableOption extends CheckingAllowFomatAbstact {

	@GET
	@Path("/from")
	@Consumes(MediaType.APPLICATION_JSON)
	public String fromOptions() {
		// return gson.toJson(albums);
		HashMap<String, HashSet<String>> map = super.map;
		List<String> keyArrayList = new ArrayList();
		int i = 0;
		if (map.size() > 0) {
			Iterator it = super.map.entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry key = (Map.Entry) it.next();

				keyArrayList.add(key.getKey().toString());
			}

		}
		// return Response.status(200).build();

		return new Gson().toJson(keyArrayList);

	}

	@GET
	@Path("/to/{input}")
	@Consumes(MediaType.APPLICATION_JSON)
	public String toOptions(@PathParam("input") String input) {

		HashMap<String, HashSet<String>> map = super.map;
		String lookup = input.trim();
		HashSet<String> set = new HashSet<String>();

		int i = 0;
		if (map.size() > 0) {

			if (map.containsKey(lookup)) {
				set = map.get(input);

			}

		}

		return new Gson().toJson(set);

	}

}
