package com.joe.chapter031.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@Data
@ApiModel("用户任务domain") //用对象来接收参数,用在post创建的时候，使用@RequestBody这样的场景
public class Task {

    @ApiModelProperty(value = "任务id", required = true, dataType = "string") //描述一个model的属性
    private String taskId;

    @ApiModelProperty(value = "任务名称", dataType = "string")
    private String taskName;

}
