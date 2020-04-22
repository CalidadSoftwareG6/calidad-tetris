Feature: Boton para cambiar de cancion durante la partida.
As a jugador, I want to cambiar la cancion que este sonando en la partida, Because quiero poder cambiar de cancion si no me gusta la que esta sonando.

Scenario: Una partida en curso
Given se escucha una cancion "0" mientras juego una partida
When pulso el bonton de cambiar cancion
Then la cancion se cambia "1" y empieza a sonar la siguiente
But la cancion que suene debe ser diferente a la que se ha cambiado "0"
