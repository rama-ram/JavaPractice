package com.practice.restTest;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class RestTest {
	private Client client;
	private String SERVER_URL;
	private WebResource resource;
	private WebResource.Builder builder;
	private String METHOD;

	// identify the server url
	// make a client connection
	// identify the resource url
	// create the request
	// read the response
	RestTest(String serverUrl) {
		SERVER_URL = serverUrl;
	}

	void createClient() {
		client = Client.create();
	}

	public void initBuilder() {
		builder = this.resource.getRequestBuilder();

	}

	private ClientResponse get() {
		METHOD = "GET";
		initBuilder();
		// setHeader("Accept", NimbulaHeader.NIMBULA_ACCEPT_HEADER);
		// setHeader("Content-Type", NimbulaHeader.NIMBULA_CONTENT_TYPE_HEADER);
		ClientResponse response = builder.get(ClientResponse.class);
		return response;
	}

	public void createRequest(String path) {
		resource = client.resource(SERVER_URL + path);
	}

	public static void main(String[] args) {
		RestTest rtest = new RestTest("http://www.omdbapi.com/?apikey=713882ee&");
		rtest.createClient();
		rtest.createRequest("i=tt3896198");
		ClientResponse response = rtest.get();
		String messageBody = response.getEntity(String.class);
		int statusCode = response.getStatus();
		System.out.println("Message Body " + messageBody + " Status Code " + statusCode);

	}

}
