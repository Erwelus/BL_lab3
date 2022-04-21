package com.example.bl_lab1.config;

import com.example.bl_lab1.model.VersionEntity;
import com.example.bl_lab1.repositories.SectionRepo;
import com.example.bl_lab1.service.VersionService;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.Instant;
import java.util.Collections;
import java.util.List;

@Configuration
@EnableScheduling
public class SchedulerTasks {

    private final VersionService versionService;
    private final SectionRepo sectionRepo;

    private final int delayTime = 30000;

    public SchedulerTasks(VersionService service, SectionRepo sectionRepo) {
        this.versionService = service;
        this.sectionRepo = sectionRepo;
    }


    @Scheduled(cron = "0 36 18 * * *", zone = "Europe/Moscow")
    public void updateSectionWithLastVersion() {
        System.out.println("Отчищены отклоненные версии");
        versionService.deleteDeclinedVersions();
    }
}
