package com.even.user.mapstruct;

import com.even.common.mapstruct.EntityMapStruct;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * Created by Administrator on 2019/1/17 0017.
 *
 * @author even
 */
@Mapper(componentModel = "spring", uses = {PermissionMapStruct.class}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RoleMapStruct extends EntityMapStruct {
}
