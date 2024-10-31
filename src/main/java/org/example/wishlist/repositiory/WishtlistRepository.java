package org.example.wishlist.repositiory;
//hej
import org.example.wishlist.model.Tag;
import org.example.wishlist.model.Wish;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.util.List;

@Repository("DEPARTMENT_REPOSITORY")
public class WishtlistRepository implements IWishlistRepository {
    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;


    @Override
    public void addwish(Wish wish) {

    }

    @Override
    public List<Wish> getAllWishes(int wishlist_id) {
        return List.of();
    }

    @Override
    public List<Tag> getAvaliableTags() {
        return List.of();
    }
//hej
    @Override
    public List<Tag> getTags(int wish_id) {
        return List.of();
    }

    @Override
    public void editWish(int wish_id) {

    }

    @Override
    public void deleteWish(int wish_id) {

    }

    @Override
    public void giveWish(int wish_id) {

    }
}
