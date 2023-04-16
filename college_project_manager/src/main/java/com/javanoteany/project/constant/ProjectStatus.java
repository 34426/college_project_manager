package com.javanoteany.project.constant;

/**
 * @author javanoteany
 * @Date 2021-12-12
 * @Description
 * @Version 1.0
 */
public enum  ProjectStatus {
    //被废弃的              所有人都看不见 只是在数据库中可以看见
    ABANDONED(-1,"废弃"),

    //未申报（就是草稿的意思） 可以修改 可以申报 不可以结题
    NOT_DECLARED(0,"草稿"),

    //项目申报中  项目申报 不可修改 不可申报 不可以申请变更 不可结题
    PROJECT_AUDIT(1,"项目申报中"),

    //申报失败 等同草稿 可以修改 可以申报 不可以申请变更 不可以结题
    FAIL_PROJECT_AUDIT(2,"申报失败"),

    //未结题 结题之前的状态 不可修改 不可以申报 可以申请变更 可以申请结题
    NOT_CONCLUSION(3,"未结题"),

    //变更申请中  不可修改 不可申报 不可以申请变更 不可结题
    UPDATE_AUDIT(4,"变更申请中"),

    //变更申请失败 不可修改 不可以申报 可以申请变更 可以申请结题
    FAIL_UPDATE_AUDIT(5,"变更申请失败"),

    //变更中(申请变更成功)等同草稿 可以修改 需要再次申报 不可以结题
    SUCCESS_UPDATE_AUDIT(6,"变更中"),

    //申请结题中 不可以修改 不可申报 不可以申请变更 不可以结题
    CONCLUDE_AUDIT(7,"申请结题中"),

    //申请结题失败 不可修改 不可以申报 可以申请变更 可以申请结题
    FAIL_CONCLUDE_AUDIT(8,"申请结题失败"),

    //结题成功 不可修改 不可申报 不可结题
    CONCLUDED(9,"结题成功")
    ;
    private int code;

    private String name;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    ProjectStatus(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public static ProjectStatus getByName(String name){
        ProjectStatus[] values = values();
        for(ProjectStatus projectStatus : values){
            if(name.equals(projectStatus.getName())){
                return projectStatus;
            }
        }
        //默认返回未申报
        return ProjectStatus.NOT_DECLARED;
    }

    public static ProjectStatus getByCode(int code){
        ProjectStatus[] values = values();
        for(ProjectStatus projectStatus : values){
            if(code == projectStatus.getCode()){
                return projectStatus;
            }
        }
        //默认返回未申报
        return ProjectStatus.NOT_DECLARED;
    }
}
