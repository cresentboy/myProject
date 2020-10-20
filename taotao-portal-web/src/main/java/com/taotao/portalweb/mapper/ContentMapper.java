package com.taotao.portalweb.mapper;

import com.taotao.portalweb.bean.TbContent;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface ContentMapper {
    @Select("SELECT * FROM tbcontent WHERE categoryId = #{categoryId}")
    List<TbContent> findContentByCId(Long categoryId);
}
