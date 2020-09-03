package com.tlh.cloudalibaba.reposity;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tlh.cloudalibaba.model.Storage;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface StorageDAO extends BaseMapper<Storage> {

}