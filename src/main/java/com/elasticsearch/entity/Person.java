package com.elasticsearch.entity;

import lombok.Data;

/**
 * Created with IDEA
 * author:wang
 * Date:2018/7/31 0031 下午 3:15
 * Description:
 */
@Data
class Person {

    private String id;
    private String name;
    private Integer age;

    public static void main(String[] args) {
        Person person = new Person();
        person.setId("001");
        person.setAge(18);
        person.setName("tom");
        System.out.println(person.toString());
    }
}
