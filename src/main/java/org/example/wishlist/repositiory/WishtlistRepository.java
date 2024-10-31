package org.example.wishlist.repositiory;

import org.example.wishlist.model.Tag;
import org.example.wishlist.model.Wish;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("DEPARTMENT_REPOSITORY")
public class WishtlistRepository implements IWishlistRepository {
    @Override
    public void addwish(Wish wish) {

    }

    @Override
    public List<Wish> getAllWishes() {
        return List.of();
    }

    @Override
    public List<Tag> getAvaliableTags() {
        return List.of();
    }

    @Override
    public List<Tag> getTags(Wish wish) {
        return List.of();
    }

    @Override
    public void updateWish(Wish wish) {

    }

    @Override
    public void deleteWish(int id) {

    }
}
