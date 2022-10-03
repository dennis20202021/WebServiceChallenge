package starter.com.challenge.tiempo.metrologico.tasks;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.thucydides.core.annotations.Step;
import starter.com.challenge.tiempo.metrologico.utils.ReadXML;
import starter.com.challenge.tiempo.metrologico.utils.Routes;

import java.util.logging.Level;
import java.util.logging.Logger;

public class SendRequest implements Task {

    private static final Logger logger = Logger.getLogger(SendRequest.class.getName());

    protected Response response;

    protected final String endpoint;

    public SendRequest(String endpoint) {
        this.endpoint = endpoint;
    }

    @Step("Get province with param endpoint {0}")
    public static SendRequest to(String endpoint) {
        return Tasks.instrumented(SendRequest.class, endpoint);
    }

    @Override
    public <T extends Actor> void performAs(T t) {

        String province = ReadXML.getInstance().getDataFrom(
                Routes.PATH_TO_XML_FILE.getValue(), "cat:Provincia"
        );

        String town = ReadXML.getInstance().getDataFrom(
                Routes.PATH_TO_XML_FILE.getValue(), "cat:Municipio"
        );


        response = SerenityRest.given()
                .header("Content-Type", "text/xml")
                .when()
                .get(BaseUrl.getInstance().getUrl() + endpoint + "?Provincia=" + province + "&Municipio=" + town)
                .then()
                .statusCode(200)
                .and()
                .log().all().extract().response();

        XmlPath xpath = new XmlPath(response.asInputStream());

        logger.log(Level.INFO,"Response: \n {0}", xpath);
    }
}
