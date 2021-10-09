package com.example.filedemo.biz.stream.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.example.filedemo.biz.stream.StreamService;
import com.example.filedemo.dao.OrderMainMapper;
import com.example.filedemo.dto.order.OrderMainDTO;
import com.example.filedemo.dto.order.OrderMainParam;
import com.example.filedemo.manager.OrderMainManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.rmi.runtime.Log;

import javax.activation.MailcapCommandMap;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ZJBR
 */
@Slf4j
@Service
public class StreamServiceImpl implements StreamService {

    @Autowired
    private OrderMainManager orderMainManager;

    @Override
    public void test() {
        OrderMainParam orderMainParam = OrderMainParam.builder().updator("徐坤隆").build();
        List<OrderMainDTO> orderMainDTOList = orderMainManager.queryByParam(orderMainParam);
        if (CollectionUtil.isEmpty(orderMainDTOList)){
            log.info("查询结果为空");
        }
    }

}
