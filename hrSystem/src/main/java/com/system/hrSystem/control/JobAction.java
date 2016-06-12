package com.system.hrSystem.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.system.hrSystem.dao.JobDao;
import com.system.hrSystem.entiy.Job;

public class JobAction extends Action {
    private JobDao dao=new JobDao();
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {

        String action =request.getParameter("action");
        System.out.println("\nJobAction*********************action="+action);
        if(action==null||"".equals(action)){
            return mapping.findForward("error");
        }else if("listjob".equals(action)){
            return listJob(mapping,form,request,response);
        }else if("addjob".equals(action)){
            return addJob(mapping,form,request,response);
        }else if("deletejob".equals(action)){
            return deleteJob(mapping,form,request,response);
        }else if("updatejob".equals(action)){
            return updateJob(mapping,form,request,response);
        }else if("detailjob".equals(action)){
            return detailjob(mapping,form,request,response);
        }
        return mapping.findForward("error");
    }

	private ActionForward detailjob(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
		Long id=new Long(request.getParameter("id"));//��ò���id
		Job j=dao.loadJob(id.longValue());//���ظ�ID��Ӧ��ӦƸ��Ϣ
		request.setAttribute("job",j);//��ӦƸ��Ϣ�������õ�request��Χ
		return mapping.findForward("success");
	}

    private ActionForward updateJob(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
        JobForm jobform=(JobForm)form;
        Job j=jobform.populate();
        dao.updateJob(j);
        return mapping.findForward("success");
    }

	private ActionForward deleteJob(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
	    Long id=new Long(request.getParameter("id"));//����id����
	    Job j=new Job();//�½�һ��Job����
	    j.setId(id);//������id����
	    dao.deleteJob(j);//����dao�������Job�����ɾ��
	    return mapping.findForward("success");
	}

	private ActionForward addJob(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
	    JobForm jobform=(JobForm)form;//���JobForm
	    Job job=jobform.populate();//��ñ��ύ��ӦƸ��Ϣ
	    dao.addJob(job);//����DAO���ӦƸ��Ϣ�ı���
	    return mapping.findForward("success");//��ת��success�߼���ͼ
	}

	private ActionForward listJob(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
	    String isstock=request.getParameter("isstock");//���isstock����
	    if(isstock==null||"".equals(isstock)){//���isstockΪnull����Ϊ��
	        request.setAttribute("list",
	        		dao.listJob(new Byte("0").byteValue()));//��ѯ����û����ӦƸ��Ϣ
	    }else{
	        request.setAttribute("list",
	        		dao.listJob(new Byte("1").byteValue()));//��ѯ��������ӦƸ��Ϣ
	    }
	    return mapping.findForward("success");
	}
}
