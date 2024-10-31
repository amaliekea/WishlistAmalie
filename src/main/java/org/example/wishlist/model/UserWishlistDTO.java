package org.example.wishlist.model;

import java.util.List;

public class UserWishlistDTO { //samler alle informationer omkring en wishlist
    private String wishlist_name;
    private int wishlist_id;
    private int user_id;
    private int role_id;
    private String role_name;
    List<WishTagDTO> wishes;
//hej
    public UserWishlistDTO(String wishlist_name, int wishlist_id, int user_id, int role_id, String role_name, List<WishTagDTO> wishes) {
        this.wishlist_name = wishlist_name;
        this.wishlist_id = wishlist_id;
        this.user_id = user_id;
        this.role_id = role_id;
        this.role_name = role_name;
        this.wishes = wishes;
    }

    public String getWishlist_name() {
        return wishlist_name;
    }

    public void setWishlist_name(String wishlist_name) {
        this.wishlist_name = wishlist_name;
    }

    public int getWishlist_id() {
        return wishlist_id;
    }

    public void setWishlist_id(int wishlist_id) {
        this.wishlist_id = wishlist_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public List<WishTagDTO> getWishes() {
        return wishes;
    }

    public void setWishes(List<WishTagDTO> wishes) {
        this.wishes = wishes;
    }

    @Override
    public String toString() {
        return "UserWishlistDTO{" +
                "wishlist_name='" + wishlist_name + '\'' +
                ", wishlist_id=" + wishlist_id +
                ", user_id=" + user_id +
                ", role_id=" + role_id +
                ", role_name='" + role_name + '\'' +
                ", wishes=" + wishes +
                '}';
    }
}
