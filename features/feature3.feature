Feature: Si el jugador no llega a 100 puntos, la aplicacion no dejara reiniciar una partida.
As jugador, I want que la aplicacion finalice si no obtengo 100 puntos, Because me gustan los retos.
  
Scenario: Una partida cualquiera finalizada
Given una puntuacion "60"
When la partida se acaba  
Then la aplicacion se cierra "0" porque no he llegado a los "100" puntos
  
Scenario: Una partida cualquiera finalizada
Given una puntuacion "110"
When la partida se acaba  
Then la aplicacion no se cierra "1" porque he llegado a los "100" puntos
