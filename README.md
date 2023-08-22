# Rede social de séries (filmes e livros posteriormente)

Desenvolver em Java, uma aplicação de console, de um sistema de séries de Tv.
Cada série contém seu nome, ano em que foi ao ar o primeiro episódio e o número de temporadas.
Nesse sistema o usuário poderá:
- cadastrar uma série;
- poderá listar as séries
- procurar série por seu nome ou número de temporadas;
- poderá atrelar uma nota e um comentário a série;
- visualizar a média das notas atribuídas a série, bem como os comentários de cada usuário;
- adicionar/remover uma série a sua lista;
- adicionar até cinco séries numa lista de "Séries favoritas"
- alterar o status da série: QUERO VER, ESTOU VENDO, JA VI.


<h3>Requisitos Funcionais</h3>
- cadastrar série<br>
- listar série<br>
- procurar série por nome ou número de temporadas<br>
- adicionar uma nota e um comentário a série<br>
- visualizar a média das notas da série<br>
- adicionar/remover série a minha lista de séries<br>
- adicionar/remover série favorita<br>
- alterar status de uma das minhas séries (favorita ou não)<br>

<h3>Requisito não funcional</h3>
- as séries podem ser listadas em ordem alfabética, ordem cronológica em relação ao ano em que foram ao ar e em ordem quantitativa de temporadas;<br>
- o status das séries do usuário é transacional, logo ele pode marcar ela na ordem de: QUERO VER -> ESTOU VENDO -> JA VI ou vice versa (QUERO VER <- ESTOU VENDO <- JA VI), não é possível alterar de QUERO VER -> JA VI, ou vice versa;<br>
- Quando adiciono uma série na minha lista de séries ela inicializa com o valor de "QUERO VER";<br>
- a nota deve ter um valor mínimo de 1 e máximo de 5 (sendo 1 péssima, 2 Ruim, 3 Boa, 4 Muito boa, 5 ótima);<br>
- Um comentário deve ter no mínimo 10 caracteres;<br>
- Devo ter no máximo 5 séries favoritas;<br>
  <br><br>
  Possíveis status de série:
- QUERO VER (inicial)
- ESTOU VENDO
- JA VI

Notas possíveis:
- PÉSSIMA = 1
- RUIM = 2
- BOA = 3
- MUITO BOA = 4
- ÓTIMA = 5

O banco de dados a ser utilizado fica a critério do desenvolvedor.

Caso o banco seja MySQL:
<h2>O arquivo database.sql </h2>
Irá criar as tabelas, adicionará algumas séries, usuários, notas e comentários de usuários.
A partir do arquivo percebe-se que vão existir 4 tabelas:

- tabela de séries
- tabela de usuários (o usuário "logado" será o com identificador igual a 1)
- tabela de notas das séries
- tabela de minhas séries

Obs: Todas as dependências necessárias já estão no pom.xml caso seja MySQL.

