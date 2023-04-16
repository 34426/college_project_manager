package com.javanoteany.common.utils.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Function;

/**
 * @author javanoteany
 * @Date 2021-12-12
 * @Description
 * @Version 1.0
 */
public class JsonTreeCreater<T> {
    private final Function<T, String> getParentId;
    private final List<T> data;
    private final Function<T, String> getId;

    //默认不获取
    private  Function<T, String> getName = a->null;

    private  Function<T, Boolean> getChecked = a->false;//默认不勾选

    private  Function<T, Object> getData = a->null;

    HashMap<String, JsonTreeData> parentIndex = new HashMap<String, JsonTreeData>();

    JsonTreeData treeRootItem = new JsonTreeData();

    /**
     * 树形创建器
     * @param data  元数据
     * @param getId 解析id的方法
     * @param getParentId   解析父id的方法
     */
    public JsonTreeCreater(List<T> data,Function<T, String> getId,Function<T, String> getParentId) {
        this.data = data;
        this.getParentId = getParentId;
        this.getId = getId;
    }

    /**
     * 树形创建器
     * @param data  元数据
     * @param getId 解析id的方法
     * @param getParentId   解析父id的方法
     * @param getName   树形显示的方法
     * @param getChecked    是否勾选的方法
     */
    public JsonTreeCreater(List<T> data, Function<T, String> getId,Function<T, String> getParentId,
                           Function<T, String> getName, Function<T, Boolean> getChecked,Function<T,Object> getData) {
        this.getParentId = getParentId;
        this.data = data;
        this.getId = getId;
        this.getName = getName;
        this.getChecked = getChecked;
    }


    public  List<JsonTreeData> create() {
        //初始化根节点
        treeRootItem.setChildren(new ArrayList<>());
        parentIndex.put("0", treeRootItem);
        for (T t : data) {//遍历所有节点，然后记录下来
            JsonTreeData treeItem = new JsonTreeData();
            treeItem.setData(getData.apply(t));
            treeItem.setText(getName.apply(t));
            treeItem.setChecked(getChecked.apply(t));
            treeItem.setId(getId.apply(t));
            treeItem.setChildren(new ArrayList<>());
            //将当前节点当父节点记下来。
            parentIndex.put(getId.apply(t), treeItem);
        }
        for (T t : data) {
            JsonTreeData node = parentIndex.get(getId.apply(t));//获取当前节点
            JsonTreeData parentNode = parentIndex.get(getParentId.apply(t));//获取父节点
            parentNode.setChecked(false);
            parentNode.getChildren().add(node);//添加到父节点
        }
        return treeRootItem.getChildren();
    }

    public void setGetName(Function<T, String> getName) {
        this.getName = getName;
    }

    public void setGetChecked(Function<T, Boolean> getChecked) {
        this.getChecked = getChecked;
    }
}
