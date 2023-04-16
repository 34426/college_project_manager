package com.javanoteany.common.query;


import java.io.Serializable;

public class Filter implements Serializable {

    private static final long serialVersionUID = -8712382358441065075L;

    /**
     * 运算符
     */
    public enum Operator {

        /** 等于 */
        eq("eq"),

        /** 不等于 */
        neq("neq"),

        /** 大于 */
        gt("gt"),

        /** 小于 */
        lt("lt"),

        /** 大于等于 */
        ge("ge"),

        /** 小于等于 */
        le("le"),

        /** 类似 */
        like("like"),

        /** 包含 */
        in("in"),

        /** 为Null */
        isNull("isNull"),

        /** 不为Null */
        notNull("notNull"),

        /**
         * 之间
         */
        between("between");

        Operator(String operator) {
            this.operator = operator;
        }

        private String operator;

        public String getOperator() {
            return operator;
        }

        public void setOperator(String operator) {
            this.operator = operator;
        }
    }

    /** 属性 */
    private String field;

    /** 运算符 */
    private Operator operator;

    /** 值 */
    /**  如果是运算符是一个between 那么value就需要两个。所以在这里就必须成多个value，但是会影响之前的数据调用方式*/
    private Object[] value;

    /**
     * 连接条件
     */
    private Logic logic;

    /**
     * 构造方法
     */
    public Filter() {
    }

    /**
     * 构造方法
     *
     * @param field
     *            属性
     * @param operator
     *            运算符
     * @param value
     *            值
     */
    public Filter(String field, Operator operator, Object ...value) {
        this.field = field;
        this.operator = operator;
        this.value = value;
    }

    /**
     * 构造方法
     * @param field 属性
     * @param operator 操作
     * @param logic or还是and
     * @param value 值 多参数
     */
    public Filter(String field, Operator operator, Logic logic,Object ...value) {
        this.field = field;
        this.operator = operator;
        this.value = value;
        this.logic = logic;
    }

    /**
     * 返回等于筛选
     *
     * @param field
     *            属性
     * @param value
     *            值
     * @param logic
     *            连接条件
     * @return 等于筛选
     */
    public static Filter eq(String field, Logic logic,Object ...value) {
        return new Filter(field, Operator.eq, logic,value);
    }

    /**
     * 返回等于筛选
     *
     * @param field
     *            属性
     * @param value
     *            值
     * @return 等于筛选
     */
    public static Filter eq(String field, Object ...value) {
        return new Filter(field, Operator.eq,value);
    }


    /**
     * 返回不等于筛选
     *
     * @param field
     *            属性
     * @param value
     *            值
     * @return 不等于筛选
     */
    public static Filter neq(String field, Object value) {
        return new Filter(field, Operator.neq, value);
    }

    /**
     * 返回大于筛选
     *
     * @param field
     *            属性
     * @param value
     *            值
     * @return 大于筛选
     */
    public static Filter gt(String field, Object value) {
        return new Filter(field, Operator.gt, value);
    }

    /**
     * 返回小于筛选
     *
     * @param field
     *            属性
     * @param value
     *            值
     * @return 小于筛选
     */
    public static Filter lt(String field, Object value) {
        return new Filter(field, Operator.lt, value);
    }

    /**
     * 返回大于等于筛选
     *
     * @param field
     *            属性
     * @param value
     *            值
     * @return 大于等于筛选
     */
    public static Filter ge(String field, Object value) {
        return new Filter(field, Operator.ge, value);
    }

    /**
     * 返回小于等于筛选
     *
     * @param field
     *            属性
     * @param value
     *            值
     * @return 小于等于筛选
     */
    public static Filter le(String field, Object value) {
        return new Filter(field, Operator.le, value);
    }

    /**
     * 返回相似筛选
     *
     * @param field
     *            属性
     * @param value
     *            值
     * @return 相似筛选
     */
    public static Filter like(String field, Object value) {
        return new Filter(field, Operator.like, value);
    }

    /**
     * 返回包含筛选
     *
     * @param field
     *            属性
     * @param value
     *            值
     * @return 包含筛选
     */
    public static Filter in(String field, Object value) {
        return new Filter(field, Operator.in, value);
    }

    /**
     * 返回为Null筛选
     *
     * @param field
     *            属性
     * @return 为Null筛选
     */
    public static Filter isNull(String field) {
        return new Filter(field, Operator.isNull, null);
    }

    /**
     * 返回不为Null筛选
     *
     * @param field
     *            属性
     * @return 不为Null筛选
     */
    public static Filter isNotNull(String field) {
        return new Filter(field, Operator.isNull, null);
    }

    /**
     * 获取属性
     *
     * @return 属性
     */
    public String getField() {
        return field;
    }

    /**
     * 设置属性
     *
     * @param field
     *            属性
     */
    public void setField(String field) {
        this.field = field;
    }

    /**
     * 获取运算符
     *
     * @return 运算符
     */
    public Operator getOperator() {
        return operator;
    }

    /**
     * 设置运算符
     *
     * @param operator
     *            运算符
     */
    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    /**
     * 获取值
     *
     * @return 值
     */
    public Object getValue() {
        if (value != null && value.length == 1) {
            return value[0];
        } else {
            throw new RuntimeException("取值异常，当前查询不支持存在多个值");
        }
    }
    /**
     * 获取值
     *
     * @return 值
     */
    public Object[] getValues() {
        return value;
    }


    /**
     * 设置值
     *
     * @param value
     *            值
     */
    public void setValue(Object ...value) {
        this.value = value;
    }

    /**
     * 连接条件
     * @return
     */
    public Logic getLogic() {
        return logic;
    }

    public void setLogic(Logic logic) {
        this.logic = logic;
    }
}
