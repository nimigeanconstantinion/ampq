package com.example.amqp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Load {
    private long id;
    private String name;

    public String toString(){
        return "{id="+this.id+",name="+this.name+"}";
    }
}
