package org.example.wishlist.controller;

import org.example.wishlist.service.WishlistService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class WishlistController {

    private final WishlistService wishlistService;

    public WishlistController(WishlistService wishlistService) {
        this.wishlistService = wishlistService;
    }

    @PostMapping("/delete")
    public String deleteWishlistItem(@RequestParam int wish_Id) {
        wishlistService.deleteDTOaWishlistItem(wish_Id);
        //TODO indsæt korrekt redirection herunder.
        return "redirect:/";
    }
}
