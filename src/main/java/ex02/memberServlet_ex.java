package ex02;
//https://github.com/gilbutITbook/006895/blob/master/pro07/src/sec01/ex01/MemberServlet.java

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*@WebServlet("/member")*/
public class memberServlet_ex extends HttpServlet {
	protected void doGet(HttpServletRequest request,HttpServletResponse response)
                                                    throws ServletException, IOException {
      response.setContentType("text/html;charset=utf-8");
      PrintWriter out=response.getWriter();	
      memberDAO dao=new memberDAO();
      List<memberVO> list=dao.listMembers();
	
      out.print("<html><body>");
      out.print("<table  border=1><tr align='center' bgcolor='lightgreen'>");
      out.print("<td>���̵�</td><td>��й�ȣ</td><td>�̸�</td><td>�̸���</td><td>������</td></tr>");
     
     for (int i=0; i<list.size();i++){
		memberVO memberVO=(memberVO) list.get(i);
		String id=memberVO.getId();
		String pwd = memberVO.getPwd();
		String name=memberVO.getName();
		String email=memberVO.getEmail();
		Date joinDate = memberVO.getJoinDate();
		out.print("<tr><td>"+id+"</td><td>"+
			                pwd+"</td><td>"+
			                name+"</td><td>"+
			                email+"</td><td>"+
			                joinDate+"</td></tr>");		
      }
      out.print("</table></body></html>");
   }
}
