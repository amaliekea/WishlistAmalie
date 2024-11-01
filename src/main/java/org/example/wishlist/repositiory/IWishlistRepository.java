package org.example.wishlist.repositiory;
import org.example.wishlist.model.*;

import java.util.List;

public interface IWishlistRepository {

    //CREATE
    void addWish(WishTagDTO wishTagDTO, UserWishlistDTO uw); //Tilføj et ønske til en ønskeliste

    public UserWishlistDTO getUserwishlistById(int wishlist_id);

    //READ
    List<Wish> getAllWishes(int wishlist_id); //se alle ønkser fra en ønskelisten

    List<Tag> getAvaliableTags(); //se alle mulige tags

    List<Tag> getTags(int wish_id); //se tags på et specifikt ønske

    //UPDATE
    void editWish(int wish_id); //editer et specifikt ønske

    //DELETE
    void deleteDTOWish(int wish_id); //slet et ønske

    void giveWish(int wish_id); //giv et ønske
}
