package xyz.huanxicloud.blockchainj.core.blockchain.db;

import org.iq80.leveldb.DB;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import static org.iq80.leveldb.impl.Iq80DBFactory.asString;
import static org.iq80.leveldb.impl.Iq80DBFactory.bytes;

/**
 * levelDB 存储键值对
 */
@Component
public class LevelDbStoreImpl implements DbStore {
    @Resource
    private DB db;

    @Override
    public void put(String key, String value) {
        db.put(bytes(key), bytes(value));
    }

    @Override
    public String get(String key) {
        return asString(db.get(bytes(key)));
    }

    @Override
    public void remove(String key) {
        db.delete(bytes(key));
    }
}
