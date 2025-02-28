<h1 align=center> Produtos Frescos - Projeto Integrador </h1>
<p align=center> TRANSFORMELI Grupo 2 </p>
<br>

## ✅ Testes
* Requisito 6 [`src/test/.../service/OrderServiceTest.java`](src/test/java/br/com/dh/meli/projeto_integrador/service/OrderServiceTest.java)
* Unitários [`src/test/java/br/com/dh/meli/projeto_integrador`](src/test/java/br/com/dh/meli/projeto_integrador)

## 🚩 Postman collection
* Variveis do Postman [`src/main/resources/collection/workspace.postman_globals.json`](src/main/resources/collection/workspace.postman_globals.json)
* Exemplos de Uso [`src/main/resources/collection/Projeto_Integrador.postman_collection.json`](src/main/resources/collection/Projeto_Integrador.postman_collection.json)
* Requisito 6 [`src/main/resources/collection/Isaias-Finger.postman_collection.json`](src/main/resources/collection/Isaias-Finger.postman_collection.json)

## 📌 Requisito 6 - Isaias Finger
* User Story [`docs/UserStory-Requisito-06-Isaias-Finger.pdf`](docs/UserStory-Requisito-06-Isaias-Finger.pdf)
* DER [`docs/Projeto-Integrador-DB.pdf`](docs/Projeto-Integrador-DB.pdf)
```http
GET /api/v1/fresh-products/customer/${customerId}/orders
```
| Parameter    | Type   | Description              |
|:-------------|:-------|:-------------------------|
| `customerId` | `long` | **Required**. CustomerId |
#### Response
```json
[
  {
    "id": 1,
    "orderDate": "2022-08-16T20:12:45.945958",
    "status": "FECHADO",
    "customerId": 1,
    "totalPrice": 200.0,
    "items": [
      {
        "advertisementId": 1,
        "batchNumber": 3,
        "quantity": 1,
        "unitPrice": 200.0,
        "price": 200.0
      }
    ]
  }
]
```

## 📝 Proposta
Criar uma API REST que faz o gerenciamento de estoque e venda de produtos frescos.

* API DE PRODUTOS FRESCOS

## 🚀 Como clonar e iniciar a aplicação

- Abra seu terminal e digite o seguinte comando:

```
git clone git@github.com:rebecccruz/projeto_integrador.git
```

- Ainda em seu terminal digite o comando abaixo para entrar na pasta do projeto:

```
cd projeto_integrador
```

- Instale as dependências do maven:

```
mvn install
```

ou
<br>

```
maven install
```

- Rode localmente:

```
mvn spring-boot:run
```

## 👥 Membros do grupo

- <a href="https://github.com/aborgssouzameli">Alexandre Borges Souza</a>
- <a href="https://github.com/evycoliveira">Evelyn Cristini Oliveira</a>
- <a href="https://github.com/isaiasfmeli">Isaias Finger</a>
- <a href="https://github.com/laridevmeli">Larissa Navarro</a>
- <a href="https://github.com/lucaspinheirorocha">Lucas Pinheiro Rocha</a>
- <a href="https://github.com/rebecccruz">Rebecca da Cunha Cruz</a>
