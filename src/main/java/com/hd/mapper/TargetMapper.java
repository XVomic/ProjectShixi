package com.hd.mapper;

import com.hd.model.Routine;
import com.hd.model.Target;
import com.hd.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TargetMapper {
    int addTarget(Target target);
    Target queryLastInsert();

    List<Target> queryAllTarget(int userID);

    int deleteTarget(Target target);
}
