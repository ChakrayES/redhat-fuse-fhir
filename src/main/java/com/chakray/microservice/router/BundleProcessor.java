package com.chakray.microservice.router;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.hl7.fhir.r4.model.Bundle;
import org.hl7.fhir.r4.model.Bundle.BundleType;
import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;
import org.hl7.fhir.r4.model.HumanName;
import org.hl7.fhir.r4.model.Identifier;
import org.hl7.fhir.r4.model.Patient;
import com.chakray.microservice.pojo.Record;

public class BundleProcessor implements Processor {
  @Override
  public void process(final Exchange exchange) throws Exception {
    Record record = exchange.getIn().getBody(Record.class);
    String patientId = record.getDNI();
    String patientFamilyName = record.getFamilyName();
    String patientGivenName = record.getGivenName();
    String patientBirthDate = record.getBirthDate();

    Bundle bundle = new Bundle();
    bundle.setId("bundle-simplificado-001");
    exchange.getIn().setBody(bundle);
    bundle.setIdentifier(new Identifier().setValue("001"));
    bundle.setType(BundleType.TRANSACTION);

    Patient patient = new Patient();
    patient.setId("pacient-exemple1");
    Identifier patientIdentifier = new Identifier();
    CodeableConcept patientCodeableConcept = new CodeableConcept();
    patientCodeableConcept.setCoding(new ArrayList<>(Arrays.asList(new Coding().setCode("DNI"))));
    patientCodeableConcept.setText("DNI");
    patientIdentifier.setType(patientCodeableConcept);
    patientIdentifier.setValue(patientId);
    patient.setIdentifier(new ArrayList<>(Arrays.asList(patientIdentifier)));

    HumanName humanName = new HumanName();
    humanName.addGiven(patientGivenName);
    humanName.setFamily(patientFamilyName);
    patient.setName(new ArrayList<>(Arrays.asList(humanName)));

    Date patientBirthDateFormat = new SimpleDateFormat("yyyy-MM-dd").parse(patientBirthDate);
    patient.setBirthDate(patientBirthDateFormat);
    bundle.addEntry().setResource(patient).getRequest().setUrl("Paciente").setMethod(Bundle.HTTPVerb.POST);
  }
}
