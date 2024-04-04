package edu.csu.store_management_system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import edu.csu.store_management_system.domain.Lineitem;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LineItemMapper extends BaseMapper<Lineitem> {
}
