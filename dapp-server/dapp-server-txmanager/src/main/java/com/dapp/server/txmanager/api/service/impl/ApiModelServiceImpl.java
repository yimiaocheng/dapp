package com.dapp.server.txmanager.api.service.impl;

import com.dapp.server.txmanager.api.service.ApiModelService;
import com.dapp.server.txmanager.manager.ModelInfoManager;
import com.dapp.server.txmanager.model.ModelInfo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * create by lorne on 2017/11/13
 */
@Service
public class ApiModelServiceImpl implements ApiModelService {


    @Override
    public List<ModelInfo> onlines() {
        return ModelInfoManager.getInstance().getOnlines();
    }


}
