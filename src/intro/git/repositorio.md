# Git
## Repositorio

Los repositorios alojan el código junto con la meta-información asociada al histórico de cambios. Github proporciona uno basado en el VCS Git como un servicio en la nube.

1. Desde tu cuenta personal de Github [crea](https://github.com/new) un nuevo repositorio **público** llamado `ci-cd` inicializado con un fichero `README.md` .

1. Desde el nuevo repo `https://github.com/{usuario}/ci-cd` crea un nuevo Codespace. Una vez haya arrancado el entorno, desde el terminal del Codespace teclea:
   ```bash
   cd /tmp
   git clone https://github.com/{usuario}/ci-cd
   ls ci-cd
   cat ci-cd/README.md
   ```
   > 🔍 **Nota:** _Cambia `{usuario}` por tu nombre de usuario en Github._

   > ⁉️ **Pregunta:** _¿Para qué vale `git clone`? ¿en qué se diferencia de un "fork" del repo? ¿y de `git init`?_