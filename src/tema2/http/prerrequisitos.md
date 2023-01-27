# HTTP
## Prerrequisitos

Para los ejercicios es necesario un terminal con los comandos `telnet`, `openssl`, `nc` y `curl` disponibles. Para ello, se puede usar un terminal de Github-Codespaces o el de un contenedor de Docker.

### Docker
1. Arranca [Docker Desktop](https://www.docker.com/products/docker-desktop/).
2. Descarga este [Dockerfile](./files/Dockerfile).
3. En ese directorio abre un terminal y ejecuta:
   ```bash
   docker build -t http . ; docker run -p 8080:8080 --rm -it http
   ```

### Codespaces
1. Desde tu cuenta en Github [crea](https://github.com/codespaces/new) un Codespace en el repo `github/codespaces-blank` y arráncalo.
2. En el terminal del Codespace ejecuta:
   ```bash
   sudo apt update ; sudo apt install -y telnet netcat
   ```

> 🔍 **Nota:** _Como va a ser necesario durante los ejercicios repetir el mismo comando en cada paso, puedes utilizar la tecla <kbd>↑</kbd> en el terminal para recuperar el último comando ejecutado._