package com.community.community.Dtos;

import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChannelDto {

    private String name;
    private Long adminId;
}
