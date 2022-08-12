
# Skill Test Looking for Bananas in the Monkeys island

O desafio apresentado nos remete à uma busca em uma matriz, ou seja, caminhar nela e procurar uma solução para o 
problema proposto. Notamos que as restrições de movimento nos lembraram de uma busca em árvore e a partir de algoritmos
já conhecidos como a busca em largura, nós poderíamos tentar uma solução. É nesse tipo de busca que analisamos os nós
vizinhos, o que é interessante para nós por causa da soma dos valores, ou seja, procurar o caminho máximo.

Os comentários e explicações da solução estão no código
## Deploy

Para executar este projeto você pode importar o projeto em sua IDE de preferência, com java 8 instalado, e executar a classe MonkeyIsland.




## Foram utilizados os cenários abaixo:

{{1, 3, 3}

 {2, 1, 4}

 {0, 6, 4}}

Output: 12

 {{1, 3, 1, 5}

  {2, 2, 4, 1}

  {5, 0, 2, 3}

  {0, 6, 1, 2}}
  
Output: 16

{{10, 33, 13, 15}

 {22, 21, 04, 1}

 { 5,  0,  2, 3}

 { 0,  6, 14, 2}}

Output: 83

{{ 10,  33,   13, 15}

 { 100, 21,   04, 1}

 { 5,   0,    2,  3}

 { 0,   1000, 2,  3}

 { 0,   6,    14, 2}}

Output: 1022

