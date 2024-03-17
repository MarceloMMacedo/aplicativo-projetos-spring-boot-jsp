package br.com.desafio.projeto.enums;

public enum RiscoEnum {
    BAIXORISCO("Baixo Risco", "BAIXO_RISCO"),
    MEDIORISCO("Médio Risco", "MEDIO_RISCO"),
    ALTORISCO("Alto Risco", "ALTO_RISCO");

    private final String name;
    private final String id;

    private RiscoEnum(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public static String returnName(String id) {
        for (RiscoEnum e : RiscoEnum.values()) {
            if (e.getId().equals(id)) {
                return e.getName();
            }
        }
        return null;
    }

    public static String returnId(String name) {
        for (RiscoEnum e : RiscoEnum.values()) {
            if (e.getName().equals(name)) {
                return e.getId();
            }
        }
        return null;
    }

}
