package com.taotao.portalweb.mapper;

import com.taotao.portalweb.bean.TbUser;
import com.taotao.portalweb.utils.TaotaoResult;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface TbUserMapper {
    @Insert("INSERT tbuser ( userName, passWord, phone, email, created, updated,status) VALUE (#{userName},#{passWord},#{phone},#{email},#{created},#{updated},#{status})")
    int register(TbUser tbUser);

    @Select("SELECT * FROM tbuser WHERE userName = #{userName}")
    TbUser checkName(@Param("userName") String userName);

    @Select("SELECT * FROM tbuser WHERE email = #{email}")
    TbUser checkMail(@Param("email") String email);

    @Select("SELECT * FROM tbuser WHERE phone = #{userPhone}")
    TbUser checkPhone(@Param("userPhone") String phone);

    @Update("update tbuser set status=1 where email = #{to}")
    int updateStatus(@Param("to") String email);
@Select("SELECT count(*) FROM tbuser WHERE userName = #{username} AND passWord = #{password}")
    int login(@Param("username") String username, @Param("password") String password);
@Select("SELECT status FROM tbuser WHERE userName = #{username}")
    int checkStatus(@Param("username") String username);
}