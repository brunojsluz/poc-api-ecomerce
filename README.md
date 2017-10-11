[![Build Status](https://travis-ci.org/brunojsluz/poc-api-ecommerce.svg?branch=develop)](https://travis-ci.org/brunojsluz/poc-api-ecommerce)

## POC API ECOMMERCE

### Objetivo
O Objetivo dessa poc é obter conhecimento nos frameworks spring mvc, spring boot. Tambem tem como objetivo demonstrar um pouco do meu conhecimento com a linguagem Java. A poc ainda esta em contrução, ao longo do meu tempo livre vou aperfeiçoando o codigo e as funcionalidades.

### 1. Setup
Devido ao uso do framework spring boot, a configuração inicial para o funcionamento da poc é bem simples, segue:
- Obrigatorio ter o maven instalado e configurado no path do sistema operacional;
- Ter o aplicativo do GIT instalado;
- Ter o Postgres instalado, com uma base de dados criada;
- Clonar o repositorio;
- Acessar o diretorio api/poc-api-ecommerce;
- Configurar o arquivo application.properties com os dados de acesso ao Postgres(usuario, senha e nome da base);
- Executar o comando mvn package para buildar a aplicação;
- Acessar o diretorio /target;
- Executar o comando no console java -jar poc-api-ecommerce-1.0-SNAPSHOT.jar

### 2. Endpoint /item
- /item usando o método `GET` retorna uma lista de todos os itens;
- /item usando o método `PUT`, passando um item como parametro, altera este item;
- /item usando o método `POST`, passando um item como parametro, salva este item;
- /item usando o método `DELETE`, passando um item como parametro, exclui este item;
- /item/busca/{codigo} usando o método `GET`, passando o codigo do item como parametro, busca um item;
- /item/busca/parcial/{descricao} usando o método `GET`, passando uma descrição parcial do item, retorna uma lista de itens;
- /item/altera/preco usando o método `POST`, passando um objeto `{codigoItem e valor}`, altera o preço do item;

### 3. Endpoint /pedido
