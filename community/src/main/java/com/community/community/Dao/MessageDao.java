package com.community.community.Dao;

import com.community.community.Dtos.MessagesDto;
import com.community.community.Models.Messages;

import java.util.List;

public interface MessageDao {
    Messages sendMessage(Long channelId, MessagesDto messagesDto);
    List<Messages> checkChannelMessages(Long channelId);

}
