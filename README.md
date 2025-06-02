
# 🛍️ Sistema de Vendas

Sistema web completo de **gestão de vendas**, desenvolvido por **Lucas Lucena** como projeto educacional. A aplicação permite realizar o cadastro e controle de **clientes**, **produtos**, **entradas de estoque** e **vendas**, com páginas bem estruturadas utilizando **Thymeleaf**, integração com **Spring Boot**, **JPA/Hibernate** e estilização com **Bootstrap**.


## ✅ Funcionalidades

### 🔧 Funcionalidades Gerais

- Efetuar Venda
- Listar Venda
- Efetuar Entrada de Produto
- Listar Entrada de Produto

### ➕ Cadastros

- Cadastro de Estado
- Cadastro de Cidade
- Cadastro de Funcionário
- Cadastro de Cliente
- Cadastro de Fornecedor
- Cadastro de Produto

### 📄 Listagens

- Listar Estado
- Listar Cidade
- Listar Funcionário
- Listar Cliente
- Listar Fornecedor
- Listar Produto

---

## 🧰 Tecnologias Utilizadas

- **Java 17**
- **Spring Boot**
- **Spring Data JPA** + **Hibernate**
- **Thymeleaf**
- **Bootstrap**
- **PostgreSQL**
- **Maven**

---

## 🛠️ Requisitos para Executar o Projeto

Antes de executar o sistema, você precisa ter instalado:

- [Java JDK 17+](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [PostgreSQL](https://www.postgresql.org/download/)
- [Maven](https://maven.apache.org/)
- [Git](https://git-scm.com/)
- Uma IDE como  [Eclipse](https://www.eclipse.org/) ou [IntelliJ](https://www.jetbrains.com/idea/)

---

## ▶️ Como Executar o Projeto Localmente

### 1. Clonar o repositório

```bash
git clone https://github.com/lucaslucena/sistema-vendas.git
cd sistema-vendas
```

### 2. Criar o banco de dados PostgreSQL

Acesse o PostgreSQL (via terminal ou pgAdmin) e crie o banco:

```sql
CREATE DATABASE sistema_vendas;
```

### 3. Configurar o `application.properties`

Abra o arquivo `src/main/resources/application.properties` e ajuste com seus dados de acesso ao banco:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/sistema_vendas
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
```

### 4. Compilar e executar o projeto

```bash
./mvnw spring-boot:run
```

### 5. Acessar o sistema

Abra o navegador e acesse:

```
http://localhost:8080
```

---

## 🗂️ Estrutura do Projeto

- `modelos/` – Entidades JPA (Produto, Cliente, Venda, etc.)
- `controladores/` – Controladores Spring MVC
- `repositorios/` – Interfaces de acesso ao banco (JPA)
- `templates/` – Páginas HTML Thymeleaf
- `static/` – CSS, JS e imagens
- `uploads/` – Pasta local para salvar imagens enviadas

---

## 📄 Licença

Projeto de uso **educacional e pessoal**, livre para estudar, melhorar e expandir.
