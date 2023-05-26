package com.community.community.DaoImpl;

import com.community.community.Dao.MessageDao;
import com.community.community.Dtos.MessagesDto;
import com.community.community.Exceptions.ChannelException;
import com.community.community.Exceptions.UserException;
import com.community.community.Models.Channels;
import com.community.community.Models.Messages;
import com.community.community.Repo.ChannelsRepo;
import com.community.community.Repo.MessagesRepo;
import com.community.community.Repo.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageDaoImpl implements MessageDao {

    private UsersRepo usersRepo;

    private ChannelsRepo channelsRepo;

    private MessagesRepo messagesRepo;

    @Autowired
    public void setUsersRepo(UsersRepo usersRepo) {
        this.usersRepo = usersRepo;
    }

    @Autowired
    public void setMessagesRepo(MessagesRepo messagesRepo) {
        this.messagesRepo = messagesRepo;
    }

    @Autowired
    public void setChannelsRepo(ChannelsRepo channelsRepo) {
        this.channelsRepo = channelsRepo;
    }

    @Override
    public Messages sendMessage(Long channelId, MessagesDto messagesDto) {
        Messages messages = this.dtoToMessages(messagesDto);

        Channels channels = this.channelsRepo.findById(channelId).orElseThrow(()-> new ChannelException("Invalid Channel Id "+ channelId));

        messages = this.messagesRepo.save(messages);

        messages.setChannels(channels);
        channels.getMessages().add(messages);

        this.channelsRepo.save(channels);

        return messages;
    }

    @Override
    public List<Messages> checkChannelMessages(Long channelId) {

        Channels channels = this.channelsRepo.findById(channelId).orElseThrow(()-> new ChannelException("Invalid Channel Id "+ channelId));

        return channels.getMessages();
    }

    Messages dtoToMessages(MessagesDto messagesDto){
        Messages messages = new Messages();
        messages.setContent(messagesDto.getContent());
        messages.setSender(this.usersRepo.findById(messagesDto.getSenderId()).orElseThrow(()-> new UserException("Invalid User Id "+ messagesDto.getSenderId())));
        return  messages;
    }
}
