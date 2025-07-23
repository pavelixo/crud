![Java](https://img.shields.io/badge/Java-21-red)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-Latest-blue)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.3-green)

Um projeto simples em Spring Boot de CRUD, no qual o Employee tem um name e relacionamento many-to-one com Role. É uma API para listagem e criação de objetos.

É um projeto razoavelmente simples de inicializar; não é preciso configurar variáveis de ambiente, basta ter Java 21 instalado e o Maven (opcional). Para rodar, use mvn spring-boot:run ou ./mvnw spring-boot:run.

> <sub> Eu fiz esse projeto em Java enquanto estava configurando meu ambiente. Não conseguia decidir qual Language Server Protocol usar: o da Red Hat, da extensão do Visual Studio Code, era muito chato de configurar; a extensão da Oracle travava muito. Então comecei mudando de IDE. Não podia usar o IntelliJ porque estou em um ambiente de desenvolvimento com recursos limitados. Decidi usar o Eclipse, que é pesado, mas nem tanto, tem uma LSP legal de usar e considerei produtivo. </sub>

> <sub>Alguns tratamentos de exceções nos endpoints não estão configurados, então as mensagens de erro ficam muito extensas.</sub>

### /roles
**POST**
```json
{
  "name": "programador",
}
```

**GET**
```json
[
    {
        "id": 1,
        "name": "programador"
    }
]
```

### /employees
**POST**
```json
{
  "name": "joão",
  "roleId": 1
}
```

**GET**
```json
[
    {
        "id": 1,
        "name": "joão",
        "role": {
            "id": 1,
            "name": "programador"
        }
    },
]
```
