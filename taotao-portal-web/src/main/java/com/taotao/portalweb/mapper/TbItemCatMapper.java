package com.taotao.portalweb.mapper;

import com.taotao.portalweb.bean.TbItemCat;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TbItemCatMapper {
    @Select("SELECT id,name FROM tbitemcat WHERE parentId = #{id}")
    List<TbItemCat> findTbItemCatById(Long id);
    @Select("SELECT * FROM tbitemcat WHERE id = #{id}")
    TbItemCat getTbItemCatById(Long id);
}
