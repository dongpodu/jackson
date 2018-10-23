package me.will.jackson;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class LocalDateTimeTest {
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime date;


    public static void main(String[] args) throws JsonProcessingException {
        LocalDateTimeTest test = new LocalDateTimeTest();
        test.setDate(LocalDateTime.now());

        ObjectMapper mapper = new ObjectMapper();
        JavaTimeModule timeModule = new JavaTimeModule();
        mapper.registerModule(timeModule);

        String result = mapper.writeValueAsString(test);
        System.out.println(JsonUtils.serialize(result));

    }
}
