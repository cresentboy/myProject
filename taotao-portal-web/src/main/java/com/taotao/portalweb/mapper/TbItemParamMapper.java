package com.taotao.portalweb.mapper;

import com.taotao.portalweb.bean.TbItemParamGroup;
import com.taotao.portalweb.bean.TbItemParamKey;
import com.taotao.portalweb.bean.TbItemParamValue;
import com.taotao.portalweb.vo.TbItemGroupResult;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;


@Mapper
public interface TbItemParamMapper {

    @Select("SELECT * FROM tbitemparamvalue WHERE itemId = #{id}")
    @Results({
            @Result(id = true,property = "itemId",column = "itemId"),
            @Result(property = "paramId",column = "paramId"),
            @Result(property = "paramValue",column = "paramValue"),
            @Result(property = "paramKey",column = "paramId",one = @One(select = "com.taotao.portalweb.mapper.TbItemParamMapper.findParamKeyById",fetchType = FetchType.EAGER))
    })
    List<TbItemParamValue> findParamValueByItemId(Long id);

    //根据规格参数项id 查询规格参数信息
    @Select("SELECT * FROM tbitemparamkey WHERE id = #{id}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "paramName",column = "paramName"),
            @Result(property = "groupId",column = "groupId"),
            @Result(property = "paramGroup",column = "groupId",one = @One(select = "com.taotao.portalweb.mapper.TbItemParamMapper.findParamGroupById",fetchType = FetchType.EAGER))
    })
    List<TbItemParamKey> findParamKeyById(Long id);

    @Select("SELECT * FROM tbitemparamgroup WHERE id = #{id}")
    List<TbItemParamGroup> findParamGroupById(Long id);

    List<TbItemGroupResult> findAlla(Long id);
}
