package com.taotao.portalweb.mapper;

import com.taotao.portalweb.bean.TbItem;
import com.taotao.portalweb.vo.Cart;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TbItemMapper {
    @Select("SELECT DISTINCT * FROM tbitem WHERE title LIKE '%${value}%' OR sellPoint LIKE '%${value}%' ORDER BY updated DESC LIMIT #{index},#{limit}")
    List<TbItem> query(@Param("value") String value, @Param("index") Integer index, @Param("limit") Integer limit);
    @Select("SELECT distinct COUNT(*) FROM tbitem WHERE title LIKE '%${value}%' OR sellPoint LIKE '%${value}%'")
    int getCount(String q);
    @Select("SELECT * FROM tbitem WHERE id = #{id}")
    TbItem findTbItemById(Long id);

}
