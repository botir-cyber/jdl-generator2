package com.intern.task.model.jdl;

import com.intern.task.model.sql.ForeignKey;

public class Relationship {
    private RelationType type;
    private ForeignKey fromFK;
    private ForeignKey toFK;

    public RelationType getType() {
        return this.type;
    }

    public void setType(RelationType type) {
        this.type = type;
    }

    public ForeignKey getFromFK() {
        return this.fromFK;
    }

    public void setFromFK(ForeignKey fromFK) {
        this.fromFK = fromFK;
    }

    public ForeignKey getToFK() {
        return this.toFK;
    }

    public void setToFK(ForeignKey toFK) {
        this.toFK = toFK;
    }

}
