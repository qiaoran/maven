package com.system.hrSystem.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.system.hrSystem.entiy.Job;
import com.system.hrSystem.util.HibernateSessionFactory;

public class JobDao {

	public void addJob(Job job) throws HibernateException{
	    job.setIsstock(new Byte("0"));//���������ϢΪ0����ʾ��ʱ�����
	    job.setCreatetime(new java.util.Date());//���õ�ǰʱ��
	    Session session = HibernateSessionFactory.getSession();//���Session����
	    Transaction tx = session.beginTransaction();//����������
	    session.save(job);//����ӦƸ��Ա��Ϣ
	    tx.commit();//�ύ����
	    HibernateSessionFactory.closeSession();//�ر�Session����
	}

	public List listJob(byte isstock) throws HibernateException{
		Session session = HibernateSessionFactory.getSession();//���Session����
		Query query = session.createQuery("select j from Job " +
			"as j where j.isstock = :isstock order by createtime");//��ѯ����ӦƸ��Ϣ
		query.setByte("isstock",isstock);//�����Ƿ����
		List list = query.list();//���ӦƸ��Ϣ�б�
		HibernateSessionFactory.closeSession();//�ر�Session����
		return list;
	}

	public Job loadJob(long id){
		Session session = HibernateSessionFactory.getSession();//���Session����
		Job j = (Job) session.get(Job.class,id);//����ָ��ID��ӦƸ��Ϣ
		HibernateSessionFactory.closeSession();//�ر�Session����
		return j;//���ز�ѯ����
	}

	public void deleteJob(Job job) throws HibernateException{
		Session session = HibernateSessionFactory.getSession();//���Session����
		Transaction tx = session.beginTransaction();//����������
		session.delete(job);//ɾ����job����
		tx.commit();//�ύ����
		HibernateSessionFactory.closeSession();//�ر�Session����
	}

    public void updateJob(Job job){
        Job j = loadJob(job.getId().longValue());
        if (job.getAge()!=null){
            j.setAge(job.getAge());
        }
        if(job.getContent()!=null){
            j.setContent(job.getContent());
        }
        if (job.getExperience() != null) {
            j.setExperience(job.getExperience());
        }
        if (job.getIsstock()!= null) {
            j.setIsstock(job.getIsstock());
        }
        if(job.getJob()!=null){
            j.setJob(job.getJob());
        }
        if(job.getName()!=null){
            j.setName(job.getName());
        }
        if(job.getSchool()!=null){
            j.setSchool(job.getSchool());
        }
        if(job.getSex()!=null){
            j.setSex(job.getSex());
        }
        if(job.getSpecialty()!=null){
            j.setSpecialty(job.getSpecialty());
        }
        if(job.getStudyeffort()!=null){
            j.setStudyeffort(job.getStudyeffort());
        }
        if(job.getTel()!=null){
            j.setTel(job.getTel());
        }
        if(job.getEmail()!=null){
            j.setEmail(job.getEmail());
        }
        Session session = HibernateSessionFactory.getSession();
        Transaction tx = session.beginTransaction();
        session.update(j);
        tx.commit();
        HibernateSessionFactory.closeSession();
    }
}
