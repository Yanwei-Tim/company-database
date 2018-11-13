package com.huntkey.rx.purchase.common.enums;

/**
 * Created by clarkzhao on 2017/10/26.
 *
 * @author clarkzhao
 * @date 2017/10/26
 */
public enum ErrorMessage {
    _80000(80000, "调用ORM查询接口出现异常"),
    _80001(80001, "对应部门不存在"),
    _80002(80002, "保存部门对象失败"),
    _80003(80003, "对应伙伴不存在"),
    _80004(80004, "对应员工对象不存在"),
    _80040(80040, "没有对应的职位列表"),
    _80041(80041, "保存职位定义异常"),
    _80042(80042, "删除职位定义异常"),
    _80005(80005, "部门对应的负责人不存在"),
    _80006(80006, "对应岗位不存在"),
    _80060(80060, "对应部门记录查出多条"),
    _80061(80061, "更新部门对象失败"),
    _89999(89999, ""),
    _88001(88001, ""),
    _88002(88002, ""),
    _88003(88003, ""),
    
    _88006(88006, "部门异动单数据异常"),
    _88008(88008, "同一层级编码查出多条节点数据"),
    _88004(88004, "部门异动单数据不存在"),
    _88005(88005, "部门异动单数据不存在新增的节点"),
    _88007(88007, "部门异动单起始部门不存在"),
    _88009(88009, "部门异动单状态更新异常"),

    _88020(88020, "未查询到任何有效的部门调动单据"),
    _88021(88021, "未查询到任何有效的部门调动单据-异动列表数据"),
    _88022(88022, "未查询到任何有效的部门类对象"),
    _88023(88023, "加载待调动部门列表异常"),
    _88024(88024, "保存部门调动单异常"),
    _88025(88025, "修改部门调动单异常"),
    _88026(88026, "删除部门结构异动单-异动列表-异常"),

    _80030(80030, "未查询到岗位信息"),
    _80031(80031, "所选岗位有待审单据"),
    _80032(80032, "所选岗位无待审单据"),
    _80033(80033, "传入的岗位新增单据信息为空"),
    _80034(80034, "传入的岗位修改单据信息为空"),


    _80050(80050, "职位调整单单据编号生成失败"),
    _80051(80051, "职位编码生成失败"),
    _80052(80052, "职员入职单单据编号生成失败"),
    _80053(80053, "员工工号生成失败"),
    _80054(80054, "职员档案变更单单据编号生成失败"),
    _80055(80055, "职位名称重复"),
    _80056(80056, "职员入职单保存失败"),
    _80057(80057, "职员入职单更新失败"),
    _80062(80062, "修改离职明细记录数据失败");
	
    private int code;

    private String msg;

    ErrorMessage(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
