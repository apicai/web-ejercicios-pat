# Tests

## Herramientas

### Para unitarios

Los tests unitarios, además de avisar rápidamente de que los cambios están rompiendo el comportamiento requerido, también representan una forma de documentar los requisitos. El siguiente ejemplo utiliza [Jasmine](https://jasmine.github.io/index.html) para especificar, implementar y ejecutar los tests unitarios de una función JavaScript.

<div class="codepen" data-height="600" data-theme-id="light" data-default-tab="result" data-editable="true" style="opacity:0" data-prefill='{"title":"Jasmine Test Runner","scripts":["https://cdnjs.cloudflare.com/ajax/libs/jasmine/4.6.0/jasmine.min.js","https://cdnjs.cloudflare.com/ajax/libs/jasmine/4.6.0/jasmine-html.min.js","https://cdnjs.cloudflare.com/ajax/libs/jasmine/4.6.0/boot0.min.js","https://cdnjs.cloudflare.com/ajax/libs/jasmine/4.6.0/boot1.min.js"],"stylesheets":["https://cdnjs.cloudflare.com/ajax/libs/jasmine/4.6.0/jasmine.min.css"]}'>
  <pre data-lang="js">// TESTS
describe('La función "fizzBuzz" debe retornar', () => {
  it('el número pasado si no es múltiplo de 3, 5 o de ambos', () => {
    expect(fizzBuzz(1)).toEqual(1);
  });
  it('"Fizz" si el número pasado es múltiplo de 3', () => {
    expect(fizzBuzz(3)).toEqual('Fizz');
  });
  it('"Buzz" si el número pasado es múltiplo de 5', () => {
    expect(fizzBuzz(5)).toEqual('Buzz');
  });
  it('"FizzBuzz" si el número pasado es múltiplo de 3 y 5', () => {
    expect(fizzBuzz(15)).toEqual('FizzBuzz');
  });
});
// LÓGICA
const fizzBuzz = function fizzBuzz(numero) {
  return;
}</pre></div>
<script async src="https://cpwebassets.codepen.io/assets/embed/ei.js"></script>

> ⁉️ **Ejercicio:** _Completa la función del ejemplo para que cumpla los requisitos. ¿Qué metodología de desarrollo+pruebas se ha utilizado?_