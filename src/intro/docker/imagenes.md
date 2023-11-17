# Docker
## Imágenes

Para crear una imagen que contenga las librerías, herramientas, configuraciones, etc. necesarias para ejecutar nuestra aplicación se utiliza un [Dockerfile](https://docs.docker.com/engine/reference/builder/). Los Dockerfile parten de una imagen padre base sobre la que se instalan las dependencias necesarias. Las imágenes públicas se alojan en un "registry"[^1] del que se descargan si no están cacheadas localmente.

1. Crea el fichero `practicas/Dockerfile` con este contenido:
   ```bash
   FROM alpine
   RUN apk add --no-cache bash openssh git git-bash-completion
   RUN git clone https://github.com/magicmonty/bash-git-prompt.git /root/.bash-git-prompt --depth=1
   RUN echo -e "source /usr/share/bash-completion/completions/git\nsource /root/.bash-git-prompt/gitprompt.sh" > /root/.bashrc
   CMD ["/bin/bash"]
   ```
   > **❓ Pregunta:** _¿Para que valen las instrucciones `FROM`, `RUN` y `CMD`? ¿Qué software estará disponible en la imagen?_

1. Con Docker arrancando, ejecuta en un terminal:
   ```bash
   cd {ruta}/practicas
   docker build -t git .
   docker images
   ```

   > **❓ Pregunta:** _¿Qué hacen los comandos `docker` anteriores? ¿Cuál es el "registry", "repository" y "tag" de la imagen padre descargada?_

[^1]: Identificadas con este formato de nombre: `registry/repository:tag`