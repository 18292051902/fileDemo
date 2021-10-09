package com.example.filedemo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.filedemo.dto.order.OrderMainDTO;
import com.example.filedemo.dto.order.OrderMainPO;
import com.example.filedemo.dto.order.OrderMainParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMainMapper extends BaseMapper<OrderMainPO> {

    List<OrderMainDTO> queryByParam(OrderMainParam param);

}
