package me.will.jackson.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import me.will.jackson.JsonUtils;

@Data
public class ChangerFieldNameModel {
    @JsonProperty("strVal")
    private String stringValue;

    public static void main(String[] args) {
        ChangerFieldNameModel model = new ChangerFieldNameModel();
        String json = JsonUtils.serialize(model);
        System.out.println(json);

        String json1 = "{\"strVal\":\"hello\"}";
        ChangerFieldNameModel model1 = JsonUtils.deserialize(json1,ChangerFieldNameModel.class);
        System.out.println(model1);
    }
}
