package com.taotao.portalweb.service.impl;

import com.taotao.portalweb.bean.TbItem;
import com.taotao.portalweb.bean.TbItemParamGroup;
import com.taotao.portalweb.bean.TbItemParamKey;
import com.taotao.portalweb.bean.TbItemParamValue;
import com.taotao.portalweb.mapper.TbItemParamMapper;
import com.taotao.portalweb.service.TbItemParamService;
import com.taotao.portalweb.vo.TbItemGroupResult;
import com.taotao.portalweb.vo.TbItemTerm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TbItemParamServiceImpl implements TbItemParamService {
    @Autowired
    private TbItemParamMapper tbItemParamMapper;


    @Override
    public List<TbItemGroupResult> findItemById(Long id) {
        List<TbItemGroupResult> groupResults = new ArrayList<TbItemGroupResult>();
        List<TbItemParamValue> paramValues = tbItemParamMapper.findParamValueByItemId(id);
        List<TbItemTerm> tbItemTerms = new ArrayList<TbItemTerm>();
        boolean isFlag = false;
        for (TbItemParamValue value : paramValues) {
            TbItemTerm tbItemTerm = new TbItemTerm();
            //设置项名
            tbItemTerm.setTermName(value.getParamKey().getParamName());
            //设置项值对象
            tbItemTerm.setTermValue(value.getParamValue());
            //设置组id
            tbItemTerm.setGroupId(value.getParamKey().getParamGroup().getId());
            //设置组名
            tbItemTerm.setGroupName(value.getParamKey().getParamGroup().getGroupName());
            tbItemTerms.add(tbItemTerm);
        }


        for(int i = 0;i<tbItemTerms.size();i++){
            TbItemTerm tbItemTerm = tbItemTerms.get(i);
            if(i==0){
                //创建返回对象里面有 组名和规格参数项与值的对象
                TbItemGroupResult result = new TbItemGroupResult();
                result.setGroupName(tbItemTerm.getGroupName());
                List<TbItemTerm> terms = new ArrayList<TbItemTerm>();
                TbItemTerm itemTerm = new TbItemTerm();
                itemTerm.setTermName(tbItemTerm.getTermName());
                itemTerm.setTermValue(tbItemTerm.getTermValue());
                terms.add(itemTerm);
                result.setItemTermList(terms);
                //吧第一个组对象和集合对象加入到集合里面去
                groupResults.add(result);
                continue;
            }
            /**
             * i = 0 groupResults 为1 值有显示器
             * i = 1 有内存 groupResults 为1 值有显示器 走for循环
             * 内存 == 显示器？
             * i == 2 有内存 有显示器  groupResults 为2 显示器 有内存 走for循环
             * 你现在 是在决定是否要添加第三个值
             *
             * 内存 == 音效？    true
             * 显示器 == 音效吗？ true
             */

            for(int j = 0;j<groupResults.size();j++){
                TbItemGroupResult result = groupResults.get(j);
                if(tbItemTerm.getGroupName().equals(result.getGroupName())){
                    List<TbItemTerm> itemTermList = result.getItemTermList();
                    TbItemTerm tbItemTerm1 = new TbItemTerm();
                    tbItemTerm1.setTermName(tbItemTerm.getTermName());
                    tbItemTerm1.setTermValue(tbItemTerm.getTermValue());
                    itemTermList.add(tbItemTerm1);
                    isFlag = false;
                }else{
                    isFlag = true;
                }
            }
            if(isFlag){
                //创建返回对象里面有 组名和规格参数项与值的对象
                TbItemGroupResult groupResult = new TbItemGroupResult();
                groupResult.setGroupName(tbItemTerm.getGroupName());
                List<TbItemTerm> terms = new ArrayList<TbItemTerm>();
                TbItemTerm itemTerm = new TbItemTerm();
                itemTerm.setTermName(tbItemTerm.getTermName());
                itemTerm.setTermValue(tbItemTerm.getTermValue());
                terms.add(itemTerm);
                groupResult.setItemTermList(terms);
                //吧第一个组对象和集合对象加入到集合里面去
                groupResults.add(groupResult);
                isFlag = false;
            }


        }

        return groupResults;
    }

}
