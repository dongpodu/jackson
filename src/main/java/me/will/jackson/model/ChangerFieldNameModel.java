package me.will.jackson.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import me.will.jackson.JsonUtils;

/**
 * 要想改变属性名字，使用JsonProperty注解即可，
 * 不能使用首字母大写的方式，因为这会导致序列化后字段首字母还是小写，
 * 同时也可能导致无法反序列化
 */
public class ChangerFieldNameModel {
    @JsonProperty("strVal")
    private String stringValue;
    /**
     *json是根据getXXX方法来序列化对象的，即使这个对象存在多个字段，
     * 但由于他们的拥有相同的get方法，所以序列化后的字段只有一个
     */
    private String StringValue;

    /**
     *虽然首字母大写，但序列化后的字段名还是小写的：stringValue1，
     * 原因是因为：json是根据getStringValue1方法来序列化的，字段名是将get去掉，StringValue1，
     * 然后将首字母改成小写，变成stringValue1
     */
    private String StringValue1;

    //------------get------------
    public String getStringValue() {
        return stringValue;
    }

    public String getStringValue1() {
        return StringValue1;
    }


    //--------------set--------------
    public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }

    public void setStringValue1(String stringValue1) {
        StringValue1 = stringValue1;
    }

    public static void main(String[] args) {
        ChangerFieldNameModel model = new ChangerFieldNameModel();
        String json = JsonUtils.serialize(model);
        System.out.println(json);

        String json1 = "{\"strVal\":\"hello\",\"stringValue1\":\"你好\"}";
        ChangerFieldNameModel model1 = JsonUtils.deserialize(json1,ChangerFieldNameModel.class);
        System.out.println(model1);
    }
}
