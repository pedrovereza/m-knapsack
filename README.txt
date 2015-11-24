#### FORMATTER ####

Um formatador foi escrito para converter a entrada definidas para um formato utilizado como entrada de dados para o problema no GLPK.
O código fonte deste formatador se encontra em glpk/glpk-formatter.cpp. O arquivo deve ser compilado (recomenda-se o uso do compilador g++) e o executavel realiza IO na entrada padrao.
O arquivo gerado deve ser utilizado como entrada de dados para o GLPK


### ALGORITMO GENETICO JAVA ###

Algoritmo genetico escrito em java 1.7. Aceita parametros -file <filepath> e -pop <population-size>. Ambos sao opcionais, o valor padrão para o tamanho da população é 50. Se nenhum arquivo for informado, a leitura é feita da entrada padrão.
