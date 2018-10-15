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

    public static void test() throws IOException {
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

    public static void test1(){
        String st = "{\"id\":1,\"code\":\"tutorabc\",\"name\":\"成人英语\",\"logoUrl\":\"http://source.vipabc.com/ext/images/wechat/tutorabc/Gift Card/abc/成人英语630x375.png\",\"isDel\":0,\"creatorId\":0,\"createdAt\":{\"month\":\"NOVEMBER\",\"year\":2017,\"dayOfMonth\":1,\"dayOfWeek\":\"WEDNESDAY\",\"dayOfYear\":305,\"monthValue\":11,\"hour\":21,\"minute\":42,\"nano\":0,\"second\":50,\"chronology\":{\"id\":\"ISO\",\"calendarType\":\"iso8601\"}},\"modifierId\":0,\"modifiedAt\":{\"month\":\"FEBRUARY\",\"year\":2018,\"dayOfMonth\":13,\"dayOfWeek\":\"TUESDAY\",\"dayOfYear\":44,\"monthValue\":2,\"hour\":12,\"minute\":39,\"nano\":0,\"second\":40,\"chronology\":{\"id\":\"ISO\",\"calendarType\":\"iso8601\"}}}";
        ObjectMapper mapper = new ObjectMapper();
    }

  public static void main(String[] args) throws IOException {

    }
}
