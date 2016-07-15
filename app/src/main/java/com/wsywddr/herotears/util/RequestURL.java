package com.wsywddr.herotears.util;

public class RequestURL {

    //测试 host 192.168.1.253    http://www.citybao.com
//    public static  String HOST = "http://www.citybao.com";

    //本地测试服 可以外网访问
    //public static  String HOST = "http://local-server.citybao.com";

    //预发布测试服 可以外网访问
//    public static  String HOST = "http://remote-server.citybao.com";

    //配置host是测试 不配置host是正式
    public static  String HOST = "http://server.citybao.com";

    public static String API_LOGIN = HOST + "/api.php?m=User&c=Member&a=login";

    //找回密码发送验证码
    public static String API_SEND_FORGET_PWD_CODE =HOST +"/api.php?m=User&c=Member&a=sendVerifyCodeForPassword";

    //发送验证码
    public static String API_SEND_CODE =HOST +"/api.php?m=User&c=Member&a=sendVerifyCode";

    //验证验证码
    public static String API_CHECK_FORGET_PWD_CODE =HOST +"/api.php?m=User&c=Member&a=checkVerifyCode";

    //注册用户
    public static String API_REGIST = HOST + "/api.php?m=User&c=Member&a=register";

    //找回密码
    public static String API_REGET_PWD = HOST + "/api.php?m=User&c=Member&a=forgotPassword";

    //设置用户登录密码
    public static String API_SET_PWD = HOST + "/api.php?m=User&c=Member&a=setPassword";

    //查询所有订单
    public static String API_FIND_ALL_ORDERS = HOST +"/api.php?m=Order&c=Order&a=findAll";

    //查询各状态订单数量
    public static String API_FIND_STATUS_ORDER_COUNT=HOST+"/api.php?m=Order&c=OrderStatus&a=get_status_total";

    //更改订单状态
    public static String API_CHANGE_ORDER_STATUS=HOST+"/api.php?m=Order&c=Order&a=changeOrder";

    //获取钱包信息
    public static String API_WALLET_INFO = HOST + "/api.php?m=Wallet&c=Wallet&a=getInfo";

    //实名认证
    public static String API_WALLET_VERITIFY = HOST + "/api.php?m=Wallet&c=Wallet&a=setR";

    //获取实名认证
    public static String API_WALLET_GETR = HOST + "/api.php?m=Wallet&c=Wallet&a=getR";

    //获取绑定银行卡
    public static String API_WALLET_CARDLIST = HOST + "/api.php?m=Wallet&c=Wallet&a=getBlist";

    //添加银行卡
    public static String API_WALLET_ADD_CARD = HOST + "/api.php?m=Wallet&c=Wallet&a=addB";

    //删除银行卡
    public static String API_WALLET_DEL_CARD = HOST + "/api.php?m=Wallet&c=Wallet&a=deleteB";

    //获取钱包流水
    public static String API_WALLET_HISTORY = HOST + "/api.php?m=Wallet&c=Wallet&a=payLog";

    //验证支付密码
    public static String API_WALLET_CHECK_PAYPWD = HOST + "/api.php?m=Wallet&c=Wallet&a=changepaypwd";

    //设置支付密码
    public static String API_WALLET_SET_PAYPWD = HOST + "/api.php?m=Wallet&c=Wallet&a=setpaypwd";

    //提现
    public static String API_WALLET_OUT_MONEY = HOST + "/api.php?m=Order&c=Order&a=add";

    //获取七牛上传凭证
    public static String API_GET_QNTOKEN =HOST +"/api.php?m=Common&c=Qiniu&a=getToken";

    //获取融云凭证
    public static String API_GET_RONGTOKEN =HOST +"/api.php?m=Common&c=RongCloud&a=getToken";

    //获取城市区域
    public static String API_GET_CITY_AREA = HOST+"/api.php?m=Home&c=Area&a=get_area_by_appid";

    //发布内容
    public static String API_CONTENT_ADD = HOST+"/api.php?m=Classified&c=Content&a=content_add";

    //商品分类
    public static String API_GET_GOODS_CLASS = HOST +"/api.php?m=Classified&c=Category&a=get_list";

    //查询订单详情
    public static String API_GET_ORDER_DETAIL = HOST +"/api.php?m=Order&c=Order&a=orderInfo";

    //商家认证申请
    public static String API_BUSINESS_APPLY = HOST +"/api.php?m=User&c=Business&a=sj_shenqing";

    //获取商家信息
    public static String API_BUSINESS_INFO = "http://115.28.95.230/appjk/";

    //获取商家发布的所有信息
    public static String API_PRODUCT_LISTS = HOST +"/api.php?m=Classified&c=Content&a=content_search";

    //设置商家首页背景图
    public static String API_BUSINESS_HOMEBG = HOST +"/api.php?m=User&c=Business&a=sj_siteimg";

    //得到商家管理信息
    public static String API_BUSINESS_MANAGE = HOST +"/api.php?m=User&c=Business&a=sj_index";

    //得到商家被关注人数
    public static String API_BUSINESS_ATTENTION = HOST +"/api.php?m=User&c=Business&a=sj_getfollow";

    //设置商家头像
    public static String API_BUSINESS_LOGO = HOST +"/api.php?m=User&c=Member&a=setAvatar";

    //设置商家简称
    public static String API_BUSINESS_NAME = HOST +"/api.php?m=User&c=Member&a=setInfo";

    //获取商家简称
    public static String API_GET_BUSINESS_NAME = HOST +"/api.php?m=User&c=Member&a=getInfo";

    //设置首页推荐
    public static String API_PRODUCT_ISTOP = HOST +"/api.php?m=Classified&c=Content&a=content_istop";

    //产品删除
    public static String API_PRODUCT_DEL = HOST +"/api.php?m=Classified&c=Content&a=content_del";

    //产品角标
    public static String API_PRODUCT_COUNT = HOST +"/api.php?m=Classified&c=Content&a=content_count";

    //设置产品上下架
    public static String API_PRODUCT_PUTAWAY = HOST +"/api.php?m=Classified&c=Mine&a=set_putaway";

    //获取发布的模板标签
    public static String API_GET_POST_TYPE = HOST +"/api.php?m=Classified&c=Category&a=get_post_type";

    //修改发布的内容
    public static String API_UPDATE_CONTENT =HOST + "/api.php?m=Classified&c=Content&a=content_update";

    //获取单条内容详情
    public static String API_GET_CONTENT_DETAIL =HOST + "/api.php?m=Classified&c=Mine&a=get_post_detail";

    //获取用户信息
    public static String API_GET_USER_INFO =HOST + "/api.php?m=User&c=Member&a=getUser";

    //得到商家推送记录
    public static String API_PUSH_HISTORY = HOST +"/api.php?m=User&c=Business&a=sj_push_list";

    //设置推送信息状态
    public static String API_PUSH_STATUS = HOST +"/api.php?m=User&c=Business&a=sj_push_status";

    //删除推送信息
    public static String API_PUSH_DEL = HOST +"/api.php?m=User&c=Business&a=sj_push_delete";

    //保存推送信息
    public static String API_PUSH_SAVE = HOST +"/api.php?m=User&c=Business&a=sj_push";

    //编辑推送信息
    public static String API_PUSH_EDIT = HOST +"/api.php?m=User&c=Business&a=sj_push_edit";

    //获取商家类别
    public static String API_GET_BUSINESS_TYPE =HOST + "/api.php?m=User&c=Business&a=sj_type_getlist";

    //获取商圈
    public static String API_GET_BUSINESS_QUAN =HOST + "/api.php?m=User&c=Business&a=sq_getlist";

}
