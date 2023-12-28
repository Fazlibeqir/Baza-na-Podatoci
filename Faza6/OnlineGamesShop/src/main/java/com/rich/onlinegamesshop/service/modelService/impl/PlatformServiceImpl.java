package com.rich.onlinegamesshop.service.modelService.impl;

import com.rich.onlinegamesshop.model.Platform;
import com.rich.onlinegamesshop.repository.PlatformRepository;
import com.rich.onlinegamesshop.service.modelService.PlatformService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlatformServiceImpl implements PlatformService {
    private final PlatformRepository platformRepository;

    public PlatformServiceImpl(PlatformRepository platformRepository) {
        this.platformRepository = platformRepository;
    }

    @Override
    public List<Platform> getAllPlatforms() {
        return platformRepository.findAll();
    }
}
