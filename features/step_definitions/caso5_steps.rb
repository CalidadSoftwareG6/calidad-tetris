Given("el jugador comienza una partida con una velocidad de caida {string} de las piezas normal") do |entrada|
  @entrada = entrada
end

When("el jugador lleva jugando un rato una partida") do
  @salida = eval(@entrada).to_s
end

Then("la velocidad de caida de la pieza aumenta {string}") do |salida_esperada|
  @salida > salida_esperada
end

