package com.javanoteany.common.utils.tree;

import org.springframework.util.CollectionUtils;

import java.io.Serializable;
import java.util.List;
/**
 * @author javanoteany
 * @Date 2021-12-12
 * @Description
 * @Version 1.0
 */
public class JsonTreeData implements Serializable {

    public String id;       //json id
    public String text;     //json 显示文本
    public String state;    //json 'open','closed'
    public boolean checked;
    public Object data;
    public List<JsonTreeData> children;       //

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public String getState() {
        if(!CollectionUtils.isEmpty(children)){
            return "open";
        }else{
            return "close";
        }
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public void setState(String state) {
        this.state = state;
    }
    public List<JsonTreeData> getChildren() {
        return children;
    }
    public void setChildren(List<JsonTreeData> children) {
        this.children = children;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
