package com.example.protetris;

import cucumber.api.CucumberOptions;
import cucumber.api.PendingException;
import cucumber.api.java.en.But;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@CucumberOptions(glue = "com.example.protetris.features.step_definitions", plugin = {"html/report.html"}, tags = {"~@wip"}, features = {"com.example.protetris.features"})
@RunWith(Cucumber.class)
public class MyStepDefinitions extends cucumber.api.android.CucumberAndroidJUnitRunner{




    /*@Given("^un jugador ha hecho una partida de {int} puntos.$")
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
    }*/

    /**************************************************/

    /*@Given("^se escucha una cancion \"([^\"]*)\" mientras juego una partida$")
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
    }*/

    /******************************************************/

    /*@Given("^partida perdida \"([^\"]*)\"$")
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
    }*/

    /******************************************************/

    /*@Given("^la musica esta apagada \"([^\"]*)\"$")
    public void la_musica_esta_apagada_something(String strArg1) throws Throwable {
        throw new PendingException();
    }

    @Given("^la musica esta encendida \"([^\"]*)\"$")
    public void la_musica_esta_encendida_something(String strArg1) throws Throwable {
        throw new PendingException();
    }

    @When("^pulso el boton para que se escuche$")
    public void pulso_el_boton_para_que_se_escuche() throws Throwable {
        throw new PendingException();
    }

    @When("^pulso el boton para que no se escuche$")
    public void pulso_el_boton_para_que_no_se_escuche() throws Throwable {
        throw new PendingException();
    }

    @Then("^la musica se escuchara \"([^\"]*)\"$")
    public void la_musica_se_escuchara_something(String strArg1) throws Throwable {
        throw new PendingException();
    }

    @Then("^la musica no se escuchara \"([^\"]*)\"$")
    public void la_musica_no_se_escuchara_something(String strArg1) throws Throwable {
        throw new PendingException();
    }*/

    /***********************************************************/

    /*@Given("^el jugador selecciona el modo de juego normal \"([^\"]*)\"$")
    public void el_jugador_selecciona_el_modo_de_juego_normal_something(String strArg1) throws Throwable {
        throw new PendingException();
    }

    @Given("^el jugador selecciona el modo de juego secreto \"([^\"]*)\"$")
    public void el_jugador_selecciona_el_modo_de_juego_secreto_something(String strArg1) throws Throwable {
        throw new PendingException();
    }

    @When("^el jugador comienza la partida$")
    public void el_jugador_comienza_la_partida() throws Throwable {
        throw new PendingException();
    }

    @Then("^la velocidad de caida de la pieza es de \"([^\"]*)\" milisegundos$")
    public void la_velocidad_de_caida_de_la_pieza_es_de_something_milisegundos(String strArg1) throws Throwable {
        throw new PendingException();
    }*/

}