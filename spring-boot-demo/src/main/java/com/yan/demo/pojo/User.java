package com.yan.demo.pojo;

import com.yan.demo.annotation.ValidCardNumber;

import javax.validation.constraints.NotNull;

/**
 * Created by yan on  25/09/2018.
 */
public class User {


    private int id;
    @NotNull(message="名字不能为空")
    private String name;

    @ValidCardNumber
    private String phone;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
