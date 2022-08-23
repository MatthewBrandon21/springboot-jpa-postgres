
# Java Spring Boot Basic Backend

This project not related to any company, so feel free to make this repo for your base spring boot project.

This project applied clean and good architecture for immutability, security, and simplicity.
## Tech Stack

Java Spring Boot 2.7.0 + Spring Reactive Web + Lombok

**Database:** JPA, Postgress (Users, Store, Product)


## Run Locally

Clone the project

```bash
  git clone https://github.com/MatthewBrandon21/springboot-jpa-postgres.git
```

Go to the project directory

```bash
  cd springboot-jpa-postgres
```

Open in your java IDE

Sync Maven for depencency

Run app and automatically migrate the database (http://localhost:8080/)
## API Reference (Applied for all crud function)

#### Create Product

```
  POST /product/create
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `name` | `string` | **Required** |
| `description` | `string` | **Required** |
| `store_id` | `string` | **Required** |

#### Update product

```
  PUT /product/update/${id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `product_id` | **Required**. Id of product to update |
| `name` | `string` | **Required** |
| `description` | `string` | **Required** |
| `store_id` | `string` | **Required** |

#### List All product

```
  GET /product/all
```

#### Delete product

```
  DELETE /product/delete/${id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `product_id` | **Required**. Id of product to delete |


## Support

If need help, feel free to contact me! MatthewBrandon21

