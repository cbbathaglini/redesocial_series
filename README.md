# Rede social de séries (filmes e livros posteriormente)

Desenvolver em Java um sistema de séries de Tv. Cada série contém seu nome, ano em que foi ao ar o primeiro episódio e o número de temporadas. 
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
- cadastrar série
- listar série
- procurar série por nome ou número de temporadas
- adicionar uma nota e um comentário a série
- visualizar a média das notas da série
- adicionar/remover série a minha lista de séries
- adicionar/remover série favorita
- alterar status de uma das minhas séries

<h3>Requisito não funcional</h3>
- as séries podem ser listadas em ordem alfabética, ordem cronológica em relação ao ano em que foram ao ar e em ordem quantitativa de temporadas;
- o status das séries do usuário é transacional, logo ele pode marcar ela na ordem de: QUERO VER -> ESTOU VENDO -> JA VI ou vice versa (QUERO VER <- ESTOU VENDO <- JA VI), não é possível alterar de QUERO VER -> JA VI, ou vice versa.
- Quando adiciono uma série na minha lista de séries ela inicializa com o valor de "QUERO VER";
- a nota deve ter um valor mínimo de 0 e máximo de 5 (sendo 0 péssima e 5 ótima);
- Um comentário deve ter no mínimo 10 caracteres;
- Devo ter no máximo 5 séries favoritas;

  
O banco de dados a ser utilizado fica a critério do desenvolvedor.

Caso o banco seja MySQL:
<h2>O arquivo database.sql </h2>
Irá criar as tabelas, adicionará algumas séries, usuários, notas e comentários de usuários.
A partir do arquivo percebee-se que vão existir 3 tabelas:

 - tabela de séries
 - tabela de usuários (o usuário "logado" será o com identificador igual a 1)
 - tabela de notas das séries
 - tabela de séries favoritas





