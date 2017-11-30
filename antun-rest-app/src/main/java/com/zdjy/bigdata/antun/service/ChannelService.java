package com.zdjy.bigdata.antun.service;

import java.util.List;

import com.zdjy.bigdata.antun.domain.Channel;

public interface ChannelService {

	Channel findByChannelCode(String channelCode);

	List<Channel> findAll();

}
