# 💻 API de Gerenciamento de Produtos e Categorias

## 📝 Descrição

Este projeto é uma **API RESTful** desenvolvida com **Spring Boot** para gerenciar um catálogo de produtos e suas respectivas categorias.
A aplicação segue uma **arquitetura em camadas** (Controllers, Services, Repositories), garantindo separação de responsabilidades e melhor manutenção do código.

O ambiente de desenvolvimento é totalmente **containerizado com Docker**, e o versionamento do banco de dados é automatizado com **Flyway**, assegurando consistência e facilitando a configuração inicial.

---

## ✨ Funcionalidades

* **Gerenciamento de Categorias:** CRUD completo (Criar, Ler, Atualizar e Deletar).
* **Gerenciamento de Produtos:** CRUD completo com associação a uma categoria.
* **API RESTful:** Endpoints bem definidos conforme boas práticas do mercado.
* **Migrações de Banco de Dados:** O schema é criado e atualizado automaticamente pelo Flyway.
* **Ambiente Dockerizado:** Banco de dados PostgreSQL executado em container Docker.
* **Segurança:** Credenciais do banco de dados são externalizadas via arquivo `.env` e **nunca expostas** no código-fonte.

---

## 🛠️ Tecnologias Utilizadas

* **Backend:** Java 21, Spring Boot, Spring Data JPA
* **Banco de Dados:** PostgreSQL
* **Gerenciamento de Build:** Maven
* **Containerização:** Docker
* **Migrações de DB:** Flyway

---

## 🚀 Como Executar o Projeto

### 🔧 Pré-requisitos

Antes de começar, é necessário ter instalado:

* [JDK 21](https://www.oracle.com/java/technologies/downloads/#java21)
* [Docker](https://www.docker.com/get-started/)
* [Maven](https://maven.apache.org/download.cgi) *(ou usar o Maven Wrapper incluso no projeto)*

---

### ▶️ Passos para Execução

1. **Clone o repositório:**

   ```bash
   git clone <https://github.com/jumplyon/AtividadeSistemasDistribuidos-main.git>
   cd AtividadeSistemasDistribuidos-main
   ```

2. **Configure as variáveis de ambiente:**
   Crie um arquivo chamado `.env` na raiz do projeto.
   Este arquivo **não** será enviado para o Git e guardará suas credenciais locais.
   Substitua os valores de placeholder pelos seus dados reais:

   ```bash
   # Arquivo: .env
   DB_USERNAME=<seu-usuario-do-banco>
   DB_PASSWORD=<sua-senha-do-banco>
   ```

3. **Inicie o banco de dados com Docker:**

   ```bash
   docker-compose up -d
   ```

4. **Execute a aplicação Spring Boot:**

   ```bash
   ./mvnw spring-boot:run
   ```

Após a execução, a API estará disponível em:
👉 **[http://localhost:8080](http://localhost:8080)**

---

## 📖 Endpoints da API

A seguir estão os endpoints disponíveis na API:

---

### 🗂️ Categorias (`/v1/categories`)

* **POST** `/v1/categories` — Cria uma nova categoria
  **Exemplo de corpo da requisição:**

  ```json
  {
    "nome": "Eletrônicos",
    "descricao": "Dispositivos eletrônicos e acessórios"
  }
  ```

* **GET** `/v1/categories` — Lista todas as categorias

* **PUT** `/v1/categories/{id}` — Atualiza uma categoria existente

* **DELETE** `/v1/categories/{id}` — Remove uma categoria

---

### 📦 Produtos (`/v1/products`)

* **POST** `/v1/products` — Cria um novo produto
  **Exemplo de corpo da requisição:**

  ```json
  {
    "nome": "Notebook Gamer",
    "codigo": 1001,
    "preco": 7500.00,
    "categoriaId": 1
  }
  ```

* **GET** `/v1/products` — Lista todos os produtos

* **PUT** `/v1/products/{id}` — Atualiza um produto existente

* **DELETE** `/v1/products/{id}` — Remove um produto
