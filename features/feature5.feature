Feature: Quiero que haya un modo de juego secreto que te aumenta al doble la velocidad de bajada de la pieza.
As a jugador, I want tener un modo de juego secreto que duplique la velocidad de bajada, Because me gustan los retos.

Scenario: partida en modo normal
Given el jugador selecciona el modo de juego normal "0"
When el jugador comienza la partida
Then la velocidad de caida de la pieza es de "1000" milisegundos

Scenario: partida en el modo secreto
Given el jugador selecciona el modo de juego secreto "1"
When el jugador comienza la partida
Then la velocidad de caida de la pieza es de "500" milisegundos
