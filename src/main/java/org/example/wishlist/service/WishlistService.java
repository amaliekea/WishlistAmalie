package org.example.wishlist.service;

import org.example.wishlist.model.UserWishlistDTO;
import org.example.wishlist.model.Wish;
import org.example.wishlist.model.WishTagDTO;
import org.example.wishlist.repositiory.IWishlistRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishlistService {

    private final IWishlistRepository wishlistRepository;

    public WishlistService(ApplicationContext context, @Value("${department.repository.impl}") String impl) {
        wishlistRepository = (IWishlistRepository) context.getBean(impl);
    }

    public List<Wish> getAllWishes() {
        return wishlistRepository.getAllWishes();

    }

    public void addWish(WishTagDTO wishTagDTO, UserWishlistDTO userWishlist) {
        wishlistRepository.addwish(wishTagDTO, userWishlist);
    }

    public void deleteDTOaWishlistItem(int wish_id) {
        wishlistRepository.deleteDTOWish(wish_id);
    }
}
