package xyz.huanxicloud.blockchainj.data.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.UpdateProvider;
import org.springframework.stereotype.Component;

/**
 * @author: huanxi
 * @date: 2019/1/21 20:12
 */
@Mapper
@Component
public interface RoleMapper {
    @UpdateProvider(type= RoleMapping.class,method = "test")
    void test();
}
