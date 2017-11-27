package com.generate.domain;

import javax.persistence.*;

@Entity
@Table(name = "t_batch")
public class Batch {
    @Id
    private String id;

    private String templateId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }
}