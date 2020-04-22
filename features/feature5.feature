Feature: Que la velocidad aumente segun avanza el tiempo en la partida
As a jugador, I want to la velocidad se incremente segun avance el tiempo en la partida, Because me gustan los retos.

Scenario:
Given el jugador comienza una partida con una velocidad de caida "1" de las piezas normal
When el jugador lleva jugando un rato una partida
Then la velocidad de caida de la pieza aumenta "2"
