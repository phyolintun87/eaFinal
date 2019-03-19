package mum.ea.domain;

import mum.ea.domain.abstracts.BaseDomain;

public class Roles extends BaseDomain {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
