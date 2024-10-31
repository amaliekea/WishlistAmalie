package org.example.wishlist.model;

import java.util.List;

public class UserWishlistDTO {
    private String wishlist_name;
    private int wishlist_id;
    private int user_id;
    private int role_id;
    private String role_name;
    List<WishTagDTO> wishes;


}
