package com.mmall.controller;

import com.mmall.common.JsonData;
import com.mmall.dao.SysAclModuleMapper;
import com.mmall.exception.PermissionException;
import com.mmall.model.SysAclModule;
import com.mmall.param.TestVo;
import com.mmall.util.ApplicationContextHelper;
import com.mmall.util.BeanValidator;
import com.mmall.util.JsonMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @Description：
 * @Auther： libo
 * @date： 2018/11/21:08:44
 */
@Controller
@RequestMapping("/test")
@Slf4j
public class TestController {

    @RequestMapping("/hello.json")
    @ResponseBody
    public JsonData hello() {
        log.info("hello");
        throw new RuntimeException("test exception");
        // throw new PermissionException("test exception");
        // return JsonData.success("hello permission");
    }

    @RequestMapping("/validate.json")
    @ResponseBody
    public JsonData validate(TestVo vo) {
        log.info("validate");
        try {
            Map<String, String> map = BeanValidator.validateObject(vo);
            if (map != null && map.entrySet().size() > 0) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    log.info("{}->{}", entry.getKey(), entry.getValue());
                }
            }
        } catch (Exception e) {

        }
        return JsonData.success("test validate");
    }

    @RequestMapping("/applicationContextHelper.json")
    @ResponseBody
    public JsonData applicationContextHelper() {
        log.info("applicationContextHelper");
        SysAclModuleMapper aclModuleMapper = ApplicationContextHelper.popBean(SysAclModuleMapper.class);
        SysAclModule aclModule = aclModuleMapper.selectByPrimaryKey(1);
        log.info(JsonMapper.obj2String(aclModule));
        return JsonData.success("test applicationContextHelper");
    }
}
