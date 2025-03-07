package com.example.demo.service;

import com.example.demo.Entity.Member;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HomeService {

    public List<Member> memberList();
}
