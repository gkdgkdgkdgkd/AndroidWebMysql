package com.example.javawebdemo.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResponseBody {
    private Object data;
    private int code;
}