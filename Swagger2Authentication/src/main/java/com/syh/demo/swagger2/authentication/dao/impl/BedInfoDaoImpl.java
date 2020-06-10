package com.syh.demo.swagger2.authentication.dao.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.syh.demo.swagger2.authentication.dao.BedInfoDao;
import com.syh.demo.swagger2.authentication.entity.BedInfo;
import com.syh.demo.swagger2.authentication.mapper.BedInfoMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 床位信息表 访问数据库服务实现类
 * </p>
 *
 * @author HSY
 * @since 2020-06-08
 */
@Service
public class BedInfoDaoImpl extends ServiceImpl<BedInfoMapper, BedInfo> implements BedInfoDao {

}
