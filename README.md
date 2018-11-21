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

