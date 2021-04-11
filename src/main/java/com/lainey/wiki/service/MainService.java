package com.lainey.wiki.service;

import com.lainey.wiki.domain.Main;
import com.lainey.wiki.mapper.MainMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MainService {

    @Resource
    private MainMapper mainMapper;

    public List<Main> list(){
        return mainMapper.selectByExample(null);
    }
}
