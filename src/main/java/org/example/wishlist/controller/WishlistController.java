package org.example.wishlist.controller;

import org.example.wishlist.model.Wish;
import org.example.wishlist.service.WishlistService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/")
public class WishlistController {

    private final WishlistService wishlistService;

    public WishlistController(WishlistService wishlistService) {
        this.wishlistService = wishlistService;
    }

    @GetMapping("/")
    public String showAllWishes(Model model) {
        List<Wish> wishes = wishlistService.getAllWishes();
        //
        return "show-wishlist";
    }

    @PostMapping("attractions/delete")
    public String getWishToDelete(@RequestParam String name) {
        //TODO kald den rigtige gettermetoder, når den er blevet lavet.
        //Wish w = wishlistService.getWishByName(name);
        //if (w != null) {
        //    wishlistService.deleteDTOaWishlistItem(w);
        //}
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String deleteWishlistItem(@RequestParam int wish_Id) {
        wishlistService.deleteDTOaWishlistItem(wish_Id);
        //TODO indsæt korrekt redirection herunder.
        return "redirect:/show-wishlist";
    }
}
