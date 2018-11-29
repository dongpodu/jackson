package me.will.jackson.annotation.write;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.PropertyFilter;
import com.fasterxml.jackson.databind.ser.PropertyWriter;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import lombok.Data;

@JsonFilter("myFilter")
@Data
public class JsonFilterTest {
    private String name;
    private Integer age;

    public static void main(String[] args) throws JsonProcessingException {
        PropertyFilter theFilter = new SimpleBeanPropertyFilter() {
            @Override
            public void serializeAsField
                    (Object pojo, JsonGenerator jgen, SerializerProvider provider, PropertyWriter writer)
                    throws Exception {
                if (include(writer)) {
                    if (!writer.getName().equals("age")) {
                        writer.serializeAsField(pojo, jgen, provider);
                        return;
                    }
                    int intValue = ((JsonFilterTest) pojo).getAge();
                    if (intValue >= 0) {
                        writer.serializeAsField(pojo, jgen, provider);
                    }
                } else if (!jgen.canOmitFields()) { // since 2.3
                    writer.serializeAsOmittedField(pojo, jgen, provider);
                }
            }
            @Override
            protected boolean include(BeanPropertyWriter writer) {
                return true;
            }
            @Override
            protected boolean include(PropertyWriter writer) {
                return true;
            }
        };


        FilterProvider filters = new SimpleFilterProvider().addFilter("myFilter", theFilter);
        JsonFilterTest test = new JsonFilterTest();
        test.setName("will");
        test.setAge(-1);//不序列化

        ObjectMapper mapper = new ObjectMapper();
        String dtoAsString = mapper.writer(filters).writeValueAsString(test);
        System.out.println(dtoAsString);
    }
}
