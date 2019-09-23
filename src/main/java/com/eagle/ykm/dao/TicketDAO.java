package com.eagle.ykm.dao;

import com.eagle.ykm.model.Ticket;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @description
 * @auth YKM
 * @date 2019/9/23 19:47
 **/
@Mapper
public interface TicketDAO {
    String table_name = "ticket";
    String insert_field = "user_id, ticket,expired_at";
    String select_field = "id," + insert_field;

    /* 添加ticket
     * @Param: [ticket]
     * @Author: Administrator
     * @Time 20:28
     * @return: int
     **/

    @Insert({"insert into ", table_name, "(", insert_field, ") , values(#{userId},#{ticket},#{expiredAt})"})
    int addTicket(Ticket ticket);

    /* 通过用户id查找ticket
     * @Param: [uid]
     * @Author: Administrator
     * @Time 20:26
     * @return: com.eagle.ykm.model.Ticket
     **/

    @Select({"select", insert_field, "from", table_name, "where  user_id = #{uid}"})
    Ticket selectByUserId(int uid);


    /* 通过ticket来查找ticket
     * @Param: [t]
     * @Author: Administrator
     * @Time 20:27
     * @return: com.eagle.ykm.model.Ticket
     **/
    @Select({"select", insert_field, "from", table_name, "where ticket = #{ticket}"})
    Ticket selectByTicket(String ticket);


    @Delete({"delete from", table_name, "where id = #{tid}"})
    /*  通过id来删除ticket
     * @Param: [tid]
     * @Author: Administrator
     * @Time 20:27
     * @return: void
    **/
    void deleteTicketById(int tid);


    @Delete({"delete from", table_name, "where ticket = #{t}"})
    /* 通过ticket来删除ticket
     * @Param: [t]
     * @Author: Administrator
     * @Time 20:28
     * @return: void
    **/
    void deleteTicket(String t);



}