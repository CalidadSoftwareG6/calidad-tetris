Feature: Arreglar el bug del ranking consistente en que si haces 0 puntos y el tablero esta vacio, te pone en segunda posición.
As a Jugador, I want to el Ranking funcione bien,Because me gusta que los juegos no tengan fallos.

Scenario: Tablero del Ranking vacio
Given un jugador ha hecho una partida de "0" puntos.
When el jugador le da a enviar los datos al ranking.
Then el jugador aparece en primera posicion con "0" puntos.
