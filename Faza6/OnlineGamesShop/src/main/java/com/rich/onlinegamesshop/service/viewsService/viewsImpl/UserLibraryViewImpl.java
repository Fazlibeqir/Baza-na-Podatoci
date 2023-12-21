package com.rich.onlinegamesshop.service.viewsService.viewsImpl;

import com.rich.onlinegamesshop.model.views.UserLibraryView;
import com.rich.onlinegamesshop.repository.viewsRepo.Impl.UserLibraryViewRepository;
import com.rich.onlinegamesshop.service.viewsService.UserLibraryViewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserLibraryViewImpl implements UserLibraryViewService {
    private final UserLibraryViewRepository userLibraryViewRepository;

    public UserLibraryViewImpl(UserLibraryViewRepository userLibraryViewRepository) {
        this.userLibraryViewRepository = userLibraryViewRepository;
    }

    @Override
    public List<UserLibraryView> getUserLibraryView() {
        return this.userLibraryViewRepository.findAll();
    }
}
