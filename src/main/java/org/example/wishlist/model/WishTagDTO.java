package org.example.wishlist.model;

import java.util.ArrayList;
import java.util.List;

public class WishTagDTO { //samler alle informationer om et ønske
    private String wish_name;
    private String description;
    private int price;
    private int wish_id;
    List<Integer> tagIds = new ArrayList<>();
    private int wishlist_id;

    public WishTagDTO(String wish_name, String description, int price, int wish_id, List<Integer> tagIds, int wishlist_id) {
        this.wish_name = wish_name;
        this.description = description;
        this.price = price;
        this.wish_id = wish_id;
        this.tagIds = tagIds;
        this.wishlist_id = wishlist_id;
    }

    public WishTagDTO() {

    }

    public String getWish_name() {
        return wish_name;
    }

    public void setWish_name(String wish_name) {
        this.wish_name = wish_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getWish_id() {
        return wish_id;
    }

    public void setWish_id(int wish_id) {
        this.wish_id = wish_id;
    }

    public List<Integer> getTagIds() {
        return tagIds;
    }

    public void setTagIds(List<Integer> tagIds) {
        this.tagIds = tagIds;
    }

    public int getWishlist_id() {
        return wishlist_id;
    }

    public void setWishlist_id(int wishlist_id) {
        this.wishlist_id = wishlist_id;
    }

    @Override
    public String toString() {
        return "WishTagDTO{" +
                "wish_name='" + wish_name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", wish_id=" + wish_id +
                ", tagIds=" + tagIds +
                '}';
    }
}
