# Git
## Ramas

Los cambios en Git se realizan utilizando ramas. Las ramas representan una línea de desarrollo independiente dentro del repo. La rama inicial suele llamarse `main`[^1]. Los cambios en una rama se realizan en 3 pasos: `① add ➜ ② commit ➜ ③ push`.

1. Desde el Codespace anterior y usando el editor crea un nuevo directorio `src` y un fichero `index.html` dentro de él con el siguiente contenido:
   ```html
   <!DOCTYPE html>
   <html>
   <head><title></title></head>
   <body></body>
   </html>
   ```

1. Desde el terminal del Codespace teclea:
   ```bash
   cd /workspaces/ci-cd
   git status
   git add .
   git commit -m "feat: homepage"
   git push origin main
   ```
   Comprueba que el nuevo directorio/fichero se encuentra ahora en el repo remoto (`https://github.com/{usuario}/ci-cd`).

   > 🔍 **Nota:** _En este caso no hemos necesitado hacer el `clone` puesto que el Codespace de este repo ya lo ha hecho automáticamente por nosotros._

   > **❓ Pregunta 1:** _¿Para qué han valido cada uno de los comandos `git` anteriores?_

1. Intenta hacer cambios sobre el repo `p1` que vimos en la página anterior:
   ```bash
   cd /workspaces/p1
   touch nuevo.txt
   git add .
   git commit -m "feat: nuevo fichero"
   git push origin main
   ```

   > **❓ Pregunta 2:** _Explica por qué ha fallado en este caso, viendo el resultado de los comandos en el terminal_

1. Repite los pasos anteriores pero sobre el `p1-fork`:
   ```bash
   cd /workspaces/p1-fork
   touch nuevo.txt
   git add .
   git commit -m "feat: nuevo fichero"
   git push origin main
   ```

   > **❓ Pregunta 3:** _¿Por qué ahora sí ha funcionado?_


[^1]: Antes se llamaba `master` y hay algunos repos que consevan ese nombre.