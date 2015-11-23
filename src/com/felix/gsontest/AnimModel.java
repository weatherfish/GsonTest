package com.felix.gsontest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.google.gson.annotations.Since;
import com.google.gson.annotations.Until;
import java.util.Date;
import java.util.List;

/**
* Descript：
* @auther：weatherfish
* Create time：2015年11月23日 上午10:54:28
* @version
*/

public class AnimModel {
    @Since(2.0)
    private long noSave;
    
    @Expose
    private List<String> list;
    @Expose
    private transient int code;
    @Since(2.0)
    @Expose(serialize = false,deserialize = false)
    private int code2;
    @Since(3.0)
    @Expose(deserialize = false)
    private int code3;
    @Until(2.0)
    @Expose(serialize = false)
    private int code4;
    
    @Expose
    @SerializedName("name")
    private String secondName;
    
    @Expose
    private Date birthday;

    public long getNoSave() {
        return noSave;
    }

    public void setNoSave(long noSave) {
        this.noSave = noSave;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCode2() {
        return code2;
    }

    public void setCode2(int code2) {
        this.code2 = code2;
    }

    public int getCode3() {
        return code3;
    }

    public void setCode3(int code3) {
        this.code3 = code3;
    }

    public int getCode4() {
        return code4;
    }

    public void setCode4(int code4) {
        this.code4 = code4;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "AnimModel [noSave=" + noSave + ", list=" + list + ", code2=" + code2
                + ", code3=" + code3 + ", code4=" + code4 + ", secondName=" + secondName
                + ", birthday=" + birthday + "]";
    }
    
    
}


