package com.syh.demo.swagger2.authentication.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 床位信息表
 * </p>
 *
 * @author HSY
 * @since 2020-06-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("bed_info")
@ApiModel(value="BedInfo对象", description="床位信息表")
public class BedInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "Id", type = IdType.AUTO)
    private Integer Id;

    @ApiModelProperty(value = "创建者")
    private String createBy;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "修改者")
    private String updateBy;

    @ApiModelProperty(value = "修改时间")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "删除标记 0 正常 1 为已删除")
    private Integer deleted;

    @ApiModelProperty(value = "备注")
    private String remarks;

    @ApiModelProperty(value = "机构编码")
    private String orgCode;

    @ApiModelProperty(value = "病区编码")
    private String wardCode;

    @ApiModelProperty(value = "床位编码（机构下唯一）")
    private String bedCode;

    @ApiModelProperty(value = "床号")
    private Integer bedNumber;

    @ApiModelProperty(value = "房间号")
    private Integer roomNumber;

    @ApiModelProperty(value = "床位名称")
    private String bedName;

    @ApiModelProperty(value = "组id （对应bed_group_info 的id，未分组为空）")
    private Long groupId;


}
