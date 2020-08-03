package ${package.Controller};


import org.springframework.web.bind.annotation.RequestMapping;
<#--<#if swagger2>-->
<#--import io.swagger.annotations.Api;-->
<#--import io.swagger.annotations.ApiOperation;-->
<#--import lombok.extern.slf4j.Slf4j;-->
<#--import com.topsun.common.constant.GlobalConstant;-->
<#--</#if>-->
<#if restControllerStyle>
import org.springframework.web.bind.annotation.RestController;
<#elseif cfg.extControllerStyle>
<#--import org.springframework.beans.factory.annotation.Autowired;-->
<#--import org.springframework.web.bind.annotation.PostMapping;-->
<#--import org.springframework.web.bind.annotation.RequestBody;-->
<#--import com.baomidou.mybatisplus.extension.plugins.pagination.Page;-->
<#--import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;-->
import ${package.Entity}.${entity};
import ${package.Service}.${table.serviceName};
import java.util.List;
<#else>
import org.springframework.stereotype.Controller;
</#if>
<#if superControllerClassPackage??>
import ${superControllerClassPackage};
</#if>

/**
 * <p>
 * ${table.comment!} 前端控制器
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if swagger2>
<#--@Api(value = "${entity}控制器")-->
@Slf4j
</#if>
@RestController
@RequestMapping("<#if package.ModuleName??>/${package.ModuleName}</#if>/${entity?uncap_first}")
<#if kotlin>
class ${table.controllerName}<#if superControllerClass??> : ${superControllerClass}()</#if>
<#else>
<#if superControllerClass??>
public class ${table.controllerName} extends ${superControllerClass} {
<#else>
public class ${table.controllerName} {
</#if>

}
</#if>
