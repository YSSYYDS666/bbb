package com.pt.vx.config;


import com.pt.vx.domain.BirthDay;
import com.pt.vx.domain.FunctionConfig;
import com.pt.vx.domain.User;

import java.util.ArrayList;
import java.util.List;

/**
 * PT微信公众号模板消息推送 2.4.0
 * BiliBili: 今天pt健康了吗
 * 成功了的小伙伴，欢迎来点赞投币评论哦~
 * 国庆节快乐！
 *               -- 2022/10/1
 *
 * 注意：改下面的信息的时候，细心一点。
 * 有双引号("")的不要把双引号给丢了,标点符号记得用英文输入法！！！
 *               -- 2022/10/5
 */
public class AllConfig {
    public static final String cron = "*/10 * * * * ?"; //分别代表：秒、分、时、日、月、星期
    public static final String VxAppId = "wx9b14688b45126b81";
    public static final String VxAppSecret = "f1455cf18330fbdc0a7f004d77299fda";
    public static final String WeatherKey = "83dee58abe2aba0271e18ce08bf813ea";
    public static final String WeatherKey_HeFeng = "9860b01483f641dbbadb5c8fef28876b";

    //下列所有填写的  true 为开启， false 为不开启 ，#XXXXXX是颜色16进制HEX码（不知道颜色16进制HEX码可以百度）
    //系统开关
    public static final boolean OPEN_MESSAGE_SPLIT = true; //是否开启消息分裂（大于100字的消息会被分裂成多个,如tianGou超过了一百个字的话：{{tianGou.DATA}}{{tianGou1.DATA}}））
    public static final boolean OPEN_WEATHER_NOW = false; //切换天气类型为实时（false为天气预报，true为实时天气）
    public static final boolean OPEN_HF_WEATHER = false; //切换天气源为和风天气（目前只支持天气预报）
    public static final boolean OPEN_MASTER_MODEL = false; //是否开启主人模式。开启后，后面的用户只会收到第一个用户的内容。
    public static final boolean OPEN_RANDOM_COLOR = true; //是否开启随机消息颜色
    public static final String[] random_colors = {"#FFCCCC", "#33A1C9", "#DC143C","#FF0000","#6B8E23","#236B8E","#FF7F00"}; //参与随机的颜色,颜色为颜色HEX码（不知道可以百度）


    //基本类型消息
    public static final FunctionConfig open_name = new FunctionConfig(true,"#FFCCCC");//是否开启称呼
    public static final FunctionConfig open_birthDay = new FunctionConfig(true,"#FFCCCC"); //是否开启日期计算
    public static final FunctionConfig open_weather = new FunctionConfig(true,"#33A1C9"); //是否开启天气预报
    public static final FunctionConfig open_other_info= new FunctionConfig(true,"#DC143C"); //是否开启额外信息（需要开启日期计算或天气预报）
    public static final String info_birthday = "生日快乐！！！"; //第一个日期倒计时到0天的时候展示的额外信息
    public static final String info_birthday2 = "周年快乐！！！"; //第三个日期倒计时到0天的时候展示的额外信息
    public static final String info_weather_rain = "出门记得带伞哦~"; //天气预报有雨的时候展示的额外信息
    public static final String info_weather_temperature_0 = "温度过低，加厚加厚！！！"; //温度≤0的时候展示的额外信息
    public static final String info_weather_temperature_10 = "温度很低，多穿点衣服哦！"; //温度≤10的时候展示的额外信息
    public static final String info_weather_temperature_20 = "温度有点低，注意别着凉啦~"; //温度≤20的时候展示的额外信息
    public static final String info_weather_prefix_day = "白天"; //白天天气的前缀，比如温度≤0的时候就会展示为： 白天温度过低，加厚加厚！！！
    public static final String info_weather_prefix_night = "晚上"; //晚上天气的前缀
    public static final String info_weather_prefix_now = "现在"; //现在天气的前缀


    //额外类型消息
    public static final FunctionConfig open_history_today = new FunctionConfig(false,"#FF7F00"); //是否开启历史上的今天(暂时不可用)
    public static final FunctionConfig open_qinghua = new FunctionConfig(true,"#FF7F00"); //是否开启情话一句
    public static final FunctionConfig open_dongman = new FunctionConfig(false,"#FF7F00"); //是否开启动漫台词(暂时不可用)
    public static final FunctionConfig open_tiangou = new FunctionConfig(false,"#FF7F00"); //是否开启舔狗日记
    public static final FunctionConfig open_world_read = new FunctionConfig(false,"#FF7F00"); //是否开启世界新闻
    public static final FunctionConfig open_random_read = new FunctionConfig(false,"#FF7F00"); //是否开启随机短句
    public static final FunctionConfig open_wozairenjian = new FunctionConfig(true,"#FF7F00"); //是否开启散文集我在人间凑日子
    public static final FunctionConfig open_poetry = new FunctionConfig(false,"#FF7F00"); //是否开启随机诗句(暂时不可用)
    public static final FunctionConfig open_english = new FunctionConfig(false,"#FF7F00"); //是否开启每日英语(暂时不可用)
    public static final FunctionConfig open_miyu = new FunctionConfig(false,"#FF7F00"); //是否开启谜语(暂时不可用)
    public static final FunctionConfig open_horoscope= new FunctionConfig(false,"#FF7F00"); //是否开启星座解析(只计算第一个birthDay的星座)(暂时不可用)
    public static final FunctionConfig random_module = new FunctionConfig(false,"#FF7F00"); //随机一个开启了的额外类型消息(开启以后，只会推送随机的)

    private static void init(){
        //如果要多个人的话，就复制这个一遍，然后填写里面的内容。这里默认两个人,大伙应该是两个人吧（笑）
        //如果开启了master模式，除第一个用户外，其他用户只需要填写微信号
        //要计算几个日期，就写几个new BirthDay,第一个在模板中是{{birthDay.DATA}}，第二个是{{birthDay1.DATA}}，第三个是{{birthDay2.DATA}}以此类推
        //  注意：日期里面的数字，填正常的数字就行了.比如1就是1，不要填01
        //  注意：每个用户信息的最后一项不需要加逗号！！！
        userList.add(getUser(
                "o_jgF6S-eG7mZk0alfNWQgv13Osk", //扫码关注你的测试号以后，测试平台会出现TA的微信号
                "Z2ncgxip1YRcd4CiwXbCoxeJWNWloAgnpdeZNwyEJ74", //要给这个人发送的模板ID
                "帅哥", //咋称呼这个人
                "河南省洛阳市洛宁县赵村镇大许村", //这个人的详细地址
                "洛宁", //这个人在的城市
                new BirthDay(2004,1,26,true,false), //分别代表年、月、日、是否是农历(true为农历、false为公历)、是否统计天数(true为统计，false为倒计时)
                new BirthDay(2003,8,29,true,false),
                new BirthDay(2018,10,29,false,false),
                new BirthDay(2018,10,29,false,true)
        ));

        userList.add(getUser(
                "o_jgF6Xq3RQe9l5w1BO8b1l0PfKM", //扫码关注你的测试号以后，测试平台会出现TA的微信号
                "Z2ncgxip1YRcd4CiwXbCoxeJWNWloAgnpdeZNwyEJ74", //要给这个人发送的模板ID
                "小蔡宝贝", //咋称呼这个人
                "河南省洛阳市洛宁县长水乡西寨村", //这个人的详细地址
                "洛宁", //这个人在的城市
                new BirthDay(2004,1,26,true,false), //分别代表年、月、日、是否是农历(true为农历、false为公历)、是否统计天数(true为统计，false为倒计时)
                new BirthDay(2003,8,29,true,false),
                new BirthDay(2018,10,29,false,false),
                new BirthDay(2018,10,29,false,true)
        ));



    }

    public static final List<User> userList = new ArrayList<>();
    static {
        init();
    }


    private static User getUser(String vx, String templateId, String username, String address, String city, BirthDay... birthDays){
        User user=new User();
        user.setVx(vx);
        user.setUserName(username);
        user.setBirthDays(birthDays);
        user.setAddress(address);
        user.setCity(city);
        user.setTemplateId(templateId);
        return user;
    }
    private static User getUser(String vx, String templateId, String username, BirthDay... birthDays){
        return getUser(vx,templateId,username,null,null,birthDays);
    }
    private static User getUser(String vx, String templateId, BirthDay... birthDays){
        return getUser(vx,templateId,null,null,null,birthDays);
    }
    private static User getUser(String vx,BirthDay... birthDays){
        return getUser(vx,null,null,null,null,birthDays);
    }

}
