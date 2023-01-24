# CSS
## Sintaxis

CSS se basa en el uso de [selectores](https://developer.mozilla.org/en-US/docs/Learn/CSS/Building_blocks/Selectors) de elementos HTML a los que se les aplicará un conjunto de estilos:

```css
selector-1 {
  propiedad-estilo-1: valor-estilo-1;
  propiedad-estilo-2: valor-estilo-2;
  ...
}
selector-2 { ... }
...
```

Para que se apliquen estos estilos a un documento HTML hay 3 posibilidades:

1. Referenciando a ficheros CSS externos:
    ```html
    <!DOCTYPE html>
    <html lang="">
    <head>
      <title>Recomendado</title>
      <link rel="stylesheet" href="URL (absoluta o relativa) al fichero CSS" />
    </head>
    <body><h1>Elemento estilizado</h1></body>
    </html>
    ```

1. Incluyéndolos dentro del propio HTML:
    ```html
    <!DOCTYPE html>
    <html lang="">
    <head>
      <title>Menos recomendado</title>
      <style>
        h1 {
            color: blue;
        }
      </style>
    </head>
    <body><h1>Elemento estilizado</h1></body>
    </html>
    ```

1. Aplicándolos directamente al elemento en cuestión (no se necesita el selector):
    ```html
    <!DOCTYPE html>
    <html lang="">
    <head>
      <title>El menos recomendado</title>
    </head>
    <body><h1 style="color: blue;">Elemento estilizado</h1></body>
    </html>
    ```