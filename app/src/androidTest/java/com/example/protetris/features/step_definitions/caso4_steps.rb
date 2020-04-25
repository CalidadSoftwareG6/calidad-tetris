Given("la musica esta apagada {string}") do |entrada1|
  @entrada1 = entrada1
end

When("pulso el boton para que se escuche") do
  @salida1 = eval(@entrada1).to_s
end

Then("la musica se escuchara {string}") do |salida_esperada1|
  salida_esperada1 != @salida1 
end

Given("la musica esta encendida {string}") do |entrada2|
  @entrada2 = entrada2
end

When("pulso el boton para que no se escuche") do
  @salida2 = eval(@entrada2).to_s
end

Then("la musica no se escuchara {string}") do |salida_esperada2|
  salida_esperada2 != @salida2
end

