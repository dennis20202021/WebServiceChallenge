package starter.com.challenge.tiempo.metrologico.questions;

import net.serenitybdd.screenplay.Question;
import starter.com.challenge.tiempo.metrologico.utils.ReadXML;
import starter.com.challenge.tiempo.metrologico.utils.Routes;

public class Validates {

    private Validates() {
        throw new IllegalStateException("Utility class");
    }

    public static Question<Boolean> responseBodyRetrieved(String expectedValue) {
        return actor -> ReadXML.getInstance().getDataFrom(
                        Routes.RESPONSE_BODY_PATH_FILE.getValue(), "consulta_municipiero"
        ).contains(expectedValue);
    }
}
