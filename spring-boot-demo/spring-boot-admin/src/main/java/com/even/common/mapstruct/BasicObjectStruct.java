package com.even.common.mapstruct;

import org.mapstruct.InheritConfiguration;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mappings;

import java.util.List;

/**
 * Created by Administrator on 2019/1/17 0017.
 *
 * @author even
 * mapStruct公共转换接口
 */
public interface BasicObjectStruct<SOURCE,TARGET> {
    /**
     * 转成目标对象
     * @param source
     * @return
     */
    @Mappings({})
    @InheritConfiguration
    TARGET to(SOURCE source);

    @InheritInverseConfiguration
    SOURCE from(TARGET target);

    @InheritConfiguration
    List<TARGET> to(List<SOURCE> sources);

    @InheritInverseConfiguration
    List<SOURCE> from(List<TARGET> targets);
}
