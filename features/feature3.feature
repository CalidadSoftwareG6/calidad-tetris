Feature: Cuando se finalice una partida quiero que suene Astronomia.
As jugador, I want que suene Astronomia cuando pierda una partida, Because me gustan los cofin memes.
  
Scenario: Pierdo una partida y accedo al ranking
Given partida perdida "1"
When se abre el ranking  
Then la musica "1"

Scenario: Accedo al ranking desde el menu principal sin haber jugado una partida
Given partida no perdida "0"
When se abre el ranking
Then la musica "0"
  

