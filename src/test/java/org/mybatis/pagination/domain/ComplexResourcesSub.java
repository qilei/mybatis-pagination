package org.mybatis.pagination.domain;

/**
 * Created by qilei on 2015/2/2.
 */
public class ComplexResourcesSub extends ResourcesSub {
    private String resName;

    public String getResName() {
        return resName;
    }

    public void setResName(String resName) {
        this.resName = resName;
    }

    @Override
    public String toString() {
        return "ComplexResourcesSub{" +
                "resName='" + resName + '\'' +
                "} " + super.toString();
    }
}
