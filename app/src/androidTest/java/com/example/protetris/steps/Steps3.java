package com.example.protetris.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Steps3 {
    @Given("^partida perdida \"([^\"]*)\"$")
    public void partida_perdida_something(String strArg1) throws Throwable {
        throw new PendingException();
    }

    @Given("^partida no perdida \"([^\"]*)\"$")
    public void partida_no_perdida_something(String strArg1) throws Throwable {
        throw new PendingException();
    }

    @When("^se abre el ranking  $")
    public void se_abre_el_ranking() throws Throwable {
        throw new PendingException();
    }

    @Then("^la musica \"([^\"]*)\"$")
    public void la_musica_something(String strArg1) throws Throwable {
        throw new PendingException();
    }
}
