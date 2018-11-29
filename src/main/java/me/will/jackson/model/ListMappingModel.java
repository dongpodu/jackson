package me.will.jackson.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public class ListMappingModel extends UpperModel {
    @JsonProperty("Data")
    @JsonDeserialize(as= ArrayList.class, contentAs= Model.class)
    private List<Model> items;

    @Data
    public static class Model{
        @JsonProperty("OpenId")
        private String openId;
        @JsonProperty("UnionId")
        private String unionId;
        @JsonProperty("ClientSn")
        private Integer clientSn;
        @JsonProperty("LeadSn")
        private Integer leadSn;
        @JsonProperty("ClientName")
        private String clientName;
        @JsonProperty("BrandId")
        private Integer brandId;
        @JsonProperty("VipJr")
        private Integer vipJr;
    }

}
