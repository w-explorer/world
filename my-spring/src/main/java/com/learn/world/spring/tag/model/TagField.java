package com.learn.world.spring.tag.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TagField{
    
    private String tableCode;

    private String fieldCode;
    
}