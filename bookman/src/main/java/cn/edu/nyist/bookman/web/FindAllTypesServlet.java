package cn.edu.nyist.bookman.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.nyist.bookman.biz.TypeBiz;
import cn.edu.nyist.bookman.biz.impl.TypeBizImpl;
import cn.edu.nyist.bookman.vo.TypeVo;



@WebServlet("/FindAllTypes")
public class FindAllTypesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public FindAllTypesServlet() {
        super();
        
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//获取参数
		//调用业务逻辑
		TypeBiz typeBiz=new TypeBizImpl();
		List<TypeVo> ls=typeBiz.findAllTypes();
		//servelt发动内容到jsp
		//request.setAttribute("ls", ls);
		//request.getRequestDispatcher("bookAdd.jsp").forward(request, response);
		
		
		//jsp到servlet拿数据
        //返回javaScript类型
		response.setContentType("text/javascript;charset=utf-8");
		String js="var types[";
		  for(int i=0;i<ls.size();i++) {
			  js+="{id:"+ls.get(i).getId()+",name:'"+ls.get(i).getName()+"'}";
			  if(i<ls.size()-1) {
				  js+=",";
			  }
		  }
		  js+="]";
		  response.getWriter().write(js);
	}

}
