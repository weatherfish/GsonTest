package com.felix.gsontest;

import java.util.Date;

/**
* Descript：
* @auther：weatherfish
* Create time：2015年11月23日 上午9:48:46
* @version
*/

public class SimpleModel {
    
    private int id;
    
    private String name;
    
    private Date birthday;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "SimpleModel [id=" + id + ", name=" + name + ", birthday=" + birthday + "]";
    }
    
    
}


