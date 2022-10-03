package starter.com.challenge.tiempo.metrologico.step_definitions;

import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import starter.com.challenge.tiempo.metrologico.tasks.Assert;
import starter.com.challenge.tiempo.metrologico.tasks.SendRequest;

public class ProvinceStepDefinition {

    @ParameterType(".*")
    public Actor actor(String actorName) {
        return OnStage.theActorCalled(actorName);
    }

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("{actor} sends {word} request to search province")
    public void userSendsRequestPARAMToSearchProvince(Actor actor, String endpoint) {
        actor.wasAbleTo(
                SendRequest.to(endpoint)
        );
    }

    @Then("{actor} validates body response retrieved that contains {word} and {word}")
    public void userValidatesBodyResponseRetrieved(Actor actor, String town, String cd) {
       actor.attemptsTo(
               Assert.data(town, cd)
       ); 
    }
}
