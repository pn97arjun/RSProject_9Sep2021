package com.soapxml;

import io.restassured.http.ContentType;
import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static io.restassured.RestAssured.*;

public class soapXmlRequest {

    @Test
    public void soapXmlValidation() throws FileNotFoundException, IOException
    {
        File file=new File("./soapRequest/Add.xml");
        if(file.exists())
            System.out.println("File exists");

        FileInputStream fileInputStream=new FileInputStream(file);

        String request= IOUtils.toString(fileInputStream,"UTF-8");

        baseURI="http://www.dneonline.com";

        given().
                contentType("text/xml").accept(ContentType.XML).
                body(request).
        when().
                post("/calculator.asmx").
        then().
                statusCode(200).log().all();

    }

}
