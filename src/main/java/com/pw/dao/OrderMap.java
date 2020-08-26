package com.pw.dao;

import com.pw.pojo.Orders;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 武祥市
 */
@Mapper
@Repository
public interface OrderMap {
    /**
     增加订单
     */
    int addOrders(Orders orders);
    /**
     删除订单
     */
    int deleteOrders(@Param("id") int id);
    /**
     修改订单
     */
    int updateOrders(Orders orders);
    /**
    查找订单
     */
    List<Orders> findOrders(@Param("uid") String uid);
    /**
     查找数量
     */
    int findOrdersCount();
}
