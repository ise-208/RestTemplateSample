package com.ise.RestTemplateSample;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestTemplateSampleEntity {
    String id;
    String name;
    int age;

    @Override
    public String toString() {
        return "RestTemplateSampleEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
