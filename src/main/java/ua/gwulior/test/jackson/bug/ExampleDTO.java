package ua.gwulior.test.jackson.bug;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class ExampleDTO {

    @JsonDeserialize(using = FieldConverter.class)
    private Object objectWithMutableStructure;

    public Object getObjectWithMutableStructure() {
        return objectWithMutableStructure;
    }

    public void setObjectWithMutableStructure(Object objectWithMutableStructure) {
        this.objectWithMutableStructure = objectWithMutableStructure;
    }
}
