[![Build Status](https://travis-ci.org/brunojsluz/poc-api-ecommerce.svg?branch=develop)](https://travis-ci.org/brunojsluz/poc-api-ecommerce)
[![Coverage Status](https://coveralls.io/repos/github/brunojsluz/poc-api-ecommerce/badge.svg?branch=master)](https://coveralls.io/github/brunojsluz/poc-api-ecommerce?branch=master)

## POC API ECOMMERCE

### Objetivo
O Objetivo dessa poc é obter conhecimento nos frameworks spring mvc, spring boot. Também tem como objetivo demonstrar um pouco do meu conhecimento com a linguagem Java. A poc ainda está em construção, ao longo do meu tempo livre vou aperfeiçoando o código e as funcionalidades. Está disponível uma versão online da API, no link [POC-API ECOMMERCE](https://poc-api-ecommerce.herokuapp.com/pedido)

### 1. Setup Manual
Devido ao uso do framework spring boot, a configuração inicial para o funcionamento da poc é bem simples, segue:
- Obrigatório ter o maven instalado e configurado no path do sistema operacional;
- Ter o aplicativo do `GIT` instalado;
- Ter o `Postgres` instalado, com uma base de dados criada;
- Clonar o repositório;
- Acessar o diretório `api/poc-api-ecommerce`;
- Configurar o arquivo `application.properties` com os dados de acesso ao Postgres(usuário, senha e nome da base);
- Executar o comando `mvn package` para fazer o build da aplicação;
- Acessar o diretório `/target`;
- Executar o comando no console `java -jar poc-api-ecommerce-1.0-SNAPSHOT.jar`;

### 2. Endpoint /item
- /item usando o método `GET`, retorna uma lista de todos os itens;
- /item usando o método `PUT`, passando um item como parâmetro, altera este item;
- /item usando o método `POST`, passando um item como parâmetro, salva este item;
- /item usando o método `DELETE`, passando um item como parâmetro, exclui este item;
- /item/busca/{codigo} usando o método `GET`, passando o codigo do item como parâmetro, busca um item;
- /item/busca/parcial/{descrição} usando o método `GET`, passando uma descrição qualquer, retorna uma lista de itens que contém a parte da descrição informada;
- /item/altera/preco usando o método `POST`, passando um objeto `{codigoItem e valor}`, altera o preço do item;

Exemplo de json para inserir um novo item usando o método `POST`:
``{
    "descricao": "Sabonete Nivia",
    "valor": 5.25,
    "observacao": "Sabonete liquido Nivia"
}``

### 3. Endpoint /pedido
- /pedido usando o método `GET`, retorna uma lista de todos os pedidos;
- /pedido/busca/{codigo} usando o metodo `GET`, passando o código como parâmetro, retorna o item referente ao codigo informado;
- /pedido/fecha/{codigo} usando o método `PUT`, atualiza o status do pedido para `FECHADO`;
- /pedido usando o método `PUT`, passando um pedido como parâmetro, atualiza o mesmo;
- /pedido usando o método `POST`, passando um pedido como parâmetro, insere o mesmo;
- /pedido usando o método `DELETE`, passando um pedido como parâmetro, exclui o mesmo;

Exemplo de json para inserir um pedido usando o método `POST`:
```
{
   "cliente": "Bruno Luz",
   "dataPedido": 1507172400000,
   "telefone": "51981911387",
   "valorTotalPedido": 48.00,
   "status": "ABERTO",
   "itensPedido": [
       {
           "item": {
            	"codigo": 50,
        	"descricao": "Sabonete Dove",
        	"valor": 6.30,
        	"observacao": "Sabonete liquido dove 500ml"
           },
           "valor": 7.00,
           "quantidade": 4,
           "valorTotal": 28.00
       },
        {
           "item": {
                "codigo": 52,
        	"descricao": "Desodorante Axe",
        	"valor": 9.35,
        	"observacao": "Desodorante Axe Spray"
           },
           "valor": 10.00,
           "quantidade": 2,
           "valorTotal": 20.00
       }
   ]
}
```
### 4. Justificativa e referencias
O Framework spring boot foi usado por abstrair inicialmente parte da configuração e definição de dependências que os projetos Java exigem. Uma das vantagens seria a rapidez no desenvolvimento da aplicação. O Postgres foi escolhido por ser um SGDB muito conhecido no mercado e também por estar disponível em plataformas que suportam aplicações Java, cito o exemplo do [Heroku](https://www.heroku.com/)
