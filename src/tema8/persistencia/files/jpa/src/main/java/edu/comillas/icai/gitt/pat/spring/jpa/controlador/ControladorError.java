package edu.comillas.icai.gitt.pat.spring.jpa.controlador;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Component
public class ControladorError extends BasicErrorController {

    public ControladorError(ErrorAttributes errorAttributes, ServerProperties serverProperties) {
            super(errorAttributes, serverProperties.getError());
    }

    @RequestMapping(produces = {"text/html"}) @Override
    public ModelAndView errorHtml(HttpServletRequest request, HttpServletResponse response) {
        return new ModelAndView("error.html", Map.of("error", getStatus(request).value()));
    }
}

