package br.com.projeto.aplicacao.exceptions;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException() {
        super("El registro solicitado no existe");
    }

    public EntityNotFoundException(String mensagem) {
        super(mensagem);
    }

}