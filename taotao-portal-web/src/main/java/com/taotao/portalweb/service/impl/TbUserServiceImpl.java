package com.taotao.portalweb.service.impl;

import com.taotao.portalweb.bean.TbUser;
import com.taotao.portalweb.mapper.TbUserMapper;
import com.taotao.portalweb.service.TbUserService;
import com.taotao.portalweb.utils.MailClientSend;
import com.taotao.portalweb.utils.TaotaoResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Encoder;

import java.util.Date;


@Service
public class TbUserServiceImpl implements TbUserService {
    @Autowired
    private TbUserMapper tbUserMapper;
    @Override
    public TaotaoResult register(TbUser tbUser) {
        String userName = tbUser.getUserName();
        String email = tbUser.getEmail();
        String phone = tbUser.getPhone();
        //验证名称
        TbUser  name = tbUserMapper.checkName(userName);
        if (name!=null){
            return TaotaoResult.build(500,"用户名已存在");
        }
        //验证邮箱
        TbUser mail = tbUserMapper.checkMail(email);
        if (mail!=null){
            return TaotaoResult.build(500,"该邮箱已注册过");
        }
        //验证手机号
        TbUser userPhone = tbUserMapper.checkPhone(phone);
        if (userPhone!=null){
            return TaotaoResult.build(500,"该手机号已注册过");
        }
        Date created = new Date();
        Date updated = new Date();
tbUser.setCreated(created);
tbUser.setUpdated(updated);
//密码加密
tbUser.setPassWord(new BASE64Encoder().encode(tbUser.getPassWord().getBytes()));
//设置用户状态不可用
        tbUser.setStatus(0);

       //发送激活邮件
        MailClientSend client=new MailClientSend();

        try {
            //初始化
            client.init();
            //发送邮件
            client.sendMessage(tbUser.getEmail());
            //关闭连接
            client.close();
        } catch (Exception e) {
            e.printStackTrace();
        }



        int count = tbUserMapper.register(tbUser);
        if (count == 0){
            return TaotaoResult.build(500,"注册失败");
        }

return TaotaoResult.build(200,"注册成功");
    }

    @Override
    public TaotaoResult activateMail(String to) {

int count1 = tbUserMapper.updateStatus(to);
if(count1==0){
    return TaotaoResult.build(500,"邮箱激活失败");
}

        return TaotaoResult.build(200,"邮箱激活成功");
    }

    @Override
    public TaotaoResult login(String username, String password) {
       String newPassword = new BASE64Encoder().encode(password.getBytes());
        int count = tbUserMapper.login(username,newPassword);

        if(count ==0){
            return TaotaoResult.build(500,"登录失败，请检查用户名和密码是否正确");
        }
        int status = tbUserMapper.checkStatus( username);

        if(status!=1){
            return TaotaoResult.build(500,"该账户尚未激活！");
        }
        return TaotaoResult.build(200,"登录成功");
    }


}
