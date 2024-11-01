package org.example.wishlist.repositiory;

import org.example.wishlist.model.Tag;
import org.example.wishlist.model.Wish;
import org.example.wishlist.model.WishTagDTO;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.util.List;
import java.sql.*;


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

    public WishtlistRepository() {

    }

    @Override
    public void addwish(WishTagDTO w) {
            String sqlString = "INSERT INTO wish(wish_name, description, price, wishlist_id, role_id, user_id, wish_id) VALUES(?,?,?,?,?,?,?)";
            String sqlTags = "INSERT INTO wish_tag(tag_id, wish_id) VALUES(?,?)";
            try (Connection con = DriverManager.getConnection(dbUrl.trim(), username.trim(), password.trim())) {

                PreparedStatement statement = con.prepareStatement(sqlString, Statement.RETURN_GENERATED_KEYS);
                statement.setString(1, w.getWish_name());
                statement.setString(2, w.getDescription());
                statement.setDouble(3, w.getPrice());
                System.out.println("SQL query: " + sqlString);
                statement.executeUpdate();
                ResultSet rs = statement.getGeneratedKeys();
                if (rs.next()) {
                    int wish_id = rs.getInt(1);
                    PreparedStatement statementTags = con.prepareStatement(sqlTags);
                    for (int tag_id : w.getTagIds()) {
                        statementTags.setInt(1, tag_id);
                        statementTags.setInt(2, wish_id);
                        statementTags.executeUpdate();
                    }
                }

            } catch (SQLException e) {
                logger.error("SQL exception occurred", e);
            }
    }

    @Override
    public List<Wish> getAllWishes(int wishlist_id) {
        return List.of();
    }


    @Override
    public List<Tag> getAvaliableTags() {
        return List.of();
    }

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
        try (Connection connection = DriverManager.getConnection(dbUrl.trim(), username.trim(), password.trim())) {
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
