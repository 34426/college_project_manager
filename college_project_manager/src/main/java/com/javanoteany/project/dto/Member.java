package com.javanoteany.project.dto;

import com.alibaba.fastjson.JSON;

import java.util.List;

/**
 * @author javanoteany
 * @Date 2021-12-12
 * @Description
 * @Version 1.0
 */
public class Member {

    //成员名字
    private String memberName;

    //电话
    private String phone;

    public static String toJsons(List<Member> memberList){
        return JSON.toJSONString(memberList);
    }

    public static List<Member> toMembers(String memberJSONs){
        return JSON.parseArray(memberJSONs,Member.class);
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}


