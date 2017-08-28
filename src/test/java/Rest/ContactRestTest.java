//package Rest;
//
//import io.restassured.RestAssured;
//import io.restassured.http.ContentType;
//import io.restassured.response.Response;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import static io.restassured.RestAssured.given;
//import static io.restassured.RestAssured.responseSpecification;
//import static io.restassured.RestAssured.when;
//import static org.hamcrest.CoreMatchers.equalTo;
//import static org.hamcrest.CoreMatchers.hasItems;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT,classes = {com.astontech.hr.Application.class})
//public class ContactRestTest
//{
//    @BeforeClass
//    public static void setBaseUri() {
//        RestAssured.baseURI = "http://localhost:8080";
//    }
//
//    @Test
//    public void testConnection() {
//        given().get("/api/contact/")
//                .then()
//                .contentType(ContentType.JSON)
//                .assertThat().statusCode(200);
//    }
//
//    @Test
//    public void getAllContactsReturnTwo(){
//        given().get("api/contact/")
//                .then()
//                .body("id",hasItems(321,322));
//    }
//
//    @Test
//    public void firstNameofContactIdThreeTwentyOneIsEric(){
//        given().get("api/contact/321")
//                .then()
//                .body("employee.firstName",equalTo("Eric"));
//    }
//
//    @Test
//    public void getEmailAddressOfContactIdThreeTwentyTwo(){
//        given().get("api/contact/322")
//                .then()
//                .body("emailAddress",equalTo("Bill@outlook.com"));
//    }
//
//    @Test
//    public void getBadResponseWithWrongUri() {
//        given().get("api/dlsfj/")
//                .then()
//                .assertThat().statusCode(404);
//    }
//
//
//
//
//}
