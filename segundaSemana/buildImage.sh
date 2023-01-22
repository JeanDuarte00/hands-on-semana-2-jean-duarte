
sudo docker build -t jeanduarte00/projeto-segunda-semana:latest ./
sudo docker run -p 8080:8080 --name segundaSemana jeanduarte00/projeto-segunda-semana:latest

sudo docker-compose --env-file ./local/environments/dev.env -f ./local/docker-compose.yaml down