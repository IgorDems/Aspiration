package REST_API;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;

public class TestApi {

    String url = "https://swapi.dev/api/";
    String endpoint = "people/";

    @Test
    public void successfulResponse() {
        System.out.println("Test1");
        Response response = RestAssured.get(url + endpoint);
        System.out.println("Verify that the people endpoint is returning a successful response");
        System.out.println("Endpoint URL is: " + url + endpoint);
        System.out.println("Response Status Code is: " + response.getStatusCode());
        AssertJUnit.assertEquals(response.getStatusCode(), 200);
    }


    @Test
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

    @Test
    public void peopleHeight() {
        System.out.println("Test3");
        System.out.println("Verify that the total number of people where height is greater than\n" +
                "200 matches the expected count (10 at the time this was assigned)");
//        given().get("https://swapi.dev/api/people/").then().statusCode(200).body("count",>200);
//        given().get("https://swapi.dev/api/people/").then().statusCode(200).body("results.height");

    }

    @Test
    public void tenIndividuals() {
        System.out.println("Test4");
        System.out.println("Verify that the 10 individuals returned are:\n" +
                "Darth Vader. Chewbacca, Roos Tarpals, Rugor Nass, Yarael Poof, Lama Su, Tuan Wu, Grievous, Tarfful, Tion Medon");
    }


}

