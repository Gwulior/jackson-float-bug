package ua.gwulior.test.jackson.bug;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.util.HashMap;

public class FieldConverter extends JsonDeserializer<Object> {

    public Object deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        HashMap hashMap = jsonParser.readValueAs(HashMap.class);
        return hashMap;
    }

}
