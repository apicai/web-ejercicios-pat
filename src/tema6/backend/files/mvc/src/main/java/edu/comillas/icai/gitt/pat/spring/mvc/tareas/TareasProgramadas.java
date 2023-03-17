package edu.comillas.icai.gitt.pat.spring.mvc.tareas;

import edu.comillas.icai.gitt.pat.spring.mvc.rest.ModeloContador;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

@Component
public class TareasProgramadas {
    private Logger logger = LoggerFactory.getLogger(getClass());

    private Integer currentXkcd;

    @Autowired
    private RestTemplate clienteHttp;

    @Scheduled(fixedRate = 300000)
    public void ritmoFijo() {
        try {
            ResponseEntity<ModeloXkcd> respuesta = clienteHttp.exchange(
                    "https://xkcd.com/info.0.json", HttpMethod.GET,
                    HttpEntity.EMPTY,
                    ModeloXkcd.class
            );
            if (currentXkcd == null || !currentXkcd.equals(respuesta.getBody().num())) {
                logger.info("XKCD: {} - {}", respuesta.getBody().title(), respuesta.getBody().alt());
                currentXkcd = respuesta.getBody().num();
            } else {
                logger.debug("XKCD: sin actualizar");
            }
        } catch (HttpStatusCodeException e) {
            logger.error("Error {} en la respuesta del API", e.getStatusCode());
        } catch (Exception e) {
            logger.error("Error inesperado en la llamada del API", e);
        }
    }

    @Scheduled(cron = "0 * * * * *")
    public void expresionCron() {
        logger.info("Me ejecuto cuando empieza un nuevo minuto");
    }
}
