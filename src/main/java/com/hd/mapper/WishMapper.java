package com.hd.mapper;

import com.hd.model.Routine;
import com.hd.model.Target;
import com.hd.model.Wish;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WishMapper {

    /**
     * 新增wish
     *
     * @param wish
     * @return
     */
    int addWish(Wish wish);

    //查询刚刚新增的wish
    Wish queryLastInsert();


    /**
     *
     * @return 所有wish
     */
    List<Wish> queryAllWish();
}
