package org.example.wishlist.model;

public class Tag {
    private String tag_name;
    private int tag_id;

    public Tag(String tag_name, int tag_id) {
        this.tag_name = tag_name;
        this.tag_id = tag_id;
    }

    public String getTag_name() {
        return tag_name;
    }

    public void setTag_name(String tag_name) {
        this.tag_name = tag_name;
    }

    public int getTag_id() {
        return tag_id;
    }

    public void setTag_id(int tag_id) {
        this.tag_id = tag_id;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "tag_name='" + tag_name + '\'' +
                ", tag_id=" + tag_id +
                '}';
    }
}
