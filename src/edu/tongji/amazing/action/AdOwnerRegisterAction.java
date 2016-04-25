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
			String username = request.getParameter("username");//公司名称
			String realname = request.getParameter("realname");//法人姓名
			String liscense = request.getParameter("liscense");//广告商制造
			String identity = request.getParameter("identity");//法人身份证
			String phone = request.getParameter("phone");//联系电话
			String mail = request.getParameter("mail");//邮箱
			String avatar = request.getParameter("avatar");//头像
			String password = request.getParameter("password");//密码
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
