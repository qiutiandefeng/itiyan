package com.yfhl.util;

public enum ResultCode
{
    SUCCESS("1", "操作成功"),
    
    LOGIN_SUCCESS("1","登录成功"),

    USER_INFO("1","个人中心显示"),

    USER_CARD_SUCCESS("1","身份证验证通过"),

    UPDATE_TOKEN_SUCCESS("1","获取Token显示"),

    GOOD_CART_SUCCESS("1","商品加入购物车"),

    GOODS_COUPONINFO("1","优惠券显示"),

    ORDER_CANCEL_SUCCESS("1","取消订单成功"),

    ORDER_VIEW_SUCCESS("1","订单详情显示"),

    GOODS_INFO_SUCCESS("1","商品详情显示"),

    FEE_INFO_SUCCESS("1","物流费用结算"),

    ORDER_INFO_SUCCESS("1","有效订单显示"),

    GOODS_RECOMMEND_SUCCESS("1","推荐商品显示"),

    USERINFO_INTEGRAL("1","积分显示"),

    ADDRESS_EDIT_POST("1","单个收货地址显示"),

    ADDRESS_EDIT_POST_ALL("1","收货地址显示"),

    ADDRESS_SAVE_SUCCESS("1","新增收货地址成功"),

    ADDRESS_EDIT_SUCCESS("1","编辑收货地址成功"),

    ADDRESS_DELETE_SUCCESS("1","删除地址成功"),

    ADDRESS_DEFAULT_SUCCESS("1","设置地址成功"),

    ADDRESS_DELETE_ERROR("0","删除地址失败"),

    GOOD_TUANGOU_ERROR("0","团购库存不足，请重新选择数量"),

    GOOD_KUCUN_ERROR("0","商品库存不足，请重新选择数量"),

    GOOD_CART_NO("1","购物车信息为空"),

    ADVERT_SUCCESS("1","广告栏显示"),

    ERROR("0", "操作失败"),
    
    SYSTEM_ERROR("2000", "系統错误，操作失败"),
    
    USER_NAME_VALIDATE_FAILURE("2101", "用户名不符合名称要求"),
    
    PASSWORD_VALIDATE_FAILURE("2102", "密码不符合复杂度要求"),
    
    REGISTERED_ACCOUNT("2103", "当前手机号已被注册"),
    
    FREQUENTLY_SEND_VERIFICATION_CODE("2104", "获取验证码太频繁，获取失败"),
    
    VERIFICATION_CODE_ERROR("2105", "验证码错误"),
    
    USER_NAME_OR_PASSWORD_ERROR("2106", "用户名或密码错误"),
    
    OLD_PASSWORD_ERROR("2107", "原密码错误"),
    
    USER_NAME_OR_VERIFICATION_CODE_ERROR("2108", "用户名或验证码错误"),
    
    CURRENT_ACCOUNT_NOT_LOGIN("2109", "当前账号尚未登录"), 
    
    REPEATED_SET_USER_NAME("2110", "用户名已设置，不允许重复设置"),
    
    ILLEGAL_REQUEST("2111", "非法请求"),
    
    ILLEGAL_REQUEST_ARGUMENT("2112", "非法的输入参数"),
    
    UNAUTHORIZED_OPERATION("2113", "未受权的操作"),
    
    OBJECT_NOT_EXIST("2114", "请求的对象不存在"),
    
    TELEPHOTO_NULL_AND_ERROR("2115", "请正确填写手机号");

            
    private String code;
    
    private String desc;
    
    private ResultCode(String code, String desc)
    {
        this.code = code;
        this.desc = desc;
    }

    public String getCode()
    {
        return code;
    }

    public String getDesc()
    {
        return desc;
    }
    
}
