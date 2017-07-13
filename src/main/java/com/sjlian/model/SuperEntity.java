package com.sjlian.model;

import java.io.Serializable;

/**
 * Created by lian on 17/7/12.
 */
public abstract class SuperEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
