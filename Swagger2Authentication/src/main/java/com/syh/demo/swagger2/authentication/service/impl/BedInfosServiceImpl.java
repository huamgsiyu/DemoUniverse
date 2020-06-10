package com.syh.demo.swagger2.authentication.service.impl;

import com.syh.demo.swagger2.authentication.dao.BedInfoDao;
import com.syh.demo.swagger2.authentication.entity.BedInfo;
import com.syh.demo.swagger2.authentication.service.BedInfoService;
import com.syh.demo.swagger2.authentication.util.NurseResponseUtil;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 床位信息表 业务服务类
 * </p>
 *
 * @author HSY
 * @since 2020-06-08
 */
@Service
public class BedInfosServiceImpl implements BedInfoService {
    private final BedInfoDao dao;

    private BedInfosServiceImpl(BedInfoDao dao) {
        this.dao = dao;
    }

    @Override
    public NurseResponseUtil getById (Long id) {
        try {
            return NurseResponseUtil.succeed(dao.getById(id));
        } catch (Exception e) {
            return NurseResponseUtil.failureSystemLevel();
        }
    }

    @Override
    public NurseResponseUtil getByIds (List<Long> ids) {
        try {
            return NurseResponseUtil.succeed(dao.listByIds(ids));
        } catch (Exception e) {
            return NurseResponseUtil.failureSystemLevel();
        }
    }

    @Override
    public NurseResponseUtil save (BedInfo paramBedInfo) {
        try {
            if (dao.save(paramBedInfo)) {
                return NurseResponseUtil.succeed();
            } else {
                return NurseResponseUtil.failureBusinessLevel();
            }
        } catch (Exception e) {
            return NurseResponseUtil.failureSystemLevel();
        }
    }

    @Override
    public NurseResponseUtil saveBatch (List<BedInfo> paramBedInfos) {
        try {
            if (dao.saveBatch(paramBedInfos)) {
                return NurseResponseUtil.succeed();
            } else {
                return NurseResponseUtil.failureBusinessLevel();
            }
        } catch (Exception e) {
            return NurseResponseUtil.failureSystemLevel();
        }
    }

    @Override
    public  NurseResponseUtil update (BedInfo paramBedInfo) {
        try {
            if (dao.updateById(paramBedInfo)) {
                return NurseResponseUtil.succeed();
            } else {
                return NurseResponseUtil.failureBusinessLevel();
            }
        } catch (Exception e) {
            return NurseResponseUtil.failureSystemLevel();
        }
    }

    @Override
    public NurseResponseUtil updateBatch (List<BedInfo> paramBedInfos) {
        try {
            if (dao.updateBatchById(paramBedInfos)) {
                return NurseResponseUtil.succeed();
            } else {
                return NurseResponseUtil.failureBusinessLevel();
            }
        } catch (Exception e) {
            return NurseResponseUtil.failureSystemLevel();
        }
    }

    @Override
    public NurseResponseUtil delete (Long id) {
        try {
            if (dao.removeById(id)) {
                return NurseResponseUtil.succeed();
            } else {
                return NurseResponseUtil.failureBusinessLevel();
            }
        } catch (Exception e) {
            return NurseResponseUtil.failureSystemLevel();
        }
    }

    @Override
    public NurseResponseUtil deleteBatch (List<Long> ids) {
        try {
            if (dao.removeByIds(ids)) {
                return NurseResponseUtil.succeed();
            } else {
                return NurseResponseUtil.failureBusinessLevel();
            }
        } catch (Exception e) {
            return NurseResponseUtil.failureSystemLevel();
        }
    }
}
