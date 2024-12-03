package com.nttdata.testing.tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Patch;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PatchPassenger implements Task {

    private final String name;

    public PatchPassenger(String name) {

        this.name = name;

    }

    public static Performable fromPage( String name) {
        return instrumented(PatchPassenger.class, name);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Patch.to("/passenger").with(requestSpecification -> requestSpecification.contentType(ContentType.JSON).
                body("{\"name\":\"" + name
                        + "\"}").log().all()));
    }
}