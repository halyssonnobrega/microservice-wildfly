package pt.link.sc.transaction.api.common.enums;

import pt.link.sc.transaction.api.common.util.PersistentEnum;

public enum PhysicalCardStatus implements PersistentEnum<Integer> {
    UNKNOWN(-1, "unknown"),
    CLEAR(0, "clear"),
    ACTIVE(1, "active"),
    INVALIDATED(2, "invalidated");

    private Integer id;
    private String name;

    PhysicalCardStatus(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getLabelResourceId() {
        return "enum.label." + name;
    }
}
