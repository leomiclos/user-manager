### Documentação do Projeto Gerenciamento de Usuários

#### Tecnologias Utilizadas

O projeto de Gerenciamento de Usuários utiliza as seguintes tecnologias e frameworks para o desenvolvimento:

1. **Java 17**
   - Linguagem de programação utilizada para o desenvolvimento do backend.

2. **Spring Boot 2.5.5**
   - Framework utilizado para criar aplicações Java de forma rápida e fácil.
   - Utilizado para configurar e desenvolver o backend da aplicação.

3. **Spring Data JPA (Java Persistence API) com Hibernate**
   - Biblioteca que facilita o mapeamento objeto-relacional (ORM) em aplicações Java.
   - Utilizado para realizar operações de persistência de dados no banco de dados.

4. **Flyway**
   - Ferramenta utilizada para gerenciar migrações de banco de dados.
   - Garante que o esquema do banco de dados esteja versionado e atualizado conforme as alterações no código.

5. **Spring Web**
   - Módulo do Spring para desenvolvimento de aplicações web.
   - Utilizado para criar endpoints RESTful no backend da aplicação.

6. **Spring Boot DevTools**
   - Conjunto de ferramentas para desenvolvimento que melhora a experiência do desenvolvedor.
   - Fornece funcionalidades como reinicialização automática da aplicação durante o desenvolvimento.

7. **H2 Database**
   - Banco de dados em memória utilizado durante o desenvolvimento e testes da aplicação.

8. **Lombok**
   - Biblioteca Java que ajuda a reduzir o código boilerplate em classes Java.
   - Utilizado para geração automática de getters, setters, construtores, etc.

9. **Swagger 2**
   - Framework para documentação de APIs RESTful.
   - Utilizado para gerar automaticamente documentação interativa dos endpoints da API.

#### Funcionalidades Implementadas

O projeto implementa as seguintes funcionalidades relacionadas ao gerenciamento de usuários e departamentos:

- **Usuários**:
  - Cadastro de novo usuário.
  - Listagem de todos os usuários cadastrados.
  - Busca de usuário por ID.
  - Atualização dos dados de um usuário existente.
  - Exclusão de um usuário.

- **Departamentos**:
  - Cadastro de novo departamento.
  - Listagem de todos os departamentos cadastrados.
  - Busca de departamento por ID.
  - Atualização dos dados de um departamento existente.
  - Exclusão de um departamento.

#### Documentação dos Endpoints

A seguir estão os principais endpoints disponíveis na API:

##### Usuários

- **Listar Todos os Usuários**
  - `GET /api/usuarios`
  - Retorna uma lista de todos os usuários cadastrados.

- **Buscar Usuário por ID**
  - `GET /api/usuarios/{id}`
  - Retorna os detalhes de um usuário específico com base no ID fornecido.

- **Inserir Novo Usuário**
  - `POST /api/usuarios/inserir`
  - Insere um novo usuário com base nos dados fornecidos no corpo da requisição.

- **Atualizar Usuário**
  - `PUT /api/usuarios/{id}`
  - Atualiza os dados de um usuário existente com base no ID fornecido e nos dados fornecidos no corpo da requisição.

##### Departamentos

- **Listar Todos os Departamentos**
  - `GET /api/departamentos`
  - Retorna uma lista de todos os departamentos cadastrados.

- **Buscar Departamento por ID**
  - `GET /api/departamentos/{id}`
  - Retorna os detalhes de um departamento específico com base no ID fornecido.

- **Inserir Novo Departamento**
  - `POST /api/departamentos/inserir`
  - Insere um novo departamento com base nos dados fornecidos no corpo da requisição.

- **Atualizar Departamento**
  - `PUT /api/departamentos/{id}`
  - Atualiza os dados de um departamento existente com base no ID fornecido e nos dados fornecidos no corpo da requisição.

- **Deletar Departamento**
  - `DELETE /api/departamentos/{id}`
  - Exclui o departamento com base no ID fornecido.

### Conclusão

Este documento fornece uma visão geral das tecnologias utilizadas no projeto de Gerenciamento de Usuários, descreve as principais funcionalidades implementadas e lista os principais endpoints disponíveis na API. Para detalhes mais técnicos sobre cada endpoint, consulte a documentação interativa gerada pelo Swagger ao executar a aplicação.
