package com.example.sandy.todolistbyzhuxiaoxi;

public class ListItem {
    private String content;

    private String name;
    private int index;

    public ListItem(String content,String name, int index) {
        this.content = content;
        this.name = name;
        this.index = index;
    }

    public String getName() {
        return name;
    }


    public String getContent() {

        return content;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
