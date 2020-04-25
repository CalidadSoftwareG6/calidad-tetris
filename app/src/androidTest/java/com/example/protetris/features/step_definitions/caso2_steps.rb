Given("se escucha una cancion {string} mientras juego una partida") do |entrada|
  @entrada = entrada
end

When("pulso el bonton de cambiar cancion") do
  @salida = eval(@entrada).to_s
end

Then("la cancion se cambia {string} y empieza a sonar la siguiente") do |salida_esperada1|
  @salida == salida_esperada1
end

Then("la cancion que suene debe ser diferente a la que se ha cambiado {string}") do |salida_esperada2|
  @salida != salida_esperada2
end

