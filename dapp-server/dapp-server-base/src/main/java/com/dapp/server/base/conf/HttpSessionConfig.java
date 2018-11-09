package com.dapp.server.base.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * 添加redis配置类启用redis代码spring默认session
 */
@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 3600)//maxInactiveIntervalInSeconds 默认是1800秒过期
public class HttpSessionConfig {

    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private String port;

    @Value("${spring.redis.password}")
    private String password;

    @Bean
    public JedisConnectionFactory connectionFactory() {
        JedisConnectionFactory factory = new JedisConnectionFactory();
        factory.setHostName(host);
        factory.setPort(Integer.valueOf(port));
        factory.setPassword(password);
        return factory;
    }
}
