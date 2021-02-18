package org.msdemt.simple.service.impl;

import io.netty.channel.Channel;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import org.msdemt.simple.config.NettyChannelCache;
import org.msdemt.simple.service.PushService;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;

@Service("pushService")
public class PushServiceImpl implements PushService {

    /**
     * 推送给指定用户
     * @param userId 用户ID
     * @param msg 消息信息
     */
    @Override
    public void pushMsgToOne(String userId, String msg){
        ConcurrentHashMap<String, Channel> userChannelMap = NettyChannelCache.getUserChannelMap();
        Channel channel = userChannelMap.get(userId);
        channel.writeAndFlush(new TextWebSocketFrame(msg));
    }

    /**
     * 推送给所有用户
     * @param msg 消息信息
     */
    @Override
    public void pushMsgToAll(String msg){
        NettyChannelCache.getChannelGroup().writeAndFlush(new TextWebSocketFrame(msg));
    }

    /**
     * 获取当前连接数
     * @return 连接数
     */
    @Override
    public int getConnectCount() {
        return NettyChannelCache.getChannelGroup().size();
    }
}
