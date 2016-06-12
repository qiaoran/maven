package com.system.hrSystem.entiy;

import java.io.Serializable;
import java.util.Date;

public class Job implements Serializable {
    private Long id;	//ӦƸ��Ա���
    private String name;//ӦƸ��Ա����
    private Byte sex;	//�Ա�
    private Integer age;//����
    private String job;	//ְλ
    private String specialty;//��ѧרҵ
    private String experience;//��������
    private String studyeffort;//ѧ��
    private String school;	//��ҵѧУ
    private String tel;		//�绰����
    private String email;	//Email��ַ
    private Date createtime;//����ʱ��
    private String content;	//��ϸ����
    private Byte isstock;	//�Ƿ����

    public Job(Long id,String name, Byte sex, Integer age, String job, String specialty, String experience, String studyeffort, String school, String tel, String email, Date createtime, String content, Byte isstock) {
        this.id=id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.job = job;
        this.specialty = specialty;
        this.experience = experience;
        this.studyeffort = studyeffort;
        this.school = school;
        this.tel = tel;
        this.email = email;
        this.createtime = createtime;
        this.content = content;
        this.isstock = isstock;
    }
    public Job() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byte getSex() {
        return this.sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getJob() {
        return this.job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getSpecialty() {
        return this.specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getExperience() {
        return this.experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getStudyeffort() {
        return this.studyeffort;
    }

    public void setStudyeffort(String studyeffort) {
        this.studyeffort = studyeffort;
    }

    public String getSchool() {
        return this.school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getTel() {
        return this.tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreatetime() {
        return this.createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Byte getIsstock() {
        return this.isstock;
    }

    public void setIsstock(Byte isstock) {
        this.isstock = isstock;
    }

    public String toString() {
        StringBuffer toStr = new StringBuffer();
        toStr.append("[Job] = [\n");
        toStr.append("    id = " + this.id + ";\n");
        toStr.append("    name = " + this.name + ";\n");
        toStr.append("    sex = " + this.sex + ";\n");
        toStr.append("    age = " + this.age + ";\n");
        toStr.append("    job = " + this.job + ";\n");
        toStr.append("    specialty = " + this.specialty + ";\n");
        toStr.append("    experience = " + this.experience + ";\n");
        toStr.append("    studyeffort = " + this.studyeffort + ";\n");
        toStr.append("    school = " + this.school + ";\n");
        toStr.append("    tel = " + this.tel + ";\n");
        toStr.append("    email = " + this.email + ";\n");
        toStr.append("    createtime = " + this.createtime+ ";\n");
        toStr.append("    content = " + this.content+ ";\n");
        toStr.append("    isstock = " + this.isstock + ";\n");
        toStr.append("    ];\n");
        return toStr.toString();
    }

}
