Given("un jugador ha hecho una partida de {string} puntos.") do |entrada|
	@entrada = entrada
end

When("el jugador le da a enviar los datos al ranking.") do
	@salida = eval(@entrada).to_s
end

Then("el jugador aparece en primera posicion con {string} puntos.") do |salida_esperada|
	@salida == salida_esperada
end

