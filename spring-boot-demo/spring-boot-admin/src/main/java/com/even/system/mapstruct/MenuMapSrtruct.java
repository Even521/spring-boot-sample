package com.even.system.mapstruct;

import com.even.system.dto.MenuDTO;
import com.even.system.entity.BsMenu;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.awt.*;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MenuMapSrtruct{

    //List<BsMenu> toBsMenu(List<MenuDTO>)
}
