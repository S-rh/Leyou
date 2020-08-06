package com.leyou.item.service.impl;

import com.leyou.item.mapper.SpecGroupMapper;
import com.leyou.item.mapper.SpecParamMapper;
import com.leyou.item.pojo.SpecGroup;
import com.leyou.item.pojo.SpecParam;
import com.leyou.item.service.SpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("specificationService")
public class SpecificationServiceImpl implements SpecificationService {

    @Autowired
    private SpecParamMapper specParamMapper;
    @Autowired
    private SpecGroupMapper specGroupMapper;

    @Override
    public List<SpecGroup> queryGroupsByCid(Long cid) {
        SpecGroup specGroup = new SpecGroup();
        specGroup.setCid(cid);
        return this.specGroupMapper.select(specGroup);
    }

    @Override
    public List<SpecParam> queryParams(Long gid, Long cid, Boolean generic, Boolean searching) {
        SpecParam specParam = new SpecParam();
        specParam.setGroupId(gid);
        specParam.setCid(cid);
        specParam.setGeneric(generic);
        specParam.setSearching(searching);
        return this.specParamMapper.select(specParam);
    }
}
