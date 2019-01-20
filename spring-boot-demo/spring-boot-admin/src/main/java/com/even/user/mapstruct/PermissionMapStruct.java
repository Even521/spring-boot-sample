package com.even.user.mapstruct;

import com.even.common.mapstruct.EntityMapStruct;
import com.even.user.dto.PermissionDTO;
import com.even.user.entity.BsPermission;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * Created by Administrator on 2019/1/17 0017.
 *
 * @author even
 */
//@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PermissionMapStruct extends EntityMapStruct<PermissionDTO, BsPermission> {
}
