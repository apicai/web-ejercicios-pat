# HTML
## Formularios

Permiten crear un **interfaz de usuario para que éste envíe información al servidor**. Se crean con la etiqueta [`<form>`](https://developer.mozilla.org/en-US/docs/Web/HTML/Element/form), para agrupar campos se utiliza [`<fieldset>`](https://developer.mozilla.org/en-US/docs/Web/HTML/Element/fieldset) , [`<label>`](https://developer.mozilla.org/en-US/docs/Web/HTML/Element/label) para describirlos, e [`<input>`](https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input#input_types), [`<select>`](https://developer.mozilla.org/en-US/docs/Web/HTML/Element/select) y [`<textarea>`](https://developer.mozilla.org/en-US/docs/Web/HTML/Element/textarea) son los diferentes tipos de campos.

> **❓ Ejercicio:** _Completa el siguiente HTML utilizando las etiquetas `<input>` del tipo adecuado, `<select>` y `<textarea>` para que el formulario tenga los siguientes controles:_
> 1. _Un grupo de campos conteniendo el nombre, teléfono y correo-e del cliente, solo el último obligatorio._
> 2. _Otro grupo de campos con las características del producto: modelo, tamaño, color, cantidad y extras, todos obligatorios menos el último._
> 3. _Otro grupo de campos con las preferencias de entrega: fechas e instrucciones, opcionales._
> 4. _Otro grupo de controles para enviar y limpiar el formulario._
> <div class="codepen" data-prefill data-height="600" data-theme-id="light" data-default-tab="html,result" data-editable="true" style="opacity:0">
> <pre data-lang="html">&lt;body>
> &lt;form action="URL absoluta o relativa" method="get o post">
>  &lt;h2>Formulario del pedido&lt;/h2>
>  &lt;fieldset>
>   &lt;legend>Datos personales&lt;/legend>
>   &lt;p>
>    &lt;label for="name_id">Nombre:&lt;/label>&lt;br>
>    &lt;!-- Campo de texto -->
>   &lt;/p>
>   &lt;p>
>    &lt;label for="phone_id">Teléfono:&lt;/label>&lt;br>
>    &lt;!-- Campo de teléfono -->
>   &lt;/p>
>   &lt;p>
>    &lt;label for="email_id">Email:&lt;/label>&lt;br>
>    &lt;!-- Campo de email obligatorio -->
>   &lt;/p>
>  &lt;/fieldset>
>  &lt;fieldset>
>   &lt;legend>Producto&lt;/legend>
>   &lt;p>
>    &lt;label for="model_id">Modelo:&lt;/label>&lt;br>
>    &lt;!-- Menú con 1 opción seleccionable de entre estas: Modelo 1, Modelo 2 y Modelo 3 --> 
>   &lt;/p>
>   &lt;p>Tamaño:
>    &lt;ul>
>     &lt;li>
>      &lt;!-- Opción excluyente obligatoria -->
>      &lt;label for="size-1_id">S&lt;/label>
>     &lt;/li>
>     &lt;li>
>      &lt;!-- Opción excluyente obligatoria -->
>      &lt;label for="size-2_id">M&lt;/label>
>     &lt;/li>
>     &lt;li>
>      &lt;!-- Opción excluyente obligatoria -->
>      &lt;label for="size-3_id">L&lt;/label>
>     &lt;/li>
>    &lt;/ul>
>   &lt;/p>
>   &lt;p>
>    &lt;label for="color_id">Color:&lt;/label>&lt;br>
>    &lt;!-- Campo de color obligatorio -->
>   &lt;/p>
>   &lt;p>
>    &lt;label for="amount_id">Cantidad:&lt;/label>&lt;br>
>    &lt;!-- Campo numérico con valor mínimo 1 y máximo 5 obligatorio -->
>   &lt;/p>
>   &lt;p>Extras:
>    &lt;ul>
>     &lt;li>
>      &lt;!-- Casilla de verificación -->
>      &lt;label for="extra-1_id">Extra 1&lt;/label>
>     &lt;/li>
>     &lt;li>
>      &lt;!-- Casilla de verificación -->
>      &lt;label for="extra-2_id">Extra 2&lt;/label>
>     &lt;/li>
>     &lt;li>
>      &lt;!-- Casilla de verificación -->
>      &lt;label for="extra-3_id">Extra 3&lt;/label>
>     &lt;/li>
>    &lt;/ul>
>   &lt;/p>
>  &lt;/fieldset>
>  &lt;fieldset>
>   &lt;legend>Entrega&lt;/legend>
>   &lt;p>
>    &lt;label for="fecha_id">Fecha:&lt;/label>&lt;br>
>    &lt;!-- Campo de fecha con valor minimo la fecha de hoy -->
>   &lt;/p>
>   &lt;p>
>    &lt;label for="instructions_id">Instrucciones:&lt;/label>&lt;br>
>    &lt;!-- Área de texto -->
>   &lt;/p>
>  &lt;/fieldset>
>  &lt;fieldset>
>   &lt;!-- Botón para enviar -->
>   &lt;!-- Botón para resetear el formulario -->
>  &lt;/fieldset>
> &lt;/form>
> &lt;/body>
> </pre></div>