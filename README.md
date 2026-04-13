# 📱 Matemágico - Backend

Backend do projeto **Matemágico**, uma aplicação educacional gamificada voltada para o apoio ao ensino de matemática para crianças, com foco em acessibilidade e inclusão, especialmente para crianças com TEA (Transtorno do Espectro Autista).

---

## 🚀 Tecnologias utilizadas

* Java 17+
* Spring Boot
* Spring Data JPA
* PostgreSQL
* Lombok
* Maven

---

## 🧱 Arquitetura

O projeto segue uma arquitetura em camadas:

```
Controller → Service → Domain → Repository → Database
```

Organização de pacotes:

```
br.com.matemagico
 ├── config
 ├── controller
   ├── request
   ├── response
 ├── domain
 ├── mapper
 ├── repository
 ├── service
 └── exception
```

---

## ⚙️ Configuração do ambiente

### 📌 Pré-requisitos

* Java 17 ou superior
* Maven
* PostgreSQL

---

### 🗄️ Banco de dados

Crie o banco:

```sql
CREATE DATABASE matemagico;
```

Configure o arquivo `application.yml`:

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/matemagico
    username: postgres
    password: sua_senha

  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
```

---

## ▶️ Executando o projeto

```bash
mvn spring-boot:run
```

A aplicação estará disponível em:

```
http://localhost:8080
```

---

## 📌 Funcionalidades atuais

* Cadastro de usuários
* Listagem de usuários
* Integração com banco de dados PostgreSQL

---

## 🧪 Testes da API

### 🔹 Criar usuário

**POST** `/users`

```json
{
  "name": "Messyas",
  "email": "messyas@email.com",
  "password": "123456"
}
```

---

### 🔹 Listar usuários

**GET** `/users`

---

## 📈 Próximos passos

* Implementar perfil do aluno (StudentProfile)
* Criar sistema de atividades matemáticas
* Desenvolver controle de progresso
* Adicionar autenticação e segurança

---

## 📚 Contexto acadêmico

Este projeto faz parte do Trabalho de Conclusão de Curso (TCC), com foco em:

* Gamificação no ensino
* Inclusão digital
* Apoio a crianças com TEA
* Uso de tecnologia como ferramenta educacional

---

## 👨‍💻 Autor

Desenvolvido por Karlos Messyas 🚀
