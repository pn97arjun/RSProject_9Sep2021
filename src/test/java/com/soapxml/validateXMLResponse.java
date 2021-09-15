package com.soapxml;
import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class validateXMLResponse {

    @Test
    public void validateSoapResponse() throws IOException, FileNotFoundException
    {
        File file=new File("./SoapRequest/Add.xml");

        FileInputStream fileInputStream=new FileInputStream(file);

        String request= IOUtils.toString(fileInputStream,"UTF-8");

        baseURI="http://www.dneonline.com";
        given().
                contentType("test/xml").accept(ContentType.XML)
                .body(request).
        when().
                post("/calculator.asmx").
        then().
                statusCode(200).log().all();

    }
}
