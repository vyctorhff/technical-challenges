# simplified-payment

rewrite!!!!
Desafio técnico - projeto que permite a   transferência bancárias entre usuários

## Docs

Some images of the architecture
See ./docs

## Execute

docker-compose up -d

./ms-user/gradlew bootRun
./ms-transference/gradlew bootRun

## Database

http://localhost:8080/h2-console


## transfer-ms flow

- find user in cache
- check if user exists
- check account can tarnsfer
- check it has founds
- check authorization
- do transfer
- send notification
- generate id-transaction

## wallet-ms endpoints

- get user by id
- get user by list of ids
- cors for transfer
