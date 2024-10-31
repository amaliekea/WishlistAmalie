package org.example.wishlist.repositiory;
import org.example.wishlist.model.Tag;
import org.example.wishlist.model.Wish;
import java.util.List;

public interface IWishlistRepository {

    //CREATE
    void addwish(Wish wish);

    //READ
    List<Wish> getAllWishes();

    List<Tag> getAvaliableTags();

    List<Tag> getTags(Wish wish);

    //UPDATE
    void updateWish(Wish wish);

    //DELETE
    void deleteWish(int id);
}
