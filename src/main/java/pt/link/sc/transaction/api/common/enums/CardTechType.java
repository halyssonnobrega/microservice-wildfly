package pt.link.sc.transaction.api.common.enums;

import pt.link.sc.transaction.api.common.util.PersistentEnum;

public enum CardTechType implements PersistentEnum<Integer> {
    UNKNOWN(-1, "unknown"),
    DESFIRE(8, "desfire");

    private Integer id;
    private String name;

    CardTechType(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getLabelResourceId() {
        return "cardTechType.label." + name;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

}