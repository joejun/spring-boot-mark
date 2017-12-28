package com.joe.chapter031.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import java.util.List;

@Data
@ApiModel("用户实体domain") //用对象来接收参数,用在post创建的时候，使用@RequestBody这样的场景
public class User {

    @ApiModelProperty(value = "主键", dataType = "long")
    private Long id;

    @ApiModelProperty(value = "真实姓名", required = true, dataType = "string") //描述一个model的属性
    @NotBlank(message = "真实姓名不能为空")
    @Length(max = 128, message = "真实姓名最大128位")
    private String name;

    @ApiModelProperty(value = "年龄", dataType = "integer")
    private Integer age;

    @ApiModelProperty(value = "任务", dataType = "Task")
    private List<Task> tasks;

}
