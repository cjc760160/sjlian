package com.sjlian.dao;

import com.sjlian.model.Appointment;
import org.apache.ibatis.annotations.Param;

/**
 * DAO层接口
 * Created by lian on 17/7/12.
 */
public interface AppointmentDao extends SuperDAO<Appointment>{
    /**
     * 插入预约图书记录
     *
     * @param bookId
     * @param studentId
     * @return 插入的行数
     */
    int insertAppointment(@Param("bookId") long bookId, @Param("studentId") long studentId);

    /**
     * 通过主键查询预约图书记录，并且携带图书实体
     *
     * @param bookId
     * @param studentId
     * @return
     */
    Appointment queryByKeyWithBook(@Param("bookId") long bookId, @Param("studentId") long studentId);

}
