package me.will.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import me.will.jackson.model.UserInfoDto;
import me.will.jackson.model.WxUserInfoDto;

import java.io.IOException;

public class JsonUtils {

    public static String serialize(Object obj){
        ObjectMapper mapper = new ObjectMapper();
        String result = null;
        try {
            result = mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        WxUserInfoDto wxUserInfoDto = new WxUserInfoDto();
        wxUserInfoDto.setNickName("will");
        UserInfoDto userInfoDto = new UserInfoDto();
        userInfoDto.setClientSn(111L);
        userInfoDto.setWxUserInfoDto(wxUserInfoDto);
        String result = serialize(userInfoDto);
        System.out.println(result);

        ObjectMapper mapper = new ObjectMapper();
        UserInfoDto userInfoDto1 = mapper.readValue(result,UserInfoDto.class);
        System.out.println(userInfoDto1);
    }
}
