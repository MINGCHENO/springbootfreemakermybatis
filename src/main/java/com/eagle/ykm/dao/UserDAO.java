package com.eagle.ykm.dao;

import com.eagle.ykm.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import javax.swing.table.TableCellEditor;

/**
 * @description 用户的dao层
 * @auth YKM
 * @date 2019/9/20 18:39
 **/
@Mapper
public interface UserDAO {
    String table_name = "user";
    String insert_field = "name, email, password";
    String select_field = "id," + insert_field;

    @Insert({"insert into", table_name, "(", insert_field,
            ") values (#{name},#{email},#{password})"})
    int addUser(User user);

    @Select({"select",insert_field,"from",table_name,"where id = #{id}"})
    User selectById(int id);

    @Select({"select", insert_field, "from", table_name, "where name = #{name}"})
    User selectByName(String name);

    @Select({"select", insert_field, "from", table_name, "where email = #{email}"})
    User selectByEmail(String email);


    @Update({"update", table_name, "set password = #{password} where id = #{id}"})
    void updatePassword(User user);

}