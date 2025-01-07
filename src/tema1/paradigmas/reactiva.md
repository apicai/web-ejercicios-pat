# Paradigmas de programación

## Declarativa

### Reactiva

Los resultados se obtienen transformando un "stream" de eventos (datos) y propagando (reaccionando a) los cambios automáticamente.

<details open><summary>Máximo valor en lista de enteros...</summary>

```js
import { fromEvent } from "https://cdn.skypack.dev/rxjs@7.3.0";
import { scan, map } from "https://cdn.skypack.dev/rxjs@7.3.0/operators";

const output = document.querySelector("output");
const button = document.querySelector("button");

fromEvent(button, "click")
  .pipe(map(ev => ev.clientX), scan((total, n) => total < n ? n : total))
  .subscribe((max) => {
    output.textContent = "Max X = " + max;
  });
```
> 🔍 **Nota:** _[documentación](https://rxjs.dev/guide/overview) de `rxjs`._
</details>

<details onclick='setTimeout(function(){__CPEmbed(".cp-later")},1)'><summary>Prueba aquí...</summary><br>
<div class="cp-later" data-prefill="{}" data-height="400" data-theme-id="light" data-default-tab="js,result" data-editable="true" style="opacity:0">
<pre data-lang="html" >
&lt;button&gt;Click me in different places&lt;/button&gt;
&lt;output&gt;&lt;/output&gt;
</pre>
<pre data-lang="js">
import { fromEvent } from "https://cdn.skypack.dev/rxjs@7.3.0";
import { scan, map } from "https://cdn.skypack.dev/rxjs@7.3.0/operators";
const output = document.querySelector("output");
const button = document.querySelector("button");
fromEvent(button, "click")
  .pipe(map(ev =&gt; ev.clientX), scan((total, n) =&gt; total &lt; n ? n : total))
  .subscribe((max) =&gt; { output.textContent = "Max X = " + max; });
</pre>
</div>
</details>
