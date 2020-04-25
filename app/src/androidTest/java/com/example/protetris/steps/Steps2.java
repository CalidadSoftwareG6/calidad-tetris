package com.example.protetris.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.But;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Steps2 {

    @Given("^se escucha una cancion \"([^\"]*)\" mientras juego una partida$")
    public void se_escucha_una_cancion_something_mientras_juego_una_partida(String strArg1) throws Throwable {
        throw new PendingException();
    }

    @When("^pulso el bonton de cambiar cancion$")
    public void pulso_el_bonton_de_cambiar_cancion() throws Throwable {
        throw new PendingException();
    }

    @Then("^la cancion se cambia \"([^\"]*)\" y empieza a sonar la siguiente$")
    public void la_cancion_se_cambia_something_y_empieza_a_sonar_la_siguiente(String strArg1) throws Throwable {
        throw new PendingException();
    }

    @But("^la cancion que suene debe ser diferente a la que se ha cambiado \"([^\"]*)\"$")
    public void la_cancion_que_suene_debe_ser_diferente_a_la_que_se_ha_cambiado_something(String strArg1) throws Throwable {
        throw new PendingException();
    }

}
