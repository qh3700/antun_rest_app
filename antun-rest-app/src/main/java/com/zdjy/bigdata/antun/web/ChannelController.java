package com.zdjy.bigdata.antun.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zdjy.bigdata.antun.domain.Channel;
import com.zdjy.bigdata.antun.service.ChannelService;
import com.zdjy.bigdata.antun.web.response.BaseResponse;

@RestController
@RequestMapping("/channels")
public class ChannelController extends BaseResponse{

	@Autowired
	private ChannelService channelService;
	@RequestMapping(value="",method=RequestMethod.GET)
	public BaseResponse findAll(){
		List<Channel> channels=channelService.findAll();
		return successResponse("查询成功").data(channels);
	}	
}
