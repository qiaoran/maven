package com.system.hrSystem.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.HibernateException;

import com.system.hrSystem.dao.UsersDao;
import com.system.hrSystem.entiy.Users;

public class UsersAction extends Action {

    private UsersDao dao=new UsersDao();

	public ActionForward execute(ActionMapping mapping, ActionForm form,
		HttpServletRequest request, HttpServletResponse response) throws Exception {
		String action =request.getParameter("action");
		if(action==null||"".equals(action)){
			return mapping.findForward("error");
		}else if("listuser".equals(action)){
			return listUser(mapping,form,request,response);
		}else if("adduser".equals(action)){
			return addUsers(mapping,form,request,response);
		}else if("logon".equals(action)){
			return logon(mapping,form,request,response);
		}else if("updateuser".equals(action)){
			return updateUser(mapping,form,request,response);
		}else if("deleteuser".equals(action)){
			return deleteUser(mapping,form,request,response);
		}else if("selectuser".equals(action)){
			return selectUser(mapping,form,request,response);
		}
		return mapping.findForward("error");
	}

	private ActionForward selectUser(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
		Long id=new Long(request.getParameter("id"));//���id����
		Users u=dao.loadUsers(id);//���ظ�ID��Ӧ����Ա��Ϣ
		request.setAttribute("user",u);//����Ա��Ϣ���õ�request��Χ
		return mapping.findForward("success");//��ת��success��Ӧ���߼���ͼ
	}
	
	private ActionForward updateUser(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
		UsersForm usersform=(UsersForm)form;//���UsersForm
		Users users=usersform.populate();//����ύ����Ա��Ϣ
		dao.updateUsers(users);//������Ա��Ϣ
		return mapping.findForward("success");//��ת��success��Ӧ���߼���ͼ
	}

	private ActionForward deleteUser(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
		Long id=new Long(request.getParameter("id"));//���id����
		Users users=new Users();//�½�һ��users����
		users.setId(id);//���ø�users�����id
		dao.deleteUsers(users);//ɾ����users����
		return mapping.findForward("success");
	}
    private ActionForward logon(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws HibernateException {
        UsersForm usersform=(UsersForm)form;
        Users users=new Users();
        users.setUsername(usersform.getUsername());
        users.setPassword(usersform.getPassword());
        boolean flag=dao.logonUsers(users);
        if(flag){
            request.getSession().setAttribute("users",users);
            return mapping.findForward("success");
        }else{
        	request.setAttribute("error", "��¼ʧ��");
            return mapping.findForward("failed");
       }
    }

	private ActionForward addUsers(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
	    UsersForm usersform=(UsersForm)form;	//���UsersForm
	    Users users=usersform.populate();		//����ύ����Ա��Ϣ
	    dao.addUsers(users);					//�����Ա��Ϣ����
	    return mapping.findForward("success");	//��ת���ɹ�ҳ��
	}

	private ActionForward listUser(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
	    request.setAttribute("list",dao.listUser());//����Ա��Ϣ�б��浽request��Χ
	    return mapping.findForward("success");		//��ת���ɹ�ҳ��
	}

}
