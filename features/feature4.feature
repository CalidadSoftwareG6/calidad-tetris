Feature: Quiero poder pausar la musica cuando quiera.
As jugador, I want elegir jugar con musica o sin musica, Because quiero apagarla cuando quiera silencio.
  
Scenario: pantalla de seleccion de colores  
Given la musica esta apagada "0"
When pulso el boton para que se escuche
Then la musica se escuchara "1"
  
Scenario: pantalla de seleccion de colores
Given la musica esta encendida "1"
When pulso el boton para que no se escuche
Then la musica no se escuchara "0"
