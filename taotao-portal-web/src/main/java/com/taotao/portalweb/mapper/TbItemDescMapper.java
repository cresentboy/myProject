package com.taotao.portalweb.mapper;

import com.taotao.portalweb.bean.TbItemDesc;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TbItemDescMapper {
    @Select("SELECT * FROM tbitemdesc WHERE itemId = #{id}")
    TbItemDesc findItemById(Long id);
}
