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