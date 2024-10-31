package org.example.wishlist.service;
import org.example.wishlist.repositiory.IWishlistRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class WishlistService {

    private final IWishlistRepository wishlistRepository;

    public WishlistService(ApplicationContext context, @Value("${department.repository.impl}") String impl) {
        wishlistRepository = (IWishlistRepository) context.getBean(impl);

    }
}
