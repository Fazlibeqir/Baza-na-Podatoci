package com.rich.onlinegamesshop.service.modelService;

import com.rich.onlinegamesshop.model.Platform;

import java.util.List;

public interface PlatformService {
    void addPlatform(Platform platform);
    List<Platform> getAllPlatforms();
}
