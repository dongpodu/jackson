package me.will.jackson.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * json字段首字母是大写的
 */
@Data
public class UpperModel {

    @JsonProperty("Code")
    private String code;

    @JsonProperty("Msg")
    private String msg;

    @JsonProperty("ErrMsg")
    private String errMsg;

    @JsonProperty("IsSuccess")
    private Boolean isSuccess;

    @JsonProperty("SubCode")
    private String subCode;

    @JsonProperty("SubMsg")
    private String subMsg;
}
