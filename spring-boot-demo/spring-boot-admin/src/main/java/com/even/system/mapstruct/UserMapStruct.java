package com.even.system.mapstruct;

import com.even.system.dto.RoleDTO;
import com.even.system.dto.UserDTO;
import com.even.system.entity.BsUser;
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
@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapStruct {
    @Mappings({
            @Mapping(source = "bsUser.id",target = "id"),
            @Mapping(source = "bsUser.userName",target = "userName"),
            @Mapping(source = "bsUser.passWord",target = "passWord"),
            @Mapping(source = "bsUser.avatar",target = "avatar"),
            @Mapping(source = "bsUser.enabled",target = "enabled"),
            @Mapping(source = "bsUser.email",target = "email"),
            @Mapping(source = "bsUser.createTime",target = "createTime"),
            @Mapping(source = "bsUser.updateTime",target = "updateTime"),
            @Mapping(source = "roleDTOS",target = "roleDTOS")
    })
    UserDTO toUserDTO(BsUser bsUser, List<RoleDTO> roleDTOS);
}
