package br.com.desafio.projeto.enums;

public enum StatusEnum {
    EMANALISE("Em Analise", 1),
    ANALISEREALIZADA("Analise Realizada", 2),
    ANALISEAPROVADA("Analise Aprovada", 3),
    INICIADO("Iniciado", 4),
    PLANEJADO("Planejado", 5),
    EMANDAMENTO("Em Andamento", 6),
    ENCERRADO("Encerrado", 7),
    CANCELADO("Cancelado", 8);

    private final String name;
    private final int id;

    private StatusEnum(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public static String returnName(int id) {
        for (StatusEnum e : StatusEnum.values()) {
            if (e.getId() == id) {
                return e.getName();
            }
        }
        return null;
    }

    public static int returnId(String name) {
        for (StatusEnum e : StatusEnum.values()) {
            if (e.getName().equals(name)) {
                return e.getId();
            }
        }
        return 0;
    }

}
