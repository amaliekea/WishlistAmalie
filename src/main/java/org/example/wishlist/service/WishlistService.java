package org.example.wishlist.service;


import org.example.wishlist.model.Tag;
import org.example.wishlist.model.UserWishlistDTO;

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
    public UserWishlistDTO getUserwishlistById(int wishlist_id) {
        return wishlistRepository.getUserwishlistById(wishlist_id);
    }



    public List<WishTagDTO> getAllDTOWishes() {
        return wishlistRepository.getAllDTOWishes();
    }



    public void deleteDTOaWishlistItem(int wish_id) {
        wishlistRepository.deleteDTOWish(wish_id);
    }

    public void addWish(WishTagDTO w, UserWishlistDTO uw) {
        wishlistRepository.addWish(w, uw);
    }

    public List<Tag> getAvaliableTags() {
        return wishlistRepository.getAvaliableTags();
    }
}
