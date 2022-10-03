package starter.com.challenge.tiempo.metrologico.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import starter.com.challenge.tiempo.metrologico.questions.Validates;

public class Assert implements Task {

    protected final String town;
    protected final String cd;

    public Assert(String town, String cd) {
        this.town = town;
        this.cd = cd;
    }


    public static Assert data(String town, String cd) {
        return Tasks.instrumented(Assert.class, town, cd);
    }
    @Override
    public <T extends Actor> void performAs(T t) {
        Validates.responseBodyRetrieved(town);
        Validates.responseBodyRetrieved(cd);
    }
}
