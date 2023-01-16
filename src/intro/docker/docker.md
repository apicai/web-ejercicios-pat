# Docker

**Docker** es el gestor de contenedores más popular. Un **contenedor** es un paquete que incluye todo lo necesario para ejecutar de manera independiente una aplicación. Los contenedores se ejecutan[^1] de forma aislada y virtualizada de modo que la aplicación solo ve los recursos asignados al contenedor. Esto permite distribuir[^2] el software garantizando el mismo comportamiento en todos los entornos, orquestar el despliegue de varios contenedores conformando un servicio, y automatizar la asignación de recursos en función de la carga (escalado horizontal)[^3].

## Objetivos

- Usar Docker desde la línea de comandos para crear imágenes y arrancarlas localmente como contenedores.

- Usar Docker Compose para montar un entorno de desarrollo local que nos permita hacer lo mismo que en la práctica de Git (que usaba el entorno de desarrollo en la nube Github-Codespaces).

- Tener un entorno de desarrollo local con las herramientas necesarias para las prácticas (`git`, `java`, validadores, servidores, etc.).

[^1]: Existen varios "runtimes", el que usa Docker está basado originalmente en [containerd](https://containerd.io/).

[^2]: El formato en que se distribuye se llama imagen, y el que usa Docker está basado en [OCI](https://opencontainers.org/).

[^3]: [Kubernetes](https://kubernetes.io/) es la plataforma más popular que gestiona la infraestructura hardware subyacente como un único recurso computacional que corre contenedores.

