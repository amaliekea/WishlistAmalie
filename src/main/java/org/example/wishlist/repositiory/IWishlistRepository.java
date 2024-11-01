package org.example.wishlist.repositiory;
import org.example.wishlist.model.*;

import java.util.List;

public interface IWishlistRepository {

    //CREATE
    void addwish(WishTagDTO wishTagDTO, UserWishlistDTO uw); //Tilføj et ønske til en ønskeliste

    //READ
    List<Wish> getAllWishes(); //se alle ønkser fra en ønskelisten

    List<WishTagDTO> getAllDTOWishes();

    List<Wish> getWishlistById(int wishlist_id);

    List<Tag> getAvaliableTags(); //se alle mulige tags

    List<Tag> getTags(int wish_id); //se tags på et specifikt ønske

    //UPDATE
    void editWish(int wish_id); //editer et specifikt ønske

    //DELETE
    void deleteDTOWish(int wish_id); //slet et ønske

    void giveWish(int wish_id); //giv et ønske
}
