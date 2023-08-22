# Rede social de séries 

<h2>Será necessário</h2>
Java 17

<h2>Não poderá</h2>
- Utilizar Frameworks (como Spring, Hibernate etc)

<h2>Poderá</h2>
- Ser utilizado JUnit para testes

<h1>Sobre o desenvolvimento</h1>
Desenvolver em Java, uma aplicação de console, de um sistema de séries de Tv. 

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
- Quando o usuário adicionar uma série na 'minha lista de séries' essa série será inicializada com o valor de "QUERO VER";<br>
- a nota deve ter um valor mínimo de 1 e máximo de 5 (sendo 1 péssima, 2 Ruim, 3 Boa, 4 Muito boa, 5 ótima);<br>
- Um comentário deve ter no mínimo 10 caracteres;<br>
- o usuário deve ter no máximo 5 séries favoritas;<br>
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

<h2>Testes</h2>
Você também deve criar testes end-to-end (e2e) coerentes com as funcionalidades que implementar nas classes.

<h2>Banco de dados</h2>
O banco de dados a ser utilizado fica a critério do desenvolvedor.


<h5>Caso o banco seja MySQL</h5>
O  arquivo database.sql irá criar as tabelas, adicionará algumas séries, usuários, notas e comentários de usuários.<br>
A partir do arquivo percebe-se que vão existir 4 tabelas:<br>
- tabela de séries (cada série contém seu nome, ano em que foi ao ar o primeiro episódio e o número de temporadas)<br>
- tabela de usuários (o usuário "logado" será o com identificador igual a 1) (cada usuário terá um nome e um email)<br>
- tabela de notas das séries ( sobre as ações envolvendo nota_serie: existirá o identificador da série, o valor da nota (1-5) e um comentário que pode ser nulo, mas que se preenchido deverá ter no mínimo 10 caracteres)<br>
- tabela de minhas séries  (sobre as ações envolvendo minha_série: existirá o identificador do usuário que será sempre 1, o identificador da série e a informação se a série é favorita ou não)<br>
<br>
Obs: Todas as dependências necessárias já estão no pom.xml caso seja MySQL.


