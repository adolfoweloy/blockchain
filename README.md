# Toy Blockchain in Java

I have created this project when reading the Post [Learn Blockchains by Building One](https://hackernoon.com/learn-blockchains-by-building-one-117428612f46) written by Daniel van Flymen.
As the examples in his blog post is in python and I work with Java I preferred to translate the source code so I could better understand the principles behind the blockchain data-structure.

To run this project you can just download and run the following command:
```
mvn spring-boot:run
```

To add new transactions:
```
curl -X POST \
  http://localhost:8080/transaction \
  -H 'content-type: application/json' \
  -d '{
    "recipient": "Possidonio Antunes",
    "sender": "Dona Nevinha",
    "amount": 50000.00
}'
```

To list all the chain:
```
curl -X GET http://localhost:8080/chain 
```

To mine for new blocks:
```
curl -X POST http://localhost:8080/mine
```

