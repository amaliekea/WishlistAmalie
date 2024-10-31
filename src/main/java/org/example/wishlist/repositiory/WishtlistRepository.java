package org.example.wishlist.repositiory;
import org.example.wishlist.model.Tag;
import org.example.wishlist.model.Wish;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.util.List;
import java.sql.*;
//he

@Repository("DEPARTMENT_REPOSITORY")
@Lazy
public class WishtlistRepository implements IWishlistRepository {
    private static final Logger logger = LoggerFactory.getLogger(WishtlistRepository.class);

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
    public void deleteDTOWish(int id) {
        String sqlStringTag = "DELETE FROM tags WHERE tag_id = ?";
        String sqlStringWish = "DELETE FROM wish WHERE tag_id = ?";
        try (Connection connection = DriverManager.getConnection(dbUrl.trim(), username.trim(), password.trim())){
            PreparedStatement preparedStatement = connection.prepareStatement(sqlStringTag);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

            PreparedStatement preparedStatementWish = connection.prepareStatement(sqlStringWish);
            preparedStatementWish.setInt(1, id);
            preparedStatementWish.executeUpdate();


        } catch (SQLException e) {
            logger.error("SQL exception occured", e);
        }
    }

    @Override
    public void giveWish(int wish_id) {

    }
}
