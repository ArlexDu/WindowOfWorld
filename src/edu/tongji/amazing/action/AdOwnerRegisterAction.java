package edu.tongji.amazing.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

@Controller("adownerregister")
public class AdOwnerRegisterAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void register() throws Exception{
		try{
			HttpServletResponse response = ServletActionContext.getResponse();
			HttpServletRequest request = ServletActionContext.getRequest();
			response.setContentType("text/plain;charset=utf-8");
			PrintWriter out= response.getWriter();
			out.print("true");
			out.flush();
			String username = request.getParameter("username");//��˾����
			String realname = request.getParameter("realname");//��������
			String liscense = request.getParameter("liscense");//���������
			String identity = request.getParameter("identity");//�������֤
			String phone = request.getParameter("phone");//��ϵ�绰
			String mail = request.getParameter("mail");//����
			String avatar = request.getParameter("avatar");//ͷ��
			String password = request.getParameter("password");//����
			System.out.println("username:"+username);
			System.out.println("realname:"+realname);
			System.out.println("liscense:"+liscense);
			System.out.println("identity:"+identity);
			System.out.println("phone:"+phone);
			System.out.println("mail:"+mail);
			System.out.println("avatar:"+avatar);
			System.out.println("password:"+password);
		}catch(Exception e){
			
		}
	}
}
