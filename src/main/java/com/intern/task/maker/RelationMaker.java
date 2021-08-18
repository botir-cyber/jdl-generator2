package com.intern.task.maker;

import java.util.ArrayList;
import java.util.List;

import com.intern.task.model.jdl.RelationType;
import com.intern.task.model.jdl.Relationship;
import com.intern.task.model.sql.ForeignKey;
import com.intern.task.util.CodeUtil;

public class RelationMaker extends Maker<List<Relationship>>{

    private RelationType type;
    
    public RelationMaker() {
        object = new ArrayList<>();
    }

    @Override
    protected void headSolver(String head) {
        String name = head.substring(12).trim();       // example, head = "relationship OneToMany";
        switch (name.toLowerCase()) {
            case "onetoone":
                type = RelationType.ONE_TO_ONE;
                break;
            case "onetomany":
                type = RelationType.ONE_TO_MANY;
                break;
            case "manytoone":
                type = RelationType.MANY_TO_ONE;
                break;
            case "manytomany":
                type = RelationType.MANY_TO_MANY;
                break;            
            default:
                break;
        }
    }

    @Override
    protected void bodySolver(String body) {
        for(String line: body.split("\n")){
            Relationship rel = new Relationship();
            ForeignKey fromFK = new ForeignKey();
            ForeignKey toFK = new ForeignKey();
            rel.setType(type);

            line = line.trim();
            if(line.equals(""))
                continue;
            line = line.replace(",", "");

            String[] items = CodeUtil.remove2Probels(line).split(" to ");
            if(items.length>1){
                
                object.add(rel);
            }
        }
    }
}
