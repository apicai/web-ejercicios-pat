# HTTP
## Prerrequisitos

Para los ejercicios es necesario un terminal con los comandos `telnet`, `openssl`, `nc` y `curl` disponibles. Para ello, se puede usar un terminal de Github-Codespaces o el de un contenedor de Docker.

### Codespaces
1. Desde tu cuenta en Github [crea](https://github.com/codespaces/new?skip_quickstart=true&machine=basicLinux32gb&repo=525552024&ref=main&geo=EuropeWest) un Codespace y arráncalo[^1]
1. En el terminal del Codespace ejecuta:
   ```bash
   sudo apt update ; sudo apt install -y telnet netcat
   ```

### Docker
1. Arranca [Docker Desktop](https://www.docker.com/products/docker-desktop/).
1. Descarga este [Dockerfile](./files/Dockerfile).
1. En ese directorio abre un terminal (PowerShell en Windows) y ejecuta:
   ```bash
   docker build -t http . ; docker run -p 8080:8080 --rm -it http
   ```

> 🔍 **Nota:** _Como va a ser necesario durante los ejercicios repetir el mismo comando en cada paso, puedes utilizar la tecla <kbd>↑</kbd> en el terminal para recuperar el último comando ejecutado._

[^1]: Si el enlace anterior no funciona, [crea](https://github.com/codespaces/new) el Codespace en el repo `github/codespaces-blank`