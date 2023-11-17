# Git
## CI/CD

Combinando ambos procesos es posible automatizar los despliegues de nuevas versiones con la certeza de que no tienen fallos y que, en caso de haberlos, se impida la integración de los cambios y su despliegue.

1. Modifica esta sección del workflow de CI con:
   ```yaml
   on:
     pull_request:
       branches: [ "main" ]
     workflow_call:
   ```

1. Modifica el comienzo de esta sección del workflow de CD con:
   ```yaml
   jobs:
     ci:
       uses: ./.github/workflows/ci.yml
     deploy:
       needs: [ci]
   ```

1. Sube los cambios y comprueba el resultado en las Actions del repo (`https://github.com/{usuario}/ci-cd/actions`).
   > **❓ Pregunta:** _¿Puedes explicar los cambios anteriores a partir del resultado observado?_

1. Modifica el fichero `./src/index.html` para que la CI pase, sube los cambios y comprueba el resultado en las Actions del repo y en la web desplegada.
   
   > **❓ Pregunta:** _¿Qué Actions se ejecutan al hacer una PR y cuáles se ejecutan al mezclar cambios en `main`? ¿Por qué representa un problema subir directamente los cambios a `main` en lugar de usar una PR?_

1. Entra en las reglas de protección de ramas del repo en Github (`https://github.com/{usuario}/ci-cd/settings/branches`) `➜` "Add rule" y usa estos valores:
   - Branch name pattern: `main`
   - ☑️ Require a pull request before merging
   - ☑️ Require status checks to pass before merging

   > **❓ Pregunta:** _¿Qué ocurre ahora al intentar hacer cambios directamente en `main`? ¿y al hacer una PR conteniendo un cambio que no pasa la CI?_

> ⚠️ **Importante**: _para o borra el [Codespace](https://github.com/codespaces) al terminar de usarlo._