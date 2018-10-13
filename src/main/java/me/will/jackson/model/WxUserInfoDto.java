package me.will.jackson.model;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by will
 */
@Data
public class WxUserInfoDto implements Serializable{
    private String openId;
    private String nickName;
    private String gender;
    private String language;
    private String city;
    private String province;
    private String country;
    private String avatarUrl;
    private String unionId;
}
