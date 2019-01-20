package com.even.user.mapstruct;

import com.even.common.mapstruct.EntityMapStruct;
import com.even.user.dto.RoleDTO;
import com.even.user.dto.UserDTO;
import com.even.user.entity.BsUser;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.Set;

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
