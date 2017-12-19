package com.chenyingjun.meeting.service;

import com.chenyingjun.meeting.example.OrgExample;
import com.chenyingjun.meeting.constant.CommonConsts;
import com.chenyingjun.meeting.entity.Org;
import com.chenyingjun.meeting.mapper.OrgMapper;
import com.chenyingjun.meeting.utils.StringUtils;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 组织服务
 *
 * @author chenyingjun
 * @version 2017年12月14日
 * @since 1.0
 */
@Service
public class OrgService {

    /**
     * 组织
     */
    @Autowired
    private OrgMapper orgMapper;


    /**
     * 查询组织列表
     * @param org 查询组织信息
     * @param pageNum 当前页码
     * @param pageSize 每页数量
     * @return
     */
    public List<Org> page(Org org, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        OrgExample orgExample = new OrgExample();
        OrgExample.Criteria criteria = orgExample.createCriteria();
        String name = org.getName();
        if (StringUtils.isNotEmpty(name)) {

            criteria.andNameLike("%" + name + "%");
        }
        return orgMapper.selectByExample(orgExample);
    }

    /**
     * 根据主键查询
     * @param id 主键
     * @return 组织信息
     */
    public Org selectOne(String id) {
        Org org = new Org();
        org.setId(id);
        return orgMapper.selectOne(org);
    }

    /**
     * 根据主体查询信息
     * @param org 组织主体
     * @return 组织信息
     */
    public Org selectOne(Org org) {
        return orgMapper.selectOne(org);
    }


    /**
     * 新增或更新组织信息
     * @param org 组织信息
     */
    public void save(Org org) {
        if (null == org) {
            return;
        }
        if (StringUtils.isNotEmpty(org.getId())) {
            updateByPrimaryKeySelective(org);
        } else {
            insert(org);
        }

    }
    /**
     * 新增组织信息
     * @param org 组织信息
     */
    public void insert(Org org) {
        org.setCreateDate(new Date());
        orgMapper.insert(org);
    }

    /**
     * 选 择性更新组织信息
     * @param org 组织信息
     */
    public void updateByPrimaryKeySelective(Org org) {
        org.setUpdateDate(new Date());
        orgMapper.updateByPrimaryKeySelective(org);
    }

    /**
     * 逻辑删除
     * @param id 被删除的组织主键
     */
    public void delete(String id) {
        if (StringUtils.isEmptyStr(id)) {
            return;
        }
        Org org = new Org();
        org.setId(id);
        org.setStatus(CommonConsts.STATUS_DELETE);
        updateByPrimaryKeySelective(org);
    }
}
