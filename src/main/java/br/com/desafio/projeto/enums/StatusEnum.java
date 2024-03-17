package br.com.desafio.projeto.enums;

public enum StatusEnum {
    EMANALISE("Em Analise", "EM_ANALISE"),
    ANALISEREALIZADA("Analise Realizada", "ANALISE_REALIZADA"),
    ANALISEAPROVADA("Analise Aprovada", "ANALISE_APROVADA"),
    INICIADO("Iniciado", "INICIADO"),
    PLANEJADO("Planejado", "PLANEJADO"),
    EMANDAMENTO("Em Andamento", "EM_ANDAMENTO"),
    ENCERRADO("Encerrado", "ENCERRADO"),
    CANCELADO("Cancelado", "CANCELADO");

    private final String name;
    private final String id;

    private StatusEnum(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public static String returnId(String name) {
        for (StatusEnum e : StatusEnum.values()) {
            if (e.getName().equals(name)) {
                return e.getId();
            }
        }
        return null;
    }

    public static String returnName(String id) {
        for (StatusEnum e : StatusEnum.values()) {
            if (e.getId().equals(id)) {
                return e.getName();
            }
        }
        return null;
    }

}
