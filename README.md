* * *

VHL - Fullstack Developer Test | TJSC API
=========================================

Este projeto foi desenvolvido como parte do teste técnico para a vaga de Desenvolvedor(a) Fullstack na **VHL Sistemas**.  
A API foi construída utilizando **Java 24** e **Spring Boot 3.5** com **Docker** para container e **postgresql** para o banco de dados.

📦 Como iniciar o projeto
-------------------------

Você pode iniciar o projeto de três maneiras diferentes:

* * *

### 🔁 1. Usando Docker Compose

1.  Copie o arquivo `.env-example` e renomeie para `.env`.
    
2.  Preencha as variáveis de ambiente no novo arquivo `.env`.  
    As principais variáveis que precisam ser ajustadas são:
    
    
    ```
    TJSC_WSDL=<link do WSDL da API TJSC> 
    TJSC_USER=<usuário> 
    TJSC_PASS=<senha>
    ```

    As informações necessárias podem ser encontradas na documentação do TJSC, enviada junto com o teste.
    
3.  Execute o comando abaixo no terminal:
    
    ```
    sudo docker compose up
    ```
    Ou dependendo do sistema

    ```
    sudo docker-compose up
    ```
    
    
4.  A API estará disponível em `http://localhost:8080`.
    

* * *

### 🐳 2. Usando Docker (sem Compose)

1.  Edite o arquivo `src/main/resources/application.properties`, atualizando as seguintes variáveis:
    
    ```
    app.tjscWsdl=<link do WSDL da API TJSC> 
    app.tjscUser=<usuário da API> 
    app.tjscPass=<senha da API> 
    spring.datasource.url=<URL do banco PostgreSQL> 
    spring.datasource.username=<usuário do banco> 
    spring.datasource.password=<senha do banco>
    ```
    
2.  Construa a imagem Docker:
    
    ```
    docker build -t vhl-test-api
    ```
3.  Rode o container:
    
    ```
    docker run -p 8080:8080 vhl-test-api
    ```


* * *

### 💻 3. Executando manualmente

1.  Edite o arquivo `src/main/resources/application.properties`, preenchendo as variáveis conforme mencionado acima.
    
2.  Instale as dependências do Maven:
    
    ```
    mvn install
    ```
    
3.  Execute a aplicação:
    
    ```
    mvn spring-boot:run
    ```
    

* * *

📚 Documentação Swagger
-----------------------

A API possui uma interface interativa de documentação via Swagger, acessível em:

> [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

Lá você pode explorar e testar todos os endpoints disponíveis na aplicação.

* * *

🗄️ Banco de Dados
------------------

Durante a inicialização do sistema, a aplicação realiza uma única requisição à API do TJSC para popular o banco de dados com as entidades retornadas.

**Por quê isso?**  
Durante o desenvolvimento, foi identificado que:

*   Os dados da entidade raramente mudam.
    
*   A API externa possui uma latência significativa.
    

Por isso, optou-se por armazenar localmente as entidades para otimizar o desempenho das requisições.

* * *

🔐 Sobre a autenticação
-----------------------

Embora o PDF do desafio mencione autenticação, a funcionalidade solicitada não exige autenticação com chave ou token, nem há um endpoint específico para login.

Mesmo assim, os campos de usuário e senha foram mantidos nas variáveis de ambiente, pensando em uma possível extensão futura da aplicação, onde autenticação possa ser necessária.

* * *

📦 Sobre o retorno de dados
---------------------------

O enunciado do desafio menciona o retorno de três atributos:

*   código
    
*   lei
    
*   nome da entidade
    

Ao consultar a documentação oficial, foi identificado que existem dois códigos por entidade: `cdentepub` e `cdocomarca`.

Como nenhum deles é explicitamente declarado como o "código da entidade", optou-se por utilizar o `cdentepub`.

* * *

🔍 Sobre a filtragem
--------------------

O PDF do desafio solicita a possibilidade de pesquisa por **nome** e **ID** da entidade.

Como o documento não menciona banco de dados, assumiu-se que o "ID" refere-se ao código da entidade. Em todo caso ambas as rotas foram implementadas para cobrir os dois casos.

* * *


🔍 Sobre o id
--------------------

É possivel observar que o id salvo no bano e retornado pela api não é um id sequencial mas sim um **UUID**.

Isso foi feito pensando na futura segurança, ja que um id sequencial gera uma lacuna a ser exposta em futuros ataques.

* * *

✅ Considerações finais
----------------------

Agradeço pela oportunidade de participar deste processo seletivo e pelo tempo dedicado à análise do projeto.  
Espero que o código desenvolvido atenda às expectativas e demonstre meu comprometimento com qualidade e clareza.

* * *
