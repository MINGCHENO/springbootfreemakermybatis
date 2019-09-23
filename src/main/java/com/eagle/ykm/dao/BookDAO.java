package com.eagle.ykm.dao;

import com.eagle.ykm.model.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @description
 * @auth YKM
 * @date 2019/9/21 14:00
 **/
@Mapper
public interface BookDAO {
    String table_name = "book";
    String insert_field = "name, author, price";
    String select_field = "id , status ," + insert_field;

    /* 查询所有数据的信息
     * @Param:
     * @Author: Administrator
     * @Time 14:15
     * @return:
     **/

    @Select({"select", select_field, "from", table_name})
    List<Book> findAll();


    /*  根据id来添加数据
     * @Param:
     * @Author: Administrator
     * @Time 14:15
     * @return:
    **/

    @Insert({"insert into ", table_name, "(", insert_field, ") values (#{name},#{author},#{price})"})
    int addBook(Book book);
    /*添加数据返回数据类型是int型???????不太理解*/

    /* 根据id修改书的status状态
     * @Param:
     * @Author: Administrator
     * @Time 14:16
     * @return:
    **/

    @Update({"update", table_name, "set status = #{status} where id = #{id}"})
    void updateBookStatus(@Param("id") int id, @Param("status") int status);

}