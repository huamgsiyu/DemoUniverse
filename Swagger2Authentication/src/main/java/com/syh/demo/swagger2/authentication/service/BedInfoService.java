package com.syh.demo.swagger2.authentication.service;


import com.syh.demo.swagger2.authentication.entity.BedInfo;
import com.syh.demo.swagger2.authentication.util.NurseResponseUtil;

import java.util.List;

/**
 * <p>
 * 床位信息表 业务服务类
 * </p>
 *
 * @author HSY
 * @since 2020-06-08
 */
public interface BedInfoService {
    /**
     * 查询单个
     * @param id    主键Id
     * @return  {@link NurseResponseUtil}
     */
    NurseResponseUtil getById(Long id);

    /**
     * 查询多个
     * @param ids   主键Id
     * @return  {@link NurseResponseUtil}
     */
    NurseResponseUtil getByIds(List<Long> ids);

    /**
     * 新增
     * @param paramBedInfo    床位信息表信息
     * @return  {@link NurseResponseUtil}
     */
    NurseResponseUtil save(BedInfo paramBedInfo);

    /**
     * 批量新增
     * @param paramBedInfos   床位信息表信息
     * @return  {@link NurseResponseUtil}
     */
    NurseResponseUtil saveBatch(List<BedInfo> paramBedInfos);

    /**
     * 更新
     * @param paramBedInfo    床位信息表信息
     * @return  {@link NurseResponseUtil}
     */
    NurseResponseUtil update(BedInfo paramBedInfo);

    /**
     * 批量更新
     * @param paramBedInfo    床位信息表信息
     * @return  {@link NurseResponseUtil}
     */
    NurseResponseUtil updateBatch(List<BedInfo> paramBedInfo);

    /**
     * 删除
     * @param id    主键Id
     * @return  {@link NurseResponseUtil}
     */
    NurseResponseUtil delete(Long id);

    /**
     * 批量删除
     * @param ids   主键Id
     * @return  {@link NurseResponseUtil}
     */
    NurseResponseUtil deleteBatch(List<Long> ids);
}
