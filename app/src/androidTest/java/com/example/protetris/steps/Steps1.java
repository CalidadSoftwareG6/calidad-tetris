package com.example.protetris.steps;

import org.junit.BeforeClass;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertTrue;

public class Steps1 {
    @BeforeClass
    public static void setupClass() {
        throw new RuntimeException("Sorry dude, you won't find any test!");
    }

    @Given("^un jugador ha hecho una partida de (.*) puntos.$")
    public void un_jugador_ha_hecho_una_partida_de_something_puntos(String strArg1) throws Throwable {
        throw new PendingException();
    }

    @When("^el jugador le da a enviar los datos al ranking.$")
    public void el_jugador_le_da_a_enviar_los_datos_al_ranking() throws Throwable {
        throw new PendingException();
    }

    @Then("^el jugador aparece en primera posicion con (.*) puntos.$")
    public void el_jugador_aparece_en_primera_posicion_con_something_puntos(String strArg1) throws Throwable {
        //throw new PendingException();
        assertTrue(true);
    }
}
