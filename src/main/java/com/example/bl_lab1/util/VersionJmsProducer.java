package com.example.bl_lab1.util;

import com.example.bl_lab1.model.VersionEntity;

import java.util.Map;

public interface VersionJmsProducer {
    void sendVersion(Map<String, Object> message);
}
