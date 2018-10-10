package me.will.jackson.annotation.write;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import me.will.jackson.JsonUtils;

@Data
@JsonPropertyOrder({ "name", "id" })
public class JsonPropertyOrderTest {
    public int id;
    public String name;

    public static void main(String[] args) {
        JsonPropertyOrderTest test = new JsonPropertyOrderTest();
        test.setId(1);
        test.setName("will");
        String result = JsonUtils.serialize(test);
        System.out.println(result);
    }
}
