# Docker
## Orquestación

Un servicio real suele componerse de varios componentes (servidores web, backends, bases de datos, brokers de mensajes, etc.). En una arquitectura de microservicios esos componentes se despliegan como contenedores, y es necesario coordinar su arranque y comunicación. En un entorno real se utiliza [Kubernetes](https://kubernetes.io/), pero para probar en un entorno local se suele usar [Docker Compose](https://docs.docker.com/compose/).

1. Crea el fichero `practicas/ci-cd/docker-compose.yml` con este contenido:
   ```yaml
   version: "3.9"
   name: ci-cd
   services:
     vnu:
       image: ghcr.io/validator/validator:latest
       container_name: vnu
       ports: [ "8888:8888" ]
     web:
       image: nginx:alpine
       container_name: web
       volumes: [ "./src:/usr/share/nginx/html:ro" ]
       ports: [ "8080:80" ]
   ```
   > **❓ Pregunta:** _Explica qué hace el `docker-compose.yaml` utilizado. ¿Por qué basta con usar el modo `ro` en el servicio `web`?_

1. Con Docker arrancando, ejecuta en un terminal:
   ```bash
   cd {ruta}/practicas/ci-cd
   docker-compose up -d
   docker ps
   ```

1. Entra con un navegador web en `http://localhost:8080/`, modifica el fichero `practicas/ci-cd/src/index.html` en tu SO y refresca el navegador.

1. Entra con un navegador web en `http://localhost:8888/` y chequea esta URL `http://web`.

   > **❓ Pregunta:** _¿Por qué usamos `http://web` en lugar de `http://localhost:8080` para validar nuestra página web?_

