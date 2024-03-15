package br.com.projeto.aplicacao.exceptions;

public class UnsavedEntityException extends RuntimeException {

    public UnsavedEntityException() {
        super("houve un erro inesperado ao tentar salvar o registro. Tente novamente mais tarde");
    }

    public UnsavedEntityException(String mensagem) {
        super(mensagem);
    }

    public UnsavedEntityException(String message, Throwable cause) {
        super(message, cause);
    }
}