package com.skillip.elasticsearch;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.Before;

import java.net.InetAddress;

public class ESDemo {
    private TransportClient client;

    @SuppressWarnings("unchecked")
    @Before
    public void getClient() throws Exception {

        // 1 设置连接的集群名称
        Settings settings = Settings.builder().put("cluster.name", "my-application").build();

        // 2 连接集群
        client = new PreBuiltTransportClient(settings);
        client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("hadoop102"), 9300));

        // 3 打印集群名称
        System.out.println(client.toString());
    }

}
