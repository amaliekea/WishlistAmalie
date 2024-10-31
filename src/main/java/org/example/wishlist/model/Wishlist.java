package org.example.wishlist.model;

public class Wishlist {
    private String name;
    private int wishlist_id;
    private int user_id;
    private int role_id;

    public Wishlist(String name, int wishlist_id, int user_id, int role_id) {
        this.name = name;
        this.wishlist_id = wishlist_id;
        this.user_id = user_id;
        this.role_id = role_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "Wishlist{" +
                "name='" + name + '\'' +
                ", wishlist_id=" + wishlist_id +
                ", user_id=" + user_id +
                ", role_id=" + role_id +
                '}';
    }
}
