# 📦 Projeto de Cache com Spring Boot e Redis

- Projeto desenvolvido com o objetivo de estudar e aplicar **estratégias de cache em aplicações backend** focando em **performance** de consultas.
- A aplicação utiliza **Spring Boot + Redis** para cachear consultas ao banco de dados, reduzindo acessos desnecessários ao MySQL e melhorando o tempo de resposta da API.
- Além disso, foram explorados cenários de **expiração de cache (TTL)** e **limpeza automática**, entendendo como o cache se comporta ao longo do tempo em aplicações reais.
- Este projeto foi construído com o conhecimento obtido através do Mini curso de Spring Cache + Redis do canal Matheus do Java.
<br> <br>
[![YouTube Cache e Redis](https://img.shields.io/badge/YouTube-Minicurso%20Spring%20Cache%20%2B%20Redis-red?logo=youtube)](https://youtube.com/playlist?list=PL0D5C4QG6iBpTgwkzmGfp68hcKm8AER8s&si=X0vWd61Wu46LdXCm)

## 🚀 Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.2.3**
- **Spring Cache**
- **Redis**
- **MySQL**
- **Docker & Docker Compose**
- **Maven**
- **Lombok**

## 🧠 Conceitos Explorados

- Cache de consultas com `@Cacheable`
- Cache de consultas com condições
- Invalidação de cache com `@CacheEvict`
- Limpeza e update automático de caches com `@Scheduled`
- Expiração automática usando **TTL nativo do Redis**
- Redução de carga no banco de dados
- Separação de responsabilidades entre banco e cache

## 📌 Arquitetura Simplificada

Fluxo básico da aplicação:

1. Cliente faz a requisição
2. A aplicação verifica se o dado está no cache (Redis)
3. **Cache HIT** → retorna o dado diretamente do Redis  
4. **Cache MISS** → consulta o MySQL, salva no Redis e retorna a resposta

<img width="2752" height="1536" alt="Fluxo API Spring Boot com Redis Clean" src="https://github.com/user-attachments/assets/790ab1fd-892e-424a-89c1-a917379bb7f7" />

## 🐳 Como Rodar o Projeto

### Pré-requisitos
- Docker
- Docker Compose
- Java 17
- Maven

### 🔧 Subindo MySQL e Redis com Docker

1. Crie ou utilize o arquivo `docker-compose.yml` abaixo:

```yaml
services:
  mysql:
    image: mysql:8
    container_name: mysql_cache
    environment:
      MYSQL_ROOT_PASSWORD: root
      MYSQL_DATABASE: cache
    ports:
      - "3306:3306"
    restart: always
    volumes:
      - mysql_data:/var/lib/mysql

  redis:
    image: redis:7.2
    container_name: redis_cache
    ports:
      - "6379:6379"

volumes:
  mysql_data:
```
## 🔍 Observações Importantes
- Para testar as requisições e comparar o impacto da performance, é preciso popular o banco de dados. Deixei o SQL nescessário em arquivos .txt no diretório resources.
- Na classe `CacheAgendado.java`, as funcionalidades de limpar e atualizar os caches estão comentadas. Retire os comentários para "ativar".
- A aplicação consome uma API do IBGE através do Spring Cloud. As configurações já estão feitas e já está tudo pronto pra testar os endpoints.

## 📚 Aprendizados

Este projeto ajudou a consolidar conceitos importantes como:
-Pensar além do CRUD
-Impacto do cache na performance
-Diferença entre cache em memória e cache distribuído
-Uso prático do Redis em aplicações backend modernas

## 👤 Autor
- Asafe Orneles
-  [![LinkedIn](https://img.shields.io/badge/LinkedIn-blue?logo=linkedin)](https://www.linkedin.com/in/asafeorneles)
