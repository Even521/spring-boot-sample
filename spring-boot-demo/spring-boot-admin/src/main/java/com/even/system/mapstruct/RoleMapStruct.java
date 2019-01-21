package com.even.system.mapstruct;

import com.even.common.mapstruct.EntityMapStruct;

/**
 * Created by Administrator on 2019/1/17 0017.
 *
 * @author even
 */
//@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RoleMapStruct extends EntityMapStruct {
 /*  // @Mappings({
            @Mapping(source = "bsRole.id",target = "id"),
            @Mapping(source = "bsRole.roleName",target = "roleName"),
            @Mapping(source = "bsRole.remark",target = "remark"),
            @Mapping(source = "bsRole.createTime",target = "createTime"),
            @Mapping(source = "permissions",target = "permissions")
  //  })
    RoleDTO toRoleDTO(BsRole bsRole, List<PermissionDTO> permissions);*/
}
