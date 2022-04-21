package com.example.bl_lab1.util;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface XMLUtil {
     void saveEntity(List<?> saveEntity, String xmlPath);
    <T> Object getEntity(Class<T> convertClass, String aliasName, String xmlPath);
}
