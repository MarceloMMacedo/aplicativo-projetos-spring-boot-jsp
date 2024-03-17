package br.com.desafio.projeto.exceptions;

import javax.persistence.EntityNotFoundException;

import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.apachecommons.CommonsLog;

@CommonsLog
@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ModelAndView entityNotFoundException(EntityNotFoundException ex, WebRequest request) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("message", ex.getMessage());
        this.printError(request, ex);
        return modelAndView;
    }

    @ExceptionHandler(UnsavedEntityException.class)
    public ModelAndView unsavedEntityException(UnsavedEntityException ex, WebRequest request) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("message", ex.getMessage());
        this.printError(request, ex);
        return modelAndView;
    }

    @ExceptionHandler(ErrorProcessingException.class)
    public ModelAndView errorProcessingException(ErrorProcessingException ex, WebRequest request) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("message", ex.getMessage());
        this.printError(request, ex);
        return modelAndView;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ModelAndView handleValidationExceptions(MethodArgumentNotValidException ex, WebRequest request) {
        StringBuilder messages = new StringBuilder();
        for (int i = 0; i < ex.getBindingResult().getAllErrors().size(); i++) {
            ObjectError error = ex.getBindingResult().getAllErrors().get(i);
            String errorMessage = error.getDefaultMessage();
            if (ex.getBindingResult().getAllErrors().size() == (i + 1)) {
                messages.append(errorMessage);
            } else {
                messages.append(errorMessage).append(", ");
            }
        }

        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("message", messages.toString());
        this.printError(request, ex, messages.toString());
        return modelAndView;
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView globalExceptionHandler(Exception ex, WebRequest request) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("message", ex.getMessage());
        this.printError(request, ex);
        return modelAndView;
    }

    /**
     * Um método que imprime detalhes do erro, incluindo informações da requisição,
     * parâmetros e mensagens.
     *
     * @param request o objeto WebRequest contendo informações da requisição
     * @param e       a Exception que ocorreu
     * @param message uma quantidade variável de mensagens String
     */
    public void printError(WebRequest request, Exception e, String... message) {
        try {
            log.error("CONTROLLER	"
                    + request.getAttribute("org.springframework.web.servlet.HandlerMapping.bestMatchingHandler", 0));
            log.error("PATH	" + request.getDescription(false));
            if (request.getParameterMap().keySet().size() > 0) {
                for (String key : request.getParameterMap().keySet()) {
                    log.error("PARAM	" + key + " = " + request.getParameterMap().get(key)[0]);
                }
            }
            for (String string : request.getAttributeNames(1)) {
                log.info(string);
            }

            if (message != null && message.length > 0 && message[0] != null) {
                log.error("MESSAGE	" + message[0]);
            } else {
                log.error("MESSAGE	" + e.getMessage());
            }
            log.error("CAUSE	" + e.getCause());
        } catch (Exception ex) {
            log.error(e.getMessage(), ex);
        }
    }
}