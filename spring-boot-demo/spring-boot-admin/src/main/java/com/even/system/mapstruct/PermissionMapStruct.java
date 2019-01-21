package com.even.system.mapstruct;

import com.even.common.mapstruct.EntityMapStruct;
import com.even.system.dto.PermissionDTO;
import com.even.system.entity.BsPermission;

/**
 * Created by Administrator on 2019/1/17 0017.
 *
 * @author even
 */
//@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PermissionMapStruct extends EntityMapStruct<PermissionDTO, BsPermission> {
}
