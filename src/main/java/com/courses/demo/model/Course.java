package com.courses.demo.model;

import javax.persistence.*;

@Entity(name = "crs_course_instances")
public class Course {

  @Id
  private Long id;
  private String name;
  private String description;
  private String status;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinTable(name = "crs_course_templates", joinColumns = @JoinColumn(name = "id"))
  private CourseTemplate courseTemplate;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public CourseTemplate getCourseTemplateId() {
    return courseTemplate;
  }

  public void setCourseTemplateId(CourseTemplate c) {
    this.courseTemplate = courseTemplate;
  }
}
