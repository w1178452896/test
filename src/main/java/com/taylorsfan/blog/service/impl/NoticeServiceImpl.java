package com.taylorsfan.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taylorsfan.blog.model.Notice;
import com.taylorsfan.blog.repository.NoticeMapper;
import com.taylorsfan.blog.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author taylorsfan
 */
@Service
public class NoticeServiceImpl implements NoticeService {
    private final NoticeMapper noticeMapper;

    @Autowired
    public NoticeServiceImpl(NoticeMapper noticeMapper) {
        this.noticeMapper = noticeMapper;
    }

    @Override
    public List<Notice> findAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<>(noticeMapper.selectAll()).getList();
    }

    @Override
    public boolean update(Notice notice) {
        return noticeMapper.updateByPrimaryKey(notice) != 0;
    }

    @Override
    public boolean delete(int id) {
        return noticeMapper.deleteByPrimaryKey(id) != 0;
    }

    @Override
    public boolean insert(Notice notice) {
        return noticeMapper.insertSelective(notice) != 0;
    }
}
