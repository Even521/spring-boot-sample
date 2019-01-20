package com.even.user.mapstruct;

import com.even.common.mapstruct.EntityMapStruct;
import com.even.user.dto.PermissionDTO;
import com.even.user.dto.RoleDTO;
import com.even.user.entity.BsRole;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

import java.util.List;

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
