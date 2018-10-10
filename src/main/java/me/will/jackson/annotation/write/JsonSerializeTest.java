package me.will.jackson.annotation.write;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import me.will.jackson.JsonUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class JsonSerializeTest {
    public String name;
    @JsonSerialize(using = CustomDateSerializer.class)
    public Date eventDate;

    public static void main(String[] args) throws Exception {
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        String toParse = "20-12-2014 02:30:00";
        Date date = df.parse(toParse);
        JsonSerializeTest test = new JsonSerializeTest();
        test.setEventDate(date);
        test.setName("party");
        String result = JsonUtils.serialize(test);
        System.out.println(result);
    }
}
