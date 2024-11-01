package org.example.wishlist.repositiory;

import org.example.wishlist.model.Tag;
import org.example.wishlist.model.UserWishlistDTO;
import org.example.wishlist.model.Wish;
import org.example.wishlist.model.WishTagDTO;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.util.ArrayList;
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
    public void addwish(WishTagDTO w, UserWishlistDTO uw) {
        String sqlString = "INSERT INTO wish(wish_name, description, price, wishlist_id, role_id, user_id, wish_id) VALUES(?,?,?,?,?,?,?)";
        String sqlTags = "INSERT INTO wish_tag(tag_id, wish_id) VALUES(?,?)";
        try (Connection con = DriverManager.getConnection(dbUrl.trim(), username.trim(), password.trim())) {

            PreparedStatement statement = con.prepareStatement(sqlString, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, w.getWish_name());
            statement.setString(2, w.getDescription());
            statement.setDouble(3, w.getPrice());
            statement.setDouble(4, uw.getWishlist_id());
            statement.setDouble(5, uw.getRole_id());
            statement.setDouble(6, uw.getUser_id());
            statement.setDouble(7, w.getWish_id());
//                System.out.println("SQL query: " + sqlString);
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
    public List<Wish> getAllWishes() {
        List<Wish> wishes = new ArrayList<>();
        String sql = "SELECT * FROM wish";

        try (Connection connection = DriverManager.getConnection(dbUrl.trim(), username.trim(), password.trim());
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                Wish wish = new Wish( // Opretter Wish-objektet
                        resultSet.getString("wish_name"),
                        resultSet.getString("description"),
                        resultSet.getInt("price"),
                        resultSet.getInt("wishlist_id"),
                        resultSet.getInt("role_id"),
                        resultSet.getInt("user_id"),
                        resultSet.getInt("wish_id")
                );
                wishes.add(wish);
            }
        } catch (SQLException e) {
            logger.error("SQL exception occurred", e);
        }

        return wishes;
    }


    @Override
    public List<WishTagDTO> getAllDTOWishes() {
        List<WishTagDTO> wishes = new ArrayList<>();
        String sqlString = "SELECT wish_name, description, price, wish_id, user_id, role_id FROM wish";
        String sqlString2 = "SELECT tag_id FROM wish_tag WHERE wish_id ?";

        try (Connection connection = DriverManager.getConnection(dbUrl.trim(), username.trim(), password.trim())) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlString);

            while (resultSet.next()) {
                String wishName = resultSet.getString("wish_name");
                String description = resultSet.getString("description");
                int price = resultSet.getInt("price");
                int wishId = resultSet.getInt("wish_id");
                int userId = resultSet.getInt("user_id");
                int role_id = resultSet.getInt("role_id");

                PreparedStatement preparedStatement = connection.prepareStatement(sqlString2);
                preparedStatement.setInt(1, wishId);
                ResultSet resultSetTags = preparedStatement.executeQuery();

                // Liste til tags for dette specifikke ønske
                List<Integer> wishTags = new ArrayList<>();
                while (resultSetTags.next()) {
                    wishTags.add(resultSetTags.getInt("tag_id"));
                }

                //Opret DTO for ønske med tilknyttet tags
                WishTagDTO dto = new WishTagDTO(wishName, description, price, wishId);
                dto.setTagIds(wishTags);
                wishes.add(dto);

            }
        } catch (SQLException e) {
            logger.error("SQL exception occurred", e);
        }
        return wishes;
    }


    @Override
    public List<Wish> getWishlistById(int wishlist_id) {
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
    public Wish getWishByID(int wish_id) {
        //TODO Denne queary skal tjekkes om den er korrekt.
        String sqlStringWish = "SELECT w.name, t.description, w.price, w.wishlist_id, w.role_id, w.user_id, w.wish_id FROM wish WHERE wish_id = ?";
        Wish wish = null;
        try ( Connection connection = DriverManager.getConnection(dbUrl.trim(), username.trim(), password.trim())){
            PreparedStatement statement = connection.prepareStatement(sqlStringWish);
            statement.setInt(1, wish_id);

            ResultSet resultSet = statement.executeQuery();
            if ( resultSet.next()) {
                String wishName = resultSet.getString("name");
                String description = resultSet.getString("description");
                int price = resultSet.getInt("price");
                int wishlist_id = resultSet.getInt("wishlist_id");
                int role_id = resultSet.getInt("role_id");
                int user_id = resultSet.getInt("user_id");
                int wishid = resultSet.getInt("wish_id");

                wish = new Wish(wishName,description,price,wishlist_id,role_id,user_id,wishid);

            }

        } catch (SQLException e) {
            logger.error("SQL exception occured", e);
        }

        //indsæt rigtig returnvariable.
        return wish;
    }

    @Override
    public void editWish(int wish_id) {

    }

    @Override
    public void deleteDTOWish(int id) {
        String sqlStringTag = "DELETE FROM wish_tag WHERE tag_id = ?";
        String sqlStringWish = "DELETE FROM wish WHERE wish_id = ?";
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
