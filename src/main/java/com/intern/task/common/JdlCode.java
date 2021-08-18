package com.intern.task.common;

import java.util.ArrayList;
import java.util.List;

import com.intern.task.maker.EntityMaker;
import com.intern.task.maker.EnumMaker;
import com.intern.task.maker.RelationMaker;
import com.intern.task.model.jdl.Entity;
import com.intern.task.model.jdl.Enum;
import com.intern.task.model.jdl.Relationship;
import com.intern.task.model.sql.ForeignKey;
import com.intern.task.util.CodeUtil;

public class JdlCode {
    private String code;
    private List<Entity> entities = new ArrayList<>();
    private List<Enum> enums = new ArrayList<>();
    private List<ForeignKey> foreignKeys = new ArrayList<>();
    private List<String> others = new ArrayList<>();
    
    public JdlCode(String code){
        this.code = CodeUtil.removeComments(code);
    }

    public String getCode() {
        return code;
    }

    /**
     * Defines all entites, enums, relationships and others.
     */
    public void define(){
        int cursor = 0;
        while(cursor<code.length()){
            int openIndex = code.indexOf("{", cursor);
            if(openIndex<0)
                return;
            int closeIndex = CodeUtil.findCloseBkt(code, openIndex);
            if(closeIndex<0)
                return;
            String head = code.substring(cursor, openIndex).trim();
            String body = code.substring(openIndex + 1, closeIndex).trim();
            
            if(head.indexOf("entity")>-1){
                entities.add(new EntityMaker().make(head, body));
            } else if(head.indexOf("enum")>-1){
                enums.add(new EnumMaker().make(head, body));
            } else if(head.indexOf("relationship")>-1){
                for(Relationship rel: new RelationMaker().make(head, body)){
                    relate(rel);
                }
            }
            cursor = closeIndex + 1;
        }
    }

    private void relate(Relationship rel){

    }

    public List<Entity> getEntities() {
        return this.entities;
    }

    public void setEntities(List<Entity> entities) {
        this.entities = entities;
    }

    public List<Enum> getEnums() {
        return this.enums;
    }

    public void setEnums(List<Enum> enums) {
        this.enums = enums;
    }

    public List<String> getOthers() {
        return this.others;
    }

    public void setOthers(List<String> others) {
        this.others = others;
    }

}
