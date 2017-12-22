package com.chenyingjun.meeting.service;

import com.chenyingjun.meeting.constant.CommonConsts;
import com.chenyingjun.meeting.entity.Org;
import com.chenyingjun.meeting.example.OrgExample;
import com.chenyingjun.meeting.mapper.OrgMapper;
import com.chenyingjun.meeting.utils.StringUtils;
import com.github.pagehelper.PageInfo;
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
public class OrgService extends BaseService<Org> {

    /**
     * 组织
     */
    @Autowired
    private OrgMapper orgMapper;

    /**
     * 分页查询
     * @param org 查询信息
     * @param pageNum 当前页码
     * @param pageSize 每页数量
     * @return 组织列表
     */
    public PageInfo<Org> page(Org org, int pageNum, int pageSize) {
        OrgExample example = new OrgExample();
        OrgExample.Criteria criteria = example.createCriteria();
        String name = org.getName();
        if (StringUtils.isNotEmpty(name)) {
            criteria.andNameLike("%" + name + "%");
        }
        criteria.andDelFlagEqualTo(CommonConsts.DEL_FLAG_NORMAL);
        return this.basePageByExample(example, pageNum, pageSize);
    }

    /**
     * 新增或更新组织信息
     * @param org 组织信息
     */
    public int save(Org org) {
        if (null == org) {
            return 0;
        }
        org.setUpdateDate(new Date());
        if (StringUtils.isNotEmpty(org.getId())) {
            return baseUpdateByPrimaryKeySelective(org);
        } else {
            return baseInsert(org);
        }

    }

    /**
     * 逻辑删除
     * @param id 被删除的组织主键
     */
    public int delete(String id) {
        if (StringUtils.isEmptyStr(id)) {
            return 0;
        }
        Org org = new Org();
        org.setId(id);
        org.setDelFlag(CommonConsts.DEL_FLAG_DELETE);
        org.setUpdateDate(new Date());
        return baseUpdateByPrimaryKeySelective(org);
    }
}
