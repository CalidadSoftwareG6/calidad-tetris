Given("una puntuacion {string}") do |entrada|
  @entrada = entrada
end

When("la partida se acaba") do
  @salida = eval(@entrada).to_s
end

Then("la aplicacion se cierra {string} porque no he llegado a los {string} puntos") do |salida_esperada1, puntuacion_requerida1|

	if puntuacion_requerida1 <= @entrada then
		salida_esperada1 = true
	else
		salida_esperada1 = false
	end
end

Then("la aplicacion no se cierra {string} porque he llegado a los {string} puntos") do |salida_esperada2, puntuacion_requerida2|
  	
	if puntuacion_requerida2 > @entrada then
		salida_esperada2 = false
	else
		salida_esperada2 = true
	end
end

