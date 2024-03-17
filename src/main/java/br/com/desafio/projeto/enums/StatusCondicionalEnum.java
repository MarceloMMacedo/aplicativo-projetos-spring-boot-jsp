package br.com.desafio.projeto.enums;

public enum StatusCondicionalEnum {
    SIM("Sim", true),
    NAO("Não", false);

    private final String name;
    private final boolean value;

    private StatusCondicionalEnum(String name, boolean value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public boolean getValue() {
        return value;
    }

    public static boolean returnId(String name) {
        for (StatusCondicionalEnum e : StatusCondicionalEnum.values()) {
            if (e.getName().equals(name)) {
                return e.getValue();
            }
        }
        return false;
    }

    public static String returnName(boolean value) {
        for (StatusCondicionalEnum e : StatusCondicionalEnum.values()) {
            if (e.getValue() == value) {
                return e.getName();
            }
        }
        return null;
    }
}
