# Git
## Git flow

Es el convenio que elige cada equipo de desarrollo para organizar el uso de las ramas del repo. Github-Flow es uno de ellos, y propone: ❶ la rama `main` siempre tiene el código válido y desplegable, ❷ los cambios se hacen en ramas nuevas desde `main`, ❸ las Pull Requests (PR) permiten solicitar la incorporación de los cambios en `main`, ❹ tras la revisión de la PR, los cambios se mezclan en `main`.

1. Desde el terminal del Codespace anterior teclea:
   ```bash
   cd /workspaces/ci-cd
   git checkout -b feat/add-body
   ```

1. Desde el editor del Codespace actualiza la línea `<body><p>Hola {usuario}</p></body>` del fichero `src/index.html`.

1. Desde el terminal del Codespace teclea:
   ```bash
   git add .
   git commit -m "feat: add body"
   git push origin feat/add-body
   ```

1. Crea una nueva PR de `feat/add-body ➜ main` en Github (`https://github.com/{usuario}/ci-cd/pull/new/feat/add-body`), revísala y mezcla.

1. Desde el terminal del Codespace teclea:
   ```bash
   git checkout main
   git pull origin main
   ```

> **❓ Pregunta:** _¿Para qué han valido los comandos `git checkout -b`, `git checkout` y `git pull`? ¿Cuáles son los beneficios de usar este flujo de trabajo en el contexto de un desarrollo colaborativo?_
> <details><summary><em>Diagrama de git y Gitflow</em></summary><br>
> <object type="image/svg+xml" data="./files/git.excalidraw.svg" width="100%"></object>
> </details>
> <br>

