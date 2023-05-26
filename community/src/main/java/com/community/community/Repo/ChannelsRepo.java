package com.community.community.Repo;

import com.community.community.Models.Channels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChannelsRepo extends JpaRepository<Channels,Long> {
}
