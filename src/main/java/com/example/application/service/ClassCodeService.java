//package com.example.application.service;
//
//import com.example.application.repository.ClassCodeRepository;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//public class ClassCodeService {
//
//    private List<ClassCodeRepository> classCodeRepository;
//
//
//        public List<String> getAllClassCodes() {
//            return classCodeRepository.stream()
//                    .flatMap(provider -> provider.findAllCourseKeys().stream())
//                    .distinct()
//                    .collect(Collectors.toList());
//        }
//    }
//
//
//
//
