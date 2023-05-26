package com.community.community.DaoImpl;

import com.community.community.Dao.ChannelDao;
import com.community.community.Exceptions.ChannelException;
import com.community.community.Exceptions.UserException;
import com.community.community.Dtos.ChannelDto;
import com.community.community.Models.Channels;
import com.community.community.Models.Users;
import com.community.community.Repo.ChannelsRepo;
import com.community.community.Repo.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChannelDaoImpl implements ChannelDao {

    private UsersRepo usersRepo;

    private ChannelsRepo channelsRepo;

    @Autowired
    public void setChannelsRepo(ChannelsRepo channelsRepo) {
        this.channelsRepo = channelsRepo;
    }

    @Autowired
    public void setUsersRepo(UsersRepo usersRepo) {
        this.usersRepo = usersRepo;
    }

    @Override
    public Channels createChannel(ChannelDto channelDto) {
        return this.channelsRepo.save(this.dtoToChannels(channelDto));
    }

    @Override
    public Channels addMember(Long userId, Long channelId) {

        Channels channels = this.channelsRepo.findById(channelId).orElseThrow(()-> new ChannelException("Invalid Channel Id "+ channelId));

        Users users = this.usersRepo.findById(userId).orElseThrow(()-> new UserException("Invalid User Id "+ userId));

        if (channels.getMembers().contains(users)) throw new ChannelException("User Already in Channel");
        else channels.getMembers().add(users);

        return this.channelsRepo.save(channels);
    }

    Channels dtoToChannels(ChannelDto channelDto){
        Channels channels = new Channels();
        channels.setName(channelDto.getName());
        channels.setAdmin(this.usersRepo.findById(channelDto.getAdminId()).orElseThrow(() -> new UserException("Invalid UserId")));
        return channels;
    }
}
