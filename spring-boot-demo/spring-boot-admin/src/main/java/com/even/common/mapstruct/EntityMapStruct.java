package com.even.common.mapstruct;

import java.util.List;

/**
 * Created by Administrator on 2019/1/17 0017.
 *
 * @author even
 * mapStruct公共转换接口
 */
public interface EntityMapStruct<D,E> {
    /**
     * DTO转Entity
     * @param dto
     * @return
     */
    E toEntity(D dto);
    /**
     * Entity转DTO
     * @param entity
     * @return
     */
    D toDto(E entity);
    /**
     * DTO集合转Entity集合
     * @param dtoList
     * @return
     */
    List<E> toEntity(List<D> dtoList);

    /**
     * Entity集合转DTO集合
     * @param entityList
     * @return
     */
    List <D> toDto(List<E> entityList);

}
