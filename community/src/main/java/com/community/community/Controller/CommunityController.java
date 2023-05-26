package com.community.community.Controller;

import com.community.community.Dao.ChannelDao;
import com.community.community.Dao.MessageDao;
import com.community.community.Dao.UsersDao;
import com.community.community.Dtos.ChannelDto;
import com.community.community.Dtos.LoginDto;
import com.community.community.Dtos.MessagesDto;
import com.community.community.Dtos.UserDto;
import com.community.community.Models.Channels;
import com.community.community.Models.Messages;
import com.community.community.Models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommunityController {

    private UsersDao usersDao;

    private MessageDao messageDao;

    private ChannelDao channelDao;

    @Autowired
    public void setUsersDao(UsersDao usersDao) {
        this.usersDao = usersDao;
    }

    @Autowired
    public void setMessageDao(MessageDao messageDao) {
        this.messageDao = messageDao;
    }

    @Autowired
    public void setChannelDao(ChannelDao channelDao) {
        this.channelDao = channelDao;
    }

    @PostMapping("community/user/create")
    public ResponseEntity<Users> createUser(@RequestBody UserDto userDto){
        return new ResponseEntity<>(this.usersDao.createUser(userDto), HttpStatus.CREATED);
    }

    @PostMapping("community/user/login")
    public ResponseEntity<Users> loginUser(@RequestBody LoginDto loginDto){
        return new ResponseEntity<>(this.usersDao.loginUser(loginDto), HttpStatus.OK);
    }

    @PostMapping("community/channel/create")
    public ResponseEntity<Channels> createChannel(ChannelDto channelDto){
        return new ResponseEntity<>(this.channelDao.createChannel(channelDto),HttpStatus.CREATED);
    }

    @PostMapping("community/channel/addmember")
    public ResponseEntity<Channels> addMember(Long userId,Long channelId){
        return new ResponseEntity<>(this.channelDao.addMember(userId,channelId),HttpStatus.OK);
    }

    @PostMapping("community/messages/addmessage")
    public ResponseEntity<Messages> sendMessage(Long channelId, MessagesDto messagesDto){
        return new ResponseEntity<>(this.messageDao.sendMessage(channelId, messagesDto),HttpStatus.OK );
    }
    @PostMapping("community/messages/getmessages")
    public ResponseEntity<List<Messages>> checkChannelMessages(Long channelId){
        return new ResponseEntity<>(this.messageDao.checkChannelMessages(channelId), HttpStatus.OK);
    }

}
