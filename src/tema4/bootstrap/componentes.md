# Bootstrap
## Componentes

Bootstrap facilita la creación de los [contenidos y componentes](https://getbootstrap.com/docs/5.3/examples/cheatsheet/) típicos de un interfaz web mediante el uso de clases específicas sobre los elementos HTML. Algunas de estas clases son luego procesadas mediante Javascript para dar comportamiento. A continuación se muestran algunos que no usan el Javascript de Bootstrap.

<details onclick='setTimeout(function(){__CPEmbed(".cp-later")},1)'><summary><strong>Cabecera y pie</strong></summary><br/>
<div class="cp-later" data-height="350" data-theme-id="light" data-default-tab="html,result" data-editable="true" style="opacity:0" data-prefill='{"stylesheets":["https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css","https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css"]}'>
  <pre data-lang="html">&lt;body>
  &lt;nav class="navbar navbar-expand bg-dark" data-bs-theme="dark">
    &lt;div class="container-fluid">
      &lt;a class="navbar-brand" href="#">&lt;i class="bi bi-lightbulb-fill">&lt;/i> Nombre de la web&lt;/a>
      &lt;ul class="navbar-nav ml-auto">
        &lt;li class="nav-item">
          &lt;a class="nav-link active" aria-current="page" href="#">Sección 1&lt;/a>
        &lt;/li>
        &lt;li class="nav-item">
          &lt;a class="nav-link" href="#">Sección 2&lt;/a>
        &lt;/li>
        &lt;li class="nav-item">
          &lt;a class="nav-link" href="#">Sección 3&lt;/a>
        &lt;/li>
        &lt;li class="nav-item">
          &lt;a class="nav-link disabled">Sección 4&lt;/a>
        &lt;/li>
      &lt;/ul>
    &lt;/div>
  &lt;/nav>
  &lt;main>&lt;/main>
  &lt;footer class="fixed-bottom">
    &lt;p class="border-top pt-3 text-center text-muted">&copy; 2023 Nombre de la web&lt;/p>
  &lt;/footer>
&lt;/body></pre>
  <pre data-lang="css">html { font-size: 50%; }</pre></div>
<br/></details>

<details onclick='setTimeout(function(){__CPEmbed(".cp-later")},1)'><summary><strong>Listas</strong></summary><br/>
<div class="cp-later" data-height="350" data-theme-id="light" data-default-tab="html,result" data-editable="true" style="opacity:0" data-prefill='{"stylesheets":["https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css","https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css"]}'>
  <pre data-lang="html">&lt;body>
&lt;ul class="list-group list-group-numbered">
  &lt;li class="list-group-item">Elemento normal&lt;/li>
  &lt;li class="list-group-item list-group-item-info">Elemento con color&lt;/li>  
  &lt;li class="list-group-item active" aria-current="true">Elemento activado&lt;/li> 
  &lt;li class="list-group-item disabled" aria-disabled="true">Elemento desactivado&lt;/li>
  &lt;li class="list-group-item list-group-item-action">Elemento interactivo&lt;/li>
&lt;/ul>
&lt;/body></pre>
  <pre data-lang="css">html { font-size: 75%; padding: 2rem; }</pre></div>
<br/></details>

<details onclick='setTimeout(function(){__CPEmbed(".cp-later")},1)'><summary><strong>Tablas</strong></summary><br/>
<div class="cp-later" data-height="350" data-theme-id="light" data-default-tab="html,result" data-editable="true" style="opacity:0" data-prefill='{"stylesheets":["https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css","https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css"]}'>
  <pre data-lang="html">&lt;body>
&lt;table class="table table-striped table-hover table-responsive">
  &lt;caption>Estilos de tablas en Bootstrap&lt;/caption>
  &lt;thead>
    &lt;tr>
      &lt;th scope="col">#&lt;/th>
      &lt;th scope="col">Tipos&lt;/th>
      &lt;th scope="col">Clase&lt;/th>
      &lt;th scope="col">Ejemplo&lt;/th>
    &lt;/tr>
  &lt;/thead>
  &lt;tbody>
    &lt;tr>
      &lt;th scope="row">1&lt;/th>
      &lt;td>Con colores&lt;/td>
      &lt;td>&lt;code>table-{color}&lt;/code>&lt;/td>
      &lt;td>&lt;code>&amp;lt;tr class="table-info">&lt;/code>&lt;/td>
    &lt;/tr>
    &lt;tr>
      &lt;th scope="row">2&lt;/th>
      &lt;td>Con franjas&lt;/td>
      &lt;td>&lt;code>table-striped&lt;/code>&lt;/td>
      &lt;td>&lt;code>&amp;lt;table class="table table-striped">&lt;/code>&lt;/td>
    &lt;/tr>
    &lt;tr>
      &lt;th scope="row">3&lt;/th>
      &lt;td>Interactiva&lt;/td>
      &lt;td>&lt;code>table-hover&lt;/code>&lt;/td>
      &lt;td>&lt;code>&amp;lt;table class="table table-hover">&lt;/code>&lt;/td>
    &lt;/tr>
    &lt;tr>
      &lt;th scope="row">4&lt;/th>
      &lt;td>Sin bordes&lt;/td>
      &lt;td>&lt;code>table-borderless&lt;/code>&lt;/td>
      &lt;td>&lt;code>&amp;lt;table class="table table-borderless">&lt;/code>&lt;/td>
    &lt;/tr>
    &lt;tr>
      &lt;th scope="row">5&lt;/th>
      &lt;td>Responsiva&lt;/td>
      &lt;td>&lt;code>table-responsive&lt;/code>&lt;/td>
      &lt;td>&lt;code>&amp;lt;table class="table table-responsive">&lt;/code>&lt;/td>
    &lt;/tr>
  &lt;/tbody>
&lt;/table>
&lt;/body></pre>
  <pre data-lang="css">html { font-size: 50%; padding: 2rem; }</pre></div>
<br/></details>

<details onclick='setTimeout(function(){__CPEmbed(".cp-later")},1)'><summary><strong>Formularios</strong></summary><br/>
<div class="cp-later" data-height="350" data-theme-id="light" data-default-tab="html,result" data-editable="true" style="opacity:0" data-prefill='{"stylesheets":["https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css","https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css"]}'>
  <pre data-lang="html">&lt;body>
  &lt;form class="row g-3">
    &lt;div class="col-md-12">
      &lt;label for="usuario" class="form-label">Usuario&lt;/label>
      &lt;div class="input-group">
        &lt;input type="text" class="form-control" id="usuario" required="">
        &lt;span class="input-group-text" id="inputGroupPrepend">@gmail.com&lt;/span>
      &lt;/div>
    &lt;/div>
    &lt;div class="col-md-12 form-floating">
      &lt;textarea class="form-control" placeholder="Añade un comentario" id="comment" style="height: 70px">&lt;/textarea>
      &lt;label for="comment">Comentario&lt;/label>
    &lt;/div>
    &lt;div class="col-12">
      &lt;div class="row justify-content-end">
        &lt;div class="col-auto">
          &lt;div class="form-check form-check-inline">
            &lt;input class="form-check-input" type="checkbox" value="" id="notificacion" checked="">
            &lt;label class="form-check-label" for="notificacion">Notificar&lt;/label>
          &lt;/div>
          &lt;div class="form-check form-check-inline">
            &lt;input class="form-check-input" type="checkbox" value="" id="importante">
            &lt;label class="form-check-label" for="importante">Importante&lt;/label>
          &lt;/div>
        &lt;/div>
      &lt;/div>
    &lt;/div>
    &lt;div class="col-12">
      &lt;button class="btn btn-primary" type="submit">Enviar&lt;/button>
    &lt;/div>
  &lt;/form>
&lt;/body></pre>
  <pre data-lang="css">html { font-size: 75%; padding: 2rem; }</pre></div>
<br/></details>

<details onclick='setTimeout(function(){__CPEmbed(".cp-later")},1)'><summary><strong>Tarjetas</strong></summary><br/>
<div class="cp-later" data-height="350" data-theme-id="light" data-default-tab="html,result" data-editable="true" style="opacity:0" data-prefill='{"stylesheets":["https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css","https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css"]}'>
  <pre data-lang="html">&lt;body>
  &lt;div class="card">
  &lt;div class="card-header">Destacado&lt;/div>
  &lt;div class="card-body row">
    &lt;div class="col">
      &lt;h5 class="card-title">Título&lt;/h5>
      &lt;p class="card-text">Descripción de la tarjeta&lt;/p>
      &lt;a href="#" class="btn btn-primary">Continuar&lt;/a>
    &lt;/div>
    &lt;figure class="col-auto px-4 text-center">
      &lt;i class="bi bi-file-earmark-image" style="font-size: 4rem; color:gray;">&lt;/i>
      &lt;figcaption>Imagen&lt;/figcaption>
    &lt;/figure>
  &lt;/div>
  &lt;div class="card-footer text-muted">Pie&lt;/div>
&lt;/div>
&lt;/body></pre>
  <pre data-lang="css">html { font-size: 75%; padding: 2rem; }</pre></div>
</details>