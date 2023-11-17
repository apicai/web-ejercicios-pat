# Docker
## Contenedores

Los contenedores se arrancan a partir del nombre de la imagen. Los contenedores ejecutan un único proceso y cuando éste termina se detiene el contenedor. Los contenedores parados se pueden volver a arrancar sin perder sus datos entre reinicios. Además, pueden compartir ficheros con el SO anfitrión.

1. Con Docker arrancando, ejecuta desde un terminal:
   ```bash
   docker run --name git -v $(pwd):/practicas:rw -it git
   ```
   ```bash
   # ... dentro del contenedor ...
   cd /practicas
   git clone https://github.com/{usuario}/ci-cd
   exit
   ```
   > ⚠️ **Importante**: _El repo `https://github.com/{usuario}/ci-cd` es el creado en la práctica de Git. Si no la hiciste, entra Github y [crea](https://github.com/new) un nuevo repositorio público llamado "ci-cd" inicializado con un fichero README.md._

1. Comprueba que también se ha creado el directorio `practicas/ci-cd/` en tu SO anfitrión.

   > **❓ Pregunta:** _Explica qué hace concretamente el `docker run` utilizado. ¿Cuál es el proceso que ejecuta el contenedor al arrancarse? ¿Por qué necesitamos el modo `rw` y no basta con `ro`?_

1. Ejecuta en el terminal anterior: 
   ```bash
   docker ps --all
   docker start -ai git
   ```
   ```bash
   # ... dentro del contenedor ...
   exit
   ```
   > **❓ Pregunta:** _¿Por qué `docker ps` dice que el contenedor está parado? ¿Por qué en la última parte tenemos que usar `docker start` en vez de `docker run`? ¿Por qué no necesitamos especificar la carpeta compartida con `docker start`?_





