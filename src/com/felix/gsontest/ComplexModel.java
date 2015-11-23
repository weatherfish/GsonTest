package com.felix.gsontest;

import java.util.List;

/**
* Descript：
* @auther：weatherfish
* Create time：2015年11月23日 上午9:49:54
* @version
*/

public class ComplexModel {
    private int code;
    private List<SimpleModel> list;
    private SimpleModel model;
    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public List<SimpleModel> getList() {
        return list;
    }
    public void setList(List<SimpleModel> list) {
        this.list = list;
    }
    public SimpleModel getModel() {
        return model;
    }
    public void setModel(SimpleModel model) {
        this.model = model;
    }
    @Override
    public String toString() {
        return "ComplexModel [code=" + code + ", list=" + list + ", model=" + model + "]";
    }
    
}


