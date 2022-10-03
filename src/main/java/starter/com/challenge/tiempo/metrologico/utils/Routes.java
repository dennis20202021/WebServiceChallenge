package starter.com.challenge.tiempo.metrologico.utils;

public enum Routes {

    PATH_TO_XML_FILE("src/main/resources/data/request.xml"),
    RESPONSE_BODY_PATH_FILE("src/main/resources/data/response.xml");

    public final String path;
    Routes(String path) {
        this.path = path;
    }

    public String getValue() {
        return this.path;
    }

}
