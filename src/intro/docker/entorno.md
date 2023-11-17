# Docker
## Entorno desarrollo

En general, los repositorios de software contienen un `Dockerfile` para su construcción, distribución y despliegue, y un `docker-compose.yml` que arranca un entorno local para poder probar. Vamos a subir el `docker-compose.yml` al repo de `ci-cd`. Para ello nos faltaría configurar nuestras credenciales de Git en el contenedor `git`.

1. Con Docker arrancando, ejecuta desde un terminal:
   ```bash
   docker start -ai git
   ```
   ```bash
   # ... dentro del contenedor ...
   ssh-keygen -t ed25519 -C "{email-usuario-github}"
   # ... pulsa [↲] en cada paso ...
   git config --global user.email "{email-usuario-github}"
   git config --global user.name "{usuario-github}"
   cat /root/.ssh/id_ed25519.pub
   # ... copia la salida del comando anterior ...
   ```

1. Entra en Github Settings `➜` SSH and GPG keys `➜` New SSH key (`https://github.com/settings/ssh/new`) y añade la clave SSH:
   - Title: practicas
   - Key: pega la clave SSH copiada del terminal

1. Desde el terminal:
   ```bash
   cd /practicas/ci-cd
   git remote set-url origin git@github.com:{usuario-github}/ci-cd.git
   git checkout -b feat/local-env
   git add .
   git commit -m "feat: local-env"
   git push origin feat/local-env
   # ... confía en la conexión con Github escribiendo yes ...
   ```

1. Entra en Github y crea la PR (`https://github.com/{usuario}/ci-cd/pull/new/feat/local-env`).

> **❓ Pregunta:** _El entorno de desarrollo local nos permite descargar, modificar, construir, validar, probar y subir el código. ¿Desde dónde y con qué realizarías cada una de esas acciones en el entorno local basado en contenedores que hemos montado?_

> **❓ Pregunta:** _Los pasos de configuración de Git podrían haberse incluido en la imagen como instrucciones `RUN` y `ADD` del Dockerfile. ¿Cuáles son las ventajas y desventajas con respecto a hacerlo en el contenedor?_
