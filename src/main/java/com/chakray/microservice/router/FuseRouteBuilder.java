package com.chakray.microservice.router;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.springframework.stereotype.Component;
import com.chakray.microservice.pojo.Record;

@Component
public class FuseRouteBuilder extends RouteBuilder {

  BindyCsvDataFormat bindy = new BindyCsvDataFormat(Record.class);

  @Override
  public void configure() throws Exception {
    from("file://{{dir.in}}?noop=true").filter(simple("${file:name.ext} == 'csv'")).id("readingCsvFiles")
        .log("Converting ${in.headers.CamelFileName}").unmarshal(bindy).log("body ${body}").process(new BundleProcessor())
        .log("Sending HL7 FHIR Bundle")
        .to("fhir://transaction/withBundle?inBody=bundle&serverUrl={{fhirUrl}}&fhirVersion={{fhirVersion}}&validationMode=NEVER").log("CSV imported")
        .end();
  }

}
