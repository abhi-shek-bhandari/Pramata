package com.community.community.Dtos;

import com.community.community.Models.Users;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class MessagesDto {
    private Long senderId;
    private String content;

}
