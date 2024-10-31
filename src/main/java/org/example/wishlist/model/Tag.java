package org.example.wishlist.model;

public class Tag {
    private String name;
    private int tag_id;

    public Tag(String name, int tag_id) {
        this.name = name;
        this.tag_id = tag_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
                "name='" + name + '\'' +
                ", tag_id=" + tag_id +
                '}';
    }
}
