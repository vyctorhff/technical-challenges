# About

# Run

sudo docker-compose up -d

## Ferramentas desenvolvimento

### Kafka - offset

https://www.kafkatool.com/

export INSTALL4J_JAVA_HOME=<path>jdk-11.0.2

### Elastic Search - Kibana

docker pull docker.elastic.co/kibana/kibana:9.1.5
docker run --name kib01 --net elastic -p 5601:5601 docker.elastic.co/kibana/kibana:9.1.5

### MySQL interface

docker run --name phpmyadmin --network e-commerci-catalog_app-net -d -e PMA_ARBITRARY=1 -p 8080:80 phpmyadmin