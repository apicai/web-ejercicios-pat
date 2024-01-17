# Git
## Ramas

Los cambios en Git se realizan utilizando ramas. Las ramas representan una línea de desarrollo independiente dentro del repo. La rama inicial suele llamarse `main`[^1]. Los cambios en una rama se realizan en 3 pasos: `① add ➜ ② commit ➜ ③ push`.

1. Desde tu cuenta personal de Github [crea](https://github.com/new) un nuevo repositorio **público** llamado `ci-cd` inicializado con un fichero `README.md`.

1. Desde el nuevo repo `https://github.com/{usuario}/ci-cd` crea un nuevo Codespace. 

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
   git status
   git add .
   git commit -m "feat: homepage"
   git push origin main
   ```
   Comprueba que el nuevo directorio/fichero se encuentra ahora en el repo remoto (`https://github.com/{usuario}/ci-cd`).

   > **❓ Pregunta 1:** _¿Para qué han valido cada uno de los comandos `git` anteriores?_

1. Intenta repetir los pasos anteriores pero sobre el repositorio que vimos en la página anterior:

   ```bash
   cd /tmp
   git clone https://github.com/gitt-3-pat/p1
   cd p1
   touch nuevo.txt
   git add .
   git commit -m "feat: nuevo fichero"
   git push origin main
   ```

   > **❓ Pregunta 2:** _Explica por qué ha fallado en este caso, y por qué un ["fork"](https://docs.github.com/es/pull-requests/collaborating-with-pull-requests/working-with-forks/fork-a-repo) del repo anterior podría ser una solución_


[^1]: Antes se llamaba `master` y hay algunos repos que consevan ese nombre.