package org.example.wishlist.controller;

import org.example.wishlist.model.UserWishlistDTO;
import org.example.wishlist.model.Wish;
import org.example.wishlist.model.WishTagDTO;
import org.example.wishlist.service.WishlistService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class WishlistController {

    private final WishlistService wishlistService;

    public WishlistController(WishlistService wishlistService) {
        this.wishlistService = wishlistService;
    }
    @GetMapping("/addWish")
    public String addWish(Model model) {
        WishTagDTO wishTagDTO = new WishTagDTO();
        model.addAttribute("wishdto", wishTagDTO);
        model.addAttribute("avaliableTags", wishlistService.getAvaliableTags());
        return "addWish";
    }
    @PostMapping("/addWish")
    public String addAttraction(@ModelAttribute WishTagDTO wishtagdto, Model model) throws Exception {
        UserWishlistDTO userWishlistDTO = wishlistService.getUserwishlistById(wishtagdto.getWishlist_id());
        wishlistService.addWish(wishtagdto, userWishlistDTO);
        return "redirect:/show-wishlist";
    }

    @PostMapping("/delete")
    public String deleteWishlistItem(@RequestParam int wish_Id) {
        wishlistService.deleteDTOaWishlistItem(wish_Id);
        //TODO indsæt korrekt redirection herunder.
        return "redirect:/";
    }

}
