package me.will.jackson.model;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by will
 */
@Data
public class UserInfoDto implements Serializable{
    private WxUserInfoDto wxUserInfoDto;
    private Long clientSn;
    private String mobile;
}
