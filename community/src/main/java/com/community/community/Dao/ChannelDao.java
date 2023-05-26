package com.community.community.Dao;

import com.community.community.Dtos.ChannelDto;
import com.community.community.Models.Channels;


public interface ChannelDao {
    Channels createChannel(ChannelDto channelDto);
    Channels addMember(Long userId,Long channelId);
}
