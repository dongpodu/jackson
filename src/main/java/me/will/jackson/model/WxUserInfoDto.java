package me.will.jackson.model;

import me.will.jackson.JsonUtils;

import java.io.Serializable;

/**
 * Created by will
 */
public class WxUserInfoDto implements Serializable{
    private String openId;
    private String NickName;
    private String gender;
    private String language;
    private String city;
    private String province;
    private String country;
    private String avatarUrl;
    private String unionId;

    public static void main(String[] args) {
        WxUserInfoDto userInfoDto = new WxUserInfoDto();
        String json = JsonUtils.serialize(userInfoDto);
        System.out.println(json);
    }
}
