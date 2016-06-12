package com.system.hrSystem.entiy;

import java.io.Serializable;
import java.util.Date;

/** ��ѵ */
public class Educate implements Serializable {
    private Long id;		//��ѵ���
    private String name;	//��ѵ����
    private String purpose;	//��ѵĿ��
    private Date begintime;	//��ѵ��ʼʱ��
    private Date endtime;	//��ѵ����ʱ��
    private String datum;	//��ѵ����
    private String teacher;	//��ѵ��ʦ
    private String student;	//��ѵ��Ա
    private Date createtime;//����ʱ��
    private Byte educate;	//��ѵ�Ƿ����
    private String effect;	//��ѵЧ��
    private String summarize;//�ܽ� 

    public Educate(String name, String purpose, Date begintime, Date endtime, String datum, String teacher, String student, Date createtime, Byte educate,String effect, String summarize) {
        this.name = name;
        this.purpose = purpose;
        this.begintime = begintime;
        this.endtime = endtime;
        this.datum = datum;
        this.teacher = teacher;
        this.student = student;
        this.createtime = createtime;
        this.educate=educate;
        this.effect = effect;
        this.summarize = summarize;
    }

    /** default constructor */
    public Educate() {
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

    public String getPurpose() {
        return this.purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public Date getBegintime() {
        return this.begintime;
    }

    public void setBegintime(Date begintime) {
        this.begintime = begintime;
    }

    public Date getEndtime() {
        return this.endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public String getDatum() {
        return this.datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public String getTeacher() {
        return this.teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getStudent() {
        return this.student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public Date getCreatetime() {
        return this.createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getEffect() {
        return this.effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public String getSummarize() {
        return this.summarize;
    }

    public void setSummarize(String summarize) {
        this.summarize = summarize;
    }

    public String toString() {
        StringBuffer toStr = new StringBuffer();
        toStr.append("[Educate] = [\n");
        toStr.append("    id = " + this.id + ";\n");
        toStr.append("    name = " + this.name + ";\n");
        toStr.append("    begintime = " + this.begintime+ ";\n");
        toStr.append("    endtime = " + this.endtime+ ";\n");
        toStr.append("    createtime = " + this.createtime+ ";\n");
        toStr.append("    purpose = " + this.purpose + ";\n");
        toStr.append("    datum = " + this.datum + ";\n");
        toStr.append("    teacher = " + this.teacher + ";\n");
        toStr.append("    student = " + this.student + ";\n");
        toStr.append("    educate = " + this.educate+ ";\n");
        toStr.append("    effect = " + this.effect + ";\n");
        toStr.append("    summarize = " + this.summarize + ";\n");
        toStr.append("    ];\n");
        return toStr.toString();
    }

    /**
     * @return Returns the educate.
     */
    public Byte getEducate() {
        return educate;
    }
    /**
     * @param educate The educate to set.
     */
    public void setEducate(Byte educate) {
        this.educate = educate;
    }
}
