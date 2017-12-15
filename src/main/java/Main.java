import backend.utils.TestRailAPIClient;
import backend.utils.TestRailAPIException;
import org.json.simple.JSONObject;

import java.io.IOException;

public class Main {


    public static void main(String[] args) {
//        RestAssured.baseURI = "https://hilleltest3.testrail.net";
//        String body = "{\n" +
//                "    \"username\": \"test\",\n" +
//                "    \"password\": \"test)\"\n" +
//                "} ";
//
//        String coockie = given().
//                header("Content-Type", "application/json").
//                body(body).
//                when().
//                post("/rest/auth/1/session").
//                then().
//                extract().
//                path("session.value");


        TestRailAPIClient client = new TestRailAPIClient("https://hilleltest3.testrail.net");
        client.setUser("a.a.piluck@gmail.com");
        client.setPassword("dr8wJd15aqcI2FOFjpj6");
        JSONObject response = null;

        JSONObject body = new JSONObject();
        body.put("status_id", "4");


        try {
            response = (JSONObject) client.sendGet("get_case/1");
            response = (JSONObject) client.sendPost("add_result_for_case/3/1", body);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TestRailAPIException e) {
            e.printStackTrace();
        }
        System.out.println(response.get("title"));



    }

}
