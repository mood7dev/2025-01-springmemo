package com.green.firstserver.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemoPutReq {
    private int id;
    private String title;
    private String content;
}
