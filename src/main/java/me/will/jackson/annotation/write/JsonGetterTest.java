package me.will.jackson.annotation.write;

import com.fasterxml.jackson.annotation.JsonGetter;
import lombok.Data;
import me.will.jackson.JsonUtils;

/**
 * 将方法返回也映射
 */
@Data
public class JsonGetterTest {
    public int id;
    public String name;

    @JsonGetter("age")
    public int getAg(){
        return 20;
    }

    public static void main(String[] args) {
        JsonGetterTest test = new JsonGetterTest();
        test.setId(1);
        test.setName("will");
        String result = JsonUtils.serialize(test);
        System.out.println(result);
    }
}
