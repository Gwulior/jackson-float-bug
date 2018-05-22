package ua.gwulior.test.jackson.bug;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;

public class BugTest {

    private static final String testJSON = "{\n" +
            "  \"objectWithMutableStructure\" : {\n" +
            "    \"numberOne\" : 3.9999999999999998997878978,\n" +
            "    \"numberTwo\" : 24565.99999999999999999\n" +
            "  }\n" +
            "}";

    //    Ignores deserialization feature
    @Test
    public void testFail() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ExampleDTO dto = objectMapper.readerFor(ExampleDTO.class)
                .with(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS)
                .readValue(testJSON);
        assert ((HashMap) dto.getObjectWithMutableStructure()).get("numberOne") instanceof BigDecimal;
    }

    //    Feature is set globally, works fine
    @Test
    public void testSuccess() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper() {{
            configure(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS, true);
        }};
        ExampleDTO dto = objectMapper.readerFor(ExampleDTO.class)
                .readValue(testJSON);
        assert ((HashMap) dto.getObjectWithMutableStructure()).get("numberOne") instanceof BigDecimal;
    }

}
