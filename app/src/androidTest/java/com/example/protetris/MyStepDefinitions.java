package com.example.protetris;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
public class MyStepDefinitions {

    @Given("^un jugador ha hecho una partida de {int} puntos.$")
    public void un_jugador_ha_hecho_una_partida_de_something_puntos(String strArg1) throws Throwable {
        throw new PendingException();
    }

    @When("^el jugador le da a enviar los datos al ranking.$")
    public void el_jugador_le_da_a_enviar_los_datos_al_ranking() throws Throwable {
        throw new PendingException();
    }

    @Then("^el jugador aparece en primera posicion con \"([^\"]*)\" puntos.$")
    public void el_jugador_aparece_en_primera_posicion_con_something_puntos(String strArg1) throws Throwable {
        throw new PendingException();
    }

}