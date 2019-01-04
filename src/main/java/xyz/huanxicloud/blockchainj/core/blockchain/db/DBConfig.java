package xyz.huanxicloud.blockchainj.core.blockchain.db;

import org.iq80.leveldb.DB;
import org.iq80.leveldb.impl.Iq80DBFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import xyz.huanxicloud.blockchainj.core.Constants;

import java.io.File;
import java.io.IOException;

/**
 * @author: huanxi
 * @date: 2019/1/4 17:53
 * 自动配置levelDB
 */
@Configuration
public class DBConfig {
    @Bean
    public DB levelDB() throws IOException {
        org.iq80.leveldb.Options options = new org.iq80.leveldb.Options();
        options.createIfMissing(true);
        return Iq80DBFactory.factory.open(new File(Constants.dataPath), options);
    }
}
