# Backend

## Spring

### Cliente HTTP

Spring incluye un cliente HTTP (`RestTemplate`) que puede utilizarse para llamar a otros sistemas externos necesarios para completar la lógica de la aplicación. Por ejemplo, llamar a un API REST de un proveedor para hacer un pedido automáticamente en caso de que detectemos que nuestro stock está bajo.

```java
try {
    HttpHeaders headers = new HttpHeaders();
    headers.set("Cabecera", "Valor");
    ResponseEntity<ObjetoRespuesta> respuesta = new RestTemplate().exchange(
        "https://...url...", HttpMethod.GET/POST/PUT/etc,
        new HttpEntity<>(new ObjetoCuerpo(), headers),
        ObjetoRespuesta.class
    );
    ObjetoRespuesta cuerpoRespuesta = respuesta.getBody();
} catch (HttpStatusCodeException e) {
    logger.error("Error {} en la respuesta", e.getStatusCode());
} catch (Exception e) {
    logger.error("Error inesperado en la llamada del API", e);
}
```

> **❓ Ejercicio:** _Crea una tarea nueva en la clase `TareasProgramadas` que se ejecute una vez cada 5 minutos para imprimir en el log de la aplicación el último comic de XKCD llamando a su [API](https://xkcd.com/info.0.json), sólo si éste ha cambiado._