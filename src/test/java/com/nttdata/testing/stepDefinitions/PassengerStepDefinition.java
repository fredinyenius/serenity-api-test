package com.nttdata.testing.stepDefinitions;



import com.nttdata.testing.questions.ResponseCode;
import com.nttdata.testing.tasks.DeletePassenger;
import com.nttdata.testing.tasks.PatchPassenger;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;


public class PassengerStepDefinition {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("el {actor} establece el endpoint PATCH para actualizar un pasajero")
    public void elActorEstableceElEndpointPATCHParaActualizarUnPasajero(Actor actor) {
        actor.whoCan(CallAnApi.at("https://api.instantwebtools.net/v1/passenger/"));
    }

    @When("el envia  una solicitud HTTP PATCH con el {string}")
    public void elEnviaUnaSolicitudHTTPPATCHConEl(String name) {
        theActorInTheSpotlight().attemptsTo(PatchPassenger.fromPage(name));
    }

    //ELIMINAR PASAJERO
    @Given("el {actor} establece el endpoint DELETE para actualizar un pasajero")
    public void elActorEstableceElEndpointDELETEParaActualizarUnPasajero(Actor actor) {
        actor.whoCan(CallAnApi.at("https://api.instantwebtools.net/v1/passenger/{id}"));

    }

    @When("el envia  una solicitud HTTP DELETE con el {string}")
    public void elEnviaUnaSolicitudHTTPDELETEConEl(String id) {
        OnStage.theActorInTheSpotlight()
                .attemptsTo(DeletePassenger.byId(id));
    }

    @Then("el codigo de respuesta HTTP deberiaa ser {int}")
    public void elCodigoDeRespuestaHTTPDeberiaaSer(int responseCode) {
        theActorInTheSpotlight().should(seeThat("El código de respuesta", ResponseCode.getStatus()));
    }

}