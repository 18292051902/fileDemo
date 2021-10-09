package com.example.filedemo.manager;

import com.example.filedemo.dao.OrderMainMapper;
import com.example.filedemo.dto.order.OrderMainDTO;
import com.example.filedemo.dto.order.OrderMainParam;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ZJBR
 */
@Component
public class OrderMainManager {

    @Resource
    private OrderMainMapper orderMainMapper;

    public List<OrderMainDTO> queryByParam(OrderMainParam param) {
        return orderMainMapper.queryByParam(param);
    }

}
