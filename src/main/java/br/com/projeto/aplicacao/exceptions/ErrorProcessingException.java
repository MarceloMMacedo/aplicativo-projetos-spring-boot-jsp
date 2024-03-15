package br.com.projeto.aplicacao.exceptions;

public class ErrorProcessingException extends RuntimeException {

    public ErrorProcessingException() {
        super("Houve um erro insperado ao processar a requisição");
    }

    public ErrorProcessingException(String mensagem) {
        super(mensagem);
    }

    public ErrorProcessingException(String mensagem, Throwable root) {
        super(mensagem, root);
    }
}