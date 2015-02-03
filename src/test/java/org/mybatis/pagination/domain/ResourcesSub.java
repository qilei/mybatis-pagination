package org.mybatis.pagination.domain;

import java.io.Serializable;

//@Alias("res")
public class ResourcesSub implements Serializable {
    private String id;

    private String name;

    private String resId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResId() {
        return resId;
    }

    public void setResId(String resId) {
        this.resId = resId;
    }

    @Override
    public String toString() {
        return "ResourceSub{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", resId='" + resId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ResourcesSub that = (ResourcesSub) o;

        if (!id.equals(that.id)) return false;
        if (!name.equals(that.name)) return false;
        if (!resId.equals(that.resId)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + resId.hashCode();
        return result;
    }
}