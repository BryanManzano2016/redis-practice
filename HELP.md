## Docker

docker run --name redis-cache-server -d redis redis-server --save 60 1 --loglevel warning

docker exec -it <id> redis-cli

## HTTP

- Todos: /words/all

- ById: /words/{id}

- Create: /words/create/{key}/{value}