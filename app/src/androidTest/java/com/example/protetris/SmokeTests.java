package com.example.protetris;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SmokeTests {






//Feature 1


    @Given("^Un jugador ha hecho una partida$")
    public void Un_jugador_ha_hecho_una_partida()throws Throwable {
        System.out.println("partida empezada");

    }
    @When("^El jugador le da a enviar los datos al ranking$")
    public void El_jugador_le_da_a_envair_los_datos_al_ranking()throws Throwable{
        System.out.println("se envian los datos al ranking");

    }

    @Then("^El jugador aparece en primera posicion con 0 puntos$")
    public void El_jugador_aparece_en_primera_posicion_con_0_puntos()throws Throwable{
        System.out.println("El jugador aparece en primera posicion");

    }

//Feature2



    @Given("^Se escucha una cancion$")
    public void Se_escucha_una_cancion()throws Throwable {
        System.out.println("Se escucha una cancion");

    }
    @When("^Pulso el boton de cambiar cancion$")
    public void Pulso_el_boton_de_cambiar_cancion()throws Throwable{
        System.out.println("se pulso el boton");

    }

    @Then("^La cancion cambia$")
    public void La_cancion_cambia()throws Throwable{
        System.out.println("Se escucha la musica");

    }

//Feature 3
    @Given("^Partida perdida 1 $")
    public void Partida_perdida_1()throws Throwable {
        System.out.println("partida perdida");

    }
    @When("^Se abre el ranking$")
    public void Se_abre_el_ranking()throws Throwable{
        System.out.println("se abre el ranking");

    }

    @Then("^La musica 1$")
    public void La_musica_1()throws Throwable{
        System.out.println("Se escucha la musica");

    }



//Feature 4

    @Given("^La musica esta apagada 0 $")
    public void La_musica_esta_apagada(){
        System.out.println("La musica esta apagada");

    }
    @When("^Pulso el boton para que se escuche$")
    public void Pulso_el_boton_para_que_se_escuche(){
        System.out.println("se escucha la musica");

    }

    @Then("^La musica se escuchara 1$")
    public void La_musica_se_escuchara_1(){
        System.out.println("La musica se escucha");

    }


//Feature 5


    @Given("^El jugador selecciona el modo de juego normal 0$")
    public void El_jugador_selecciona_el_modo_de_juego_normal_0()throws Throwable {
        System.out.println("modo seleccionado");

    }
    @When("^El jugador comienza la partida$")
    public void El_jugador_comienza_la_partida()throws Throwable{
        System.out.println("empieza la partida");

    }

    @Then("^La velocidad de caida de la pieza es de 1000 milisegundos$")
    public void La_velocidad_de_caida_de_la_pieza_es_de_1000_milisegundos()throws Throwable{
        System.out.println("la velocidad es correcta");

    }




}
