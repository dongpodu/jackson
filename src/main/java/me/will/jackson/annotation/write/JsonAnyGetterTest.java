package me.will.jackson.annotation.write;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.Data;
import me.will.jackson.JsonUtils;

import java.util.HashMap;
import java.util.Map;

@Data
public class JsonAnyGetterTest {
    public String name;
    private Map<String, String> properties;

    @JsonAnyGetter
    public Map<String, String> getProperties() {
        return properties;
    }


    public static void main(String[] args) {
        JsonAnyGetterTest test = new JsonAnyGetterTest();
        test.setName("will");
        Map<String, String> properties=new HashMap<>();
        properties.put("id","20");
        properties.put("age","10");
        String result = JsonUtils.serialize(test);
        System.out.println(result);
    }
}
