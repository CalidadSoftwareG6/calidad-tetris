Given("el jugador selecciona el modo de juego normal {string}") do |entrada|
  @entrada = entrada
end

When("el jugador comienza la partida") do
  @salida = eval(@entrada).to_s
end

Then("la velocidad de caida de la pieza es de {string} milisegundos") do |salida_esperada|

  if @salida == 0 then
        salida_esperada == 1000
  else
        salida_esperada == 500
  end

end

Given("el jugador selecciona el modo de juego secreto {string}") do |entrada|
  @entrada = entrada
end
