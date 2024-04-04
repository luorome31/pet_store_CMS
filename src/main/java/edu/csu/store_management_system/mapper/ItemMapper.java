package edu.csu.store_management_system.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import edu.csu.store_management_system.domain.Item;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;

@Mapper
public interface ItemMapper extends BaseMapper<Item> {
}
