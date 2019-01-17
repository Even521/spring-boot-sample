package com.even.user.mapstruct;

import com.even.common.mapstruct.EntityMapStruct;
import com.even.user.dto.UserDTO;
import com.even.user.entity.BsUser;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * Created by Administrator on 2019/1/17 0017.
 *
 * @author even
 */
@Mapper(componentModel = "spring",uses = {RoleMapStruct.class},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapStruct extends EntityMapStruct<UserDTO, BsUser> {
}
