package com.example.demo.service;

import com.example.demo.Entity.Member;
import com.example.demo.repository.HomeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeServiceImpl implements HomeService {
    @Autowired
   private HomeRepository homeRepository;

    @Override
    public List<Member> memberList(){
        return null;
    }

}
