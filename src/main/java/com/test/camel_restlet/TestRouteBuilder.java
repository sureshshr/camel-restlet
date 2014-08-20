package com.test.camel_restlet;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class TestRouteBuilder extends RouteBuilder {

	@Override
	public void configure() {

		from("timer://foo?fixedRate=true&period=60s").routeId("route1-timer")
				.transform()
				.simple("Hello Web Application, how are you?")
				.to("stream:out");

		from("restlet:/demo/{id}").routeId("route2-restlet")
				.transform()
				.simple("Request type : ${header.CamelHttpMethod} and ID : ${header.id}");

		from("restlet:/queue/{id}").routeId("route3-restletamq")
				.transform()
				.simple("${header.id}")
				.to("activemq:foo");

		from("activemq:foo").routeId("route4-restletamq")
				.to("mock:file");
	}
}