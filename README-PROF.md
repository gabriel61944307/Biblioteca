# 📚 Biblioteca

Repositório do sistema de Biblioteca desenvolvido para a disciplina de Programação Orientada a Objetos Avançada da UFSCar.

### Autores:
Ariane Cristina Gomes

Gabriel Rodrigues Malaquias

Ruan Crysthian Lima Ferraz

Tiago Lucas Leal

## 💡 Sobre o projeto

Este projeto tem o objetivo de implementar um sistema para gerenciamento de uma biblioteca. 

Algumas ações possíveis são: cadastro de leitores, funcionários e obras, além de realizar empréstimo das obras, reservas e também a devolução das mesmas.

Para o prévio desenvolvimento, foi criado o diagrama de classes que ilustra todo o funcionamento do sistema:

<p align="center">
<a href="https://i.ibb.co/DtNhS30/Biblioteca-Grupo2-final.png"><img src="https://i.ibb.co/DtNhS30/Biblioteca-Grupo2-final.png" alt="Biblioteca-Grupo2-final" border="0"></a>
</p>


## 🛠️ Abrir e rodar o projeto

Para conseguir executar o sistema, é necessário clonar o repositório em sua máquina com o comando:
```
git clone https://github.com/gabriel61944307/Biblioteca.git
```

Após ter sua versão local, basta abrir o projeto em sua IDE de preferência e rodar o comando:
```
mvn spring-boot:run
```

## Testando as integrações

- Para testar a integração com Grupos Acadêmicos, é necessário fazer chamada REST de login para gerar o código de autenticação pelo link link https://pooa-grupos-academicos.herokuapp.com/docs/ e alterá-lo no código, nos métodos `verificarGrupoAcademico()` e `verificarGrupoAcademicoAtivo()` da classe `ControladorObra`. 
Além disso, é necessário passar um id pelo link https://pooa-grupos-academicos.herokuapp.com/user/{id}/academicGroup, sendo o ID o `numeroUfscar` de um leitor. Atualmente é possível fazer a chamada com os IDs:
  - 03dec7a5-9b4e-4d73-a87f-c00ff03d71b7 - Leitor com participação em grupos acadêmicos
  - 3fa85f64-5717-4562-b3fc-2c963f66afa6 - Leitor com participação em grupos acadêmicos
  - ec1c550c-96da-4703-8dd3-3724cbd6a687 - Leitor sem participação em grupos acadêmicos


- Para testar a integração com Disciplinas, é necessário passar um id pelo link https://inscricaodisciplinas.herokuapp.com/aluno/{id}/disciplinas, sendo o ID o `numeroUfscar` de um leitor. Atualmente é possível fazer a chamada com os IDs:

  - 03dec7a5-9b4e-4d73-a87f-c00ff03d71b7 - Leitor com 5 disciplinas
  - 3fa85f64-5717-4562-b3fc-2c963f66afa6 - Leitor com 2 disciplinas
  

- Para testar a nossa integração para os outros grupos, é utilizado o link https://pooa-biblioteca.herokuapp.com/pessoa/pendencias/{id}, sendo o ID o `numeroUfscar` de um leitor. Atualmente é possível fazer a chamada com os IDs:
  - 03dec7a5-9b4e-4d73-a87f-c00ff03d71b7 - Leitor sem pendências
  - 3fa85f64-5717-4562-b3fc-2c963f66afa6 - Leitor com pendências
  - ec1c550c-96da-4703-8dd3-3724cbd6a687 - Leitor sem pendências