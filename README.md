# 工具

## 校验工具-validator

## Json转换工具-jackson convert

## 获取Spring上下文-applicationContext

## Http请求前后监听-interceptor

DTO是用来做适配用的。



# MyBatis-Mapper.XML

## 模糊查询

```xml
<select id="getChildDeptListByLevel" resultMap="BaseResultMap">
    select
    <include refid="Base_Column_List" />
    from sys_dept
    WHERE level like #{level} || '.%' -- level like '0.%'
</select>
```

## 批量更新

```xml
<update id="batchUpdateLevel" parameterType="list">
    <foreach collection="sysDeptList" item="sysDept" separator=";">
        UPDATE sys_dept
        SET level = #{dept.level}
        WHERE id = #{dept.id}
    </foreach>
</update>
```

# Lombok

## @Builder和@NoArgsConstructor冲突

> [*@Builder*与*@NoArgsConstructor* | *Lombok* - N!CE波 - 博客园](https://www.baidu.com/link?url=aLHwIX1c2Ig2c-Ov4Tfxlni1uGeF3N_uqpD5gKcNWcBGnnreMaFQIIdy5Ks8ixInMsAvCo_ljhF7nbLFM31eOa&wd=&eqid=d531bd3a00001e81000000065bf5620d)
>
> [*Lombok@Builder*和*@NoArgsConstructor*冲突 - 编程之路 - Segment...](https://www.baidu.com/link?url=EMpP0owriCRvISKN7AHK6IeU1L-T5_xVBDLq6rzl_6D9jTTQS0gp80lGcL9V0Sb2XJo46vAfUS9FVyO05mLGPK&wd=&eqid=d531bd3a00001e81000000065bf5620d)

## @Data用在子类上要求父类必须有无参构造器

> [lombok踩坑与思考](https://www.cnblogs.com/wuyuegb2312/p/9750462.html)

![](https://i.loli.net/2018/11/21/5bf56566594b5.jpg)

# 前端

## ACE

> [Ace模板地址（有时会打不开）](http://code.google.com/p/ace-engine/wiki/AceTemplate)
>
> [Ace英文官网](http://wrapbootstrap.com/preview/WB0B30DGR)
>
> [Ace模板功能介绍地址](http://www.cnblogs.com/txw1958/p/Ace-Responsive-Admin-Template.html)
>
> [Ace Admin前端框架笔记一概要与布局介绍](https://blog.csdn.net/uotail/article/details/80475152)
>
> [后台管理模板ACE | 大牛笔记](http://www.daniubiji.cn/archives/408)

Ace简介：Ace 是一个轻量、功能丰富、HTML5、响应式、支持手机及平板电脑上浏览的管理后台模板，基于CSS框架Bootstrap制作，Bootstrap版本更新至 3.0，Ace – Responsive Admin Template当前最新版！

## 插件

### zTree

### listbox

# MD5加密

```java
package com.mmall.util;

import lombok.extern.slf4j.Slf4j;

import java.security.MessageDigest;

/**
 * @Description：
 * @Auther： libo
 * @date： 2018/11/22:11:37
 */
@Slf4j
public class MD5Util {

    public final static String encrypt(String s){
        char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
        try {
            byte[] btInput = s.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            log.error("generate md5 error, {}", s, e);
            return null;
        }
    }
}
```

# Spring

## 转发与重定向

> [java.lang.IllegalStateException: Cannot forward after ... - CSDN博客](https://blog.csdn.net/lewky_liu/article/details/79845655)

## @RequestParam

> [*spring*MVC*接口*接受前端传递参数*数据类型*总结 - 平凡之..._CSDN博客](https://www.baidu.com/link?url=Q2yQl_FPZPWezMIdb2C62iRvWtWm7fM6mt6ykBRalyXdiDTci2nVa1RqijwIJZF_VOBAcFv7GL_REhI1S0SlA2YGHd5cI6INomDWlPHjVpG&wd=&eqid=ee943f76000425ae000000065bf7c508)
>
> [关于*@RequestParam*绑定的*数据类型* - 码农的幸福生活 - CSDN博客](https://www.baidu.com/link?url=tdwixhDqHUVmjX5ADmaKLN4YmUNgZXUlapGFpG0iWstZHMpynusraiuTSRF9MJdqbHB-jBsXgIiveJVNn0B1fNm5xZFuYoNVoayXUL_gjOW&wd=&eqid=fb036b4a00049c71000000065bf7c62f)

1. @RequestParam绑定对象类型，没有问题；
2. @RequestParam绑定基本数据类型，若required属性为true（默认为true）也没有问题；
3. @RequestParam绑定基本数据类型，若required属性为false（默认为true），且设置了defaultValue属性，没有问题；
4. @RequestParam绑定基本数据类型，若required属性为false（默认为true），且没有设置defaultValue属性，则当没有传该参数时，会报500（因为无法将null赋值给基本数据类型）