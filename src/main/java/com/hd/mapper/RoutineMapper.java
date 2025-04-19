package com.hd.mapper;

import com.hd.model.Routine;
import com.hd.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoutineMapper {
    /**
     * 新增代办事务
     *
     * @param routine
     * @return
     */
    int addRoutine(Routine routine);

    //返回刚才插入的routine
    Routine queryLastInsert();
    List<Routine> queryAllRoutine(int userID);

    int deleteRoutine(Routine routine);

}
