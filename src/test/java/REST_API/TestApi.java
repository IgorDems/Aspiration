package REST_API;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import json_handling.HandlingJson;

import com.google.gson.JsonObject;
import org.apache.http.client.methods.HttpGet;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

public class TestApi {
	HandlingJson hj = new HandlingJson();

    String url = "https://swapi.dev/api/";
    String endpoint = "people/";

    @Test(groups = { "test1" })
    public void successfulResponse() {
        System.out.println("Test1");
        Response response = RestAssured.get(url + endpoint);
        System.out.println("Verify that the people endpoint is returning a successful response");
        System.out.println("Endpoint URL is: " + url + endpoint);
        System.out.println("Response Status Code is: " + response.getStatusCode());
        AssertJUnit.assertEquals(response.getStatusCode(), 200);
    }


    @Test(groups = { "test2" })
    public void peopleNameCount() {
 
        System.out.println("Test2");
        int i = 1;
        int count = 0;

        while (i < 199) {
            if (RestAssured.get(url + endpoint + "/" + String.valueOf(i)).getStatusCode() == 200) {
                count++;
            }
            i++;
        }
        System.out.println("Verify that the total number of people checked equals = " + count);
        Assert.assertEquals(count,82);

        System.out.println("Verify that the total number of people checked equals the expected count (82 at the time)");
        given().get("https://swapi.dev/api/people/").then().statusCode(200).body("count", equalTo(82));

    }

    @Test(groups = { "test-group" })

    public void GetHeight() throws IOException {
        String url = "https://swapi.dev/api/";
        String endpoint = "people/";
        String[] expected = {"Darth Vader", "Chewbacca", "Roos Tarpals", "Rugor Nass", "Yarael Poof", "Lama Su", "Taun We", "Grievous", "Tarfful", "Tion Medon"};
        String[] result = new String[10];
        int i = 1;
        int count = 0;
        while (i < 84) {

            HttpGet person = new HttpGet(url+endpoint+String.valueOf(i)+"/");
            JsonObject personJSON = new JsonObject();
            personJSON = hj.getRequest(person);


            if (RestAssured.get(url + endpoint + "/" + String.valueOf(i)).getStatusCode() == 200) {
                if ( personJSON.get("height").getAsInt()>200 ){
                    System.out.println("height = " + personJSON.get("height").getAsInt() );
                    result[count] = personJSON.get("name").getAsString();
                    count++;
                }
                System.out.println("count = " + count );
                System.out.println("i = " + i );
            }
            i++;
            if(i==17||i==29){
                i++;
            }
        }

        System.out.println("<== The total number of people where \n" +
                "height is greater than 200 is: "+count);
        assertTrue(count>=10);

        System.out.println("Verify that the 10 individuals returned are:\n" +
                "Darth Vader, Chewbacca, Roos Tarpals, Rugor Nass, Yarael Poof, Lama Su, Tuan Wu, Grievous, Tarfful, Tion Medon");
        for (String a: result) {
            System.out.println("result array = " + a+", ");
        }

        assertArrayEquals(expected,result);
    }

}

