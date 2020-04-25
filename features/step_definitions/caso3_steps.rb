Given("partida perdida {string}") do |entrada|
  @entrada = entrada
end

When("se abre el ranking") do
  @salida = eval(@entrada).to_s
end

Then("la musica {string}") do |salida_esperada|
  
  if @salida == 0 then
	salida_esperada == 0	
  else
	salida_esperada == 1
  end

end

Given("partida no perdida {string}") do |entrada|
  @entrada = entrada
end


