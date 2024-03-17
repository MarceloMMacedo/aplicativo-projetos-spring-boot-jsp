package br.com.desafio.projeto.enums;

public enum RiscoEnum {
    BAIXORISCO("Baixo Risco", 1),
    MEDIORISCO("Médio Risco", 2),
    ALTORISCO("Alto Risco", 3);

    private final String name;
    private final int id;

    private RiscoEnum(String name, int id) {
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
        for (RiscoEnum e : RiscoEnum.values()) {
            if (e.getId() == id) {
                return e.getName();
            }
        }
        return null;
    }

    public static int returnId(String name) {
        for (RiscoEnum e : RiscoEnum.values()) {
            if (e.getName().equals(name)) {
                return e.getId();
            }
        }
        return 0;
    }

    public static RiscoEnum returnEnum(int id) {
        for (RiscoEnum e : RiscoEnum.values()) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }
}
