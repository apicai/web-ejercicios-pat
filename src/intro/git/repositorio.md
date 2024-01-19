# Git
## Repositorio

Los repositorios alojan el código junto con la meta-información asociada al histórico de cambios. Github proporciona uno basado en el VCS Git como un servicio en la nube.

1. Desde tu cuenta personal de Github [crea](https://github.com/new) un nuevo repositorio **público** llamado `ci-cd` inicializado con un fichero `README.md` .

1. [Crea un Codespace](https://github.com/codespaces/new) en el repositorio anterior. Una vez haya arrancado el entorno, desde el terminal del Codespace teclea:
   ```bash
   cd /workspaces
   git clone https://github.com/gitt-3-pat/p1
   ls p1
   cat p1/README.md
   ```

   > **❓ Pregunta 1:** _¿Para qué ha valido el `git clone`?_

1. Realiza un ["fork"](https://github.com/gitt-3-pat/p1/fork) del repositorio anterior, **poniéndole de nombre `p1-fork`**, y repite los pasos sobre él:
   ```bash
   cd /workspaces
   git clone https://github.com/{usuario}/p1-fork
   ls p1-fork
   cat p1-fork/README.md
   ```
   > ⚠️ **Importante**: _Sustituye el `{usuario}` de la URL del clone por tu usuario de Github. Ejemplo: `{usuario} ⟶ apicai`._

   > **❓ Pregunta 2:** _Consulta la información sobre ["fork"](https://docs.github.com/es/pull-requests/collaborating-with-pull-requests/working-with-forks/fork-a-repo), y explica qué hemos conseguido haciéndolo._