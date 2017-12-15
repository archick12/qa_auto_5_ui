package backend.utils;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

import static com.jayway.restassured.RestAssured.given;

public class RequestSender {
    public static String JSESSIONID = null;
    public static String TOKENKEYONE = null;
    public static String TOKENKEYTWO = null;
    public final static ContentType CONTENT_TYPE = ContentType.JSON;
    public RequestSpecification requestSpecification = null;
    public Response response = null;

    public RequestSender() {
        authenticate();
    }

    public void authenticate() {
        RestAssured.baseURI = "http://soft.it-hillel.com.ua:8080/";

        JiraJsonFixture jiraJSONFixture = new JiraJsonFixture();
        String credentials = jiraJSONFixture.generateJSONForLogin();

        secureCreateRequest(credentials)
                .post(ApiUris.LOGIN.getUri());

        this.JSESSIONID = response.then().extract().path("session.value");
    }

    public void secureAuthenticate() {
        RestAssured.baseURI = "http://soft.it-hillel.com.ua:8080/";

        JiraJsonFixture jiraJSONFixture = new JiraJsonFixture();
        String credentials = jiraJSONFixture.generateJSONForLogin();

        secureCreateRequest(credentials)
                .post(ApiUris.LOGIN.getUri());

        this.JSESSIONID = response.then().extract().path("session.value");
        this.TOKENKEYONE = response.then().extract().cookie("studio.crowd.tokenkey");
        this.TOKENKEYTWO = response.then().extract().cookie("atlassian.xsrf.token");

    }

    public RequestSender secureCreateRequest(String body) {
        this.createRequestSpecification()
                .addHeader("Content-Type", CONTENT_TYPE.toString())
                .addHeader("Cookie", "JSESSIONID=" + RequestSender.JSESSIONID)
                .addHeader("Cookie", "studio.crowd.tokenkey=" + RequestSender.TOKENKEYONE)
                .addHeader("Cookie", "atlassian.xsrf.token=" + RequestSender.TOKENKEYTWO)
                .addBody(body);
        return this;
    }


    public RequestSender createRequest(String body) {
        this.createRequestSpecification()
                .addHeader("Content-Type", CONTENT_TYPE.toString())
                .addHeader("Cookie", "JSESSIONID=" + RequestSender.JSESSIONID)
                .addBody(body);
        return this;

    }


    public RequestSender createRequestSpecification() {
        requestSpecification = given().
                when();
        return this;
    }

    // этот метод сможет добавлять столько угодно хедеров
    public RequestSender addHeader(String headerName, String headerValue) {
        requestSpecification.header(headerName, headerValue);
        return this;
    }

    public RequestSender addBody(String body) {
        requestSpecification.body(body);
        return this;
    }

    public RequestSender post(String uri) {
        response = requestSpecification.post(uri);
        return this;
    }


    public RequestSender createRequest() {
        this.createRequestSpecification()
                .addHeader("Content-Type", CONTENT_TYPE.toString())
                .addHeader("Cookie", "JSESSIONID=" + RequestSender.JSESSIONID);
        return this;
    }

    public RequestSender secureCreateRequest() {
        this.createRequestSpecification()
                .addHeader("Content-Type", CONTENT_TYPE.toString())
                .addHeader("Cookie", "JSESSIONID=" + RequestSender.JSESSIONID)
                .addHeader("Cookie", "studio.crowd.tokenkey=" + RequestSender.TOKENKEYONE)
                .addHeader("Cookie", "atlassian.xsrf.token=" + RequestSender.TOKENKEYTWO);
        return this;

    }

    public RequestSender delete(String uri) {
        response = requestSpecification.delete(uri);
        return this;
    }

    public RequestSender get(String uri) {
        response = requestSpecification.get(uri);
        return this;
    }

    public RequestSender put(String uri) {
        response = requestSpecification.get(uri);
        return this;

    }

    public String getResponseValue() {
        return this.response.asString();
    }

}
